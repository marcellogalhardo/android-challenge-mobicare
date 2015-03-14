package br.com.mobicare.viajabessa.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.squareup.otto.Subscribe;

import java.util.List;

import br.com.mobicare.viajabessa.R;
import br.com.mobicare.viajabessa.events.ObtemPacotesTaskConcluidaEvent;
import br.com.mobicare.viajabessa.events.ObtemPacotesTaskFalhaEvent;
import br.com.mobicare.viajabessa.events.PacoteListagemAtualizarEvent;
import br.com.mobicare.viajabessa.events.PacoteListagemItemClickEvent;
import br.com.mobicare.viajabessa.models.Pacote;
import br.com.mobicare.viajabessa.ui.adapters.PacoteListagemListViewAdapter;
import br.com.mobicare.viajabessa.utils.BusProvider;
import br.com.mobicare.viajabessa.utils.OrmLiteHelper;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class PacoteListagemFragment extends Fragment {
    private List<Pacote> mPacotes;
    private PacoteListagemListViewAdapter mPacoteListagemListViewAdapter;
    @InjectView(R.id.listview_pacote)
    ListView listViewPacote;

    @InjectView(R.id.swipe_container)
    SwipeRefreshLayout swipeRefreshLayoutPacotes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceBundle) {
        View view = inflater.inflate(R.layout.fragment_pacote_listagem, null);
        ButterKnife.inject(this, view);
        mPacotes = obterPacotes();
        configurarListView();
        configurarSwipeRefreshLayout();
        return view;
    }

    @Subscribe
    public void ObtemPacotesTaskConcluida(ObtemPacotesTaskConcluidaEvent evento) {
        mPacotes.clear();
        mPacotes.addAll(evento.pacotes);
        mPacoteListagemListViewAdapter.notifyDataSetChanged();
        swipeRefreshLayoutPacotes.setRefreshing(false);
    }

    @Subscribe
    public void ObtemPacotesTaskFalha(ObtemPacotesTaskFalhaEvent evento) {
        swipeRefreshLayoutPacotes.setRefreshing(false);
        Toast.makeText(getActivity(), getString(R.string.error_network_problem), Toast.LENGTH_SHORT).show();
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

    private void configurarSwipeRefreshLayout() {
        swipeRefreshLayoutPacotes.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                BusProvider.getInstance().post(new PacoteListagemAtualizarEvent());
            }
        });
    }

    private List<Pacote> obterPacotes() {
        RuntimeExceptionDao<Pacote, Integer> pacoteDao =
                OrmLiteHelper.getInstance(getActivity()).getRuntimeDao(Pacote.class);
        return pacoteDao.queryForAll();
    }

    private void configurarListView() {
        mPacoteListagemListViewAdapter = new PacoteListagemListViewAdapter(getActivity(), mPacotes);
        listViewPacote.setAdapter(mPacoteListagemListViewAdapter);
        listViewPacote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BusProvider.getInstance().post(new PacoteListagemItemClickEvent(parent, view, position, id));
            }
        });
    }

}
