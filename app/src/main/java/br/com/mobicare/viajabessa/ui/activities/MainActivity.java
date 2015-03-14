package br.com.mobicare.viajabessa.ui.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import br.com.mobicare.viajabessa.R;
import br.com.mobicare.viajabessa.events.PacoteListagemItemClickEvent;
import br.com.mobicare.viajabessa.ui.fragments.PacoteDetalhesFragment;
import br.com.mobicare.viajabessa.ui.fragments.PacoteListagemFragment;
import br.com.mobicare.viajabessa.utils.BusProvider;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configurarPacoteListagemFragment();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Subscribe
    public void PacoteListagemItemClick(PacoteListagemItemClickEvent event) {
        configurarPacoteDetalhesFragment();
    }

    private void configurarPacoteListagemFragment() {
        PacoteListagemFragment fragment = new PacoteListagemFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content,  fragment);
        fragmentTransaction.commit();
    }

    private void configurarPacoteDetalhesFragment() {
        PacoteDetalhesFragment fragment = new PacoteDetalhesFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_content,  fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
