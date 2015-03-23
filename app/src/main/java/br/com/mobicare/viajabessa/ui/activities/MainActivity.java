package br.com.mobicare.viajabessa.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.squareup.otto.Subscribe;

import java.util.List;

import br.com.mobicare.viajabessa.R;
import br.com.mobicare.viajabessa.ViajabessaApplication;
import br.com.mobicare.viajabessa.events.ObtemPacotesTaskConcluidaEvent;
import br.com.mobicare.viajabessa.events.PacoteListagemAtualizarEvent;
import br.com.mobicare.viajabessa.events.PacoteListagemItemClickEvent;
import br.com.mobicare.viajabessa.models.Pacote;
import br.com.mobicare.viajabessa.tasks.ObtemPacotesTask;
import br.com.mobicare.viajabessa.ui.fragments.PacoteDetalhesFragment;
import br.com.mobicare.viajabessa.ui.fragments.PacoteListagemFragment;
import br.com.mobicare.viajabessa.utils.BusProvider;
import br.com.mobicare.viajabessa.utils.OrmLiteHelper;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            atualizarPacotes();
            configurarPacoteListagemFragment();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Subscribe
    public void PacoteListagemItemClick(PacoteListagemItemClickEvent evento) {
        Pacote pacoteSelecionado = (Pacote) evento.parent.getItemAtPosition(evento.position);
        Bundle bundle = new Bundle();
        bundle.putSerializable(getString(R.string.pacote_selecionado), pacoteSelecionado);
        configurarPacoteDetalhesFragment(bundle);
    }

    @Subscribe
    public void PacoteListagemAtualizar(PacoteListagemAtualizarEvent evento) {
        iniciarObtemPacoteTask();
    }

    @Subscribe
    public void ObtemPacotesTaskConcluida(ObtemPacotesTaskConcluidaEvent evento) {
        List<Pacote> pacotes = evento.pacotes;
        RuntimeExceptionDao<Pacote, Integer> pacoteDao =
                OrmLiteHelper.getInstance(this).getRuntimeDao(Pacote.class);

        for (Pacote pacote: pacotes) {
            pacoteDao.createOrUpdate(pacote);
        }
    }

    private void atualizarPacotes() {
        RuntimeExceptionDao<Pacote, Integer> pacoteDao =
                OrmLiteHelper.getInstance(this).getRuntimeDao(Pacote.class);
        if (pacoteDao.countOf() <= 0) {
            iniciarObtemPacoteTask();
        }
    }

    private void configurarPacoteListagemFragment() {
        PacoteListagemFragment fragment = new PacoteListagemFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_content,  fragment);
        transaction.commit();
    }

    private void configurarPacoteDetalhesFragment(Bundle parametros) {
        PacoteDetalhesFragment fragment = new PacoteDetalhesFragment();
        fragment.setArguments(parametros);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_content,  fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void iniciarObtemPacoteTask() {
        ViajabessaApplication application = (ViajabessaApplication) getApplication();
        ObtemPacotesTask task = new ObtemPacotesTask();
        application.getTaskManager().register(task);
        task.execute();
    }

}
