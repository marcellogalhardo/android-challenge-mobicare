package br.com.mobicare.viajabessa.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import br.com.mobicare.viajabessa.R;
import br.com.mobicare.viajabessa.events.PacoteListagemItemClickEvent;
import br.com.mobicare.viajabessa.models.Pacote;
import br.com.mobicare.viajabessa.ui.adapters.PacoteListagemListViewAdapter;
import br.com.mobicare.viajabessa.utils.BusProvider;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class PacoteListagemFragment extends Fragment {
    private List<Pacote> mPacotes;
    private PacoteListagemListViewAdapter mPacoteListagemListViewAdapter;
    @InjectView(R.id.listview_pacote) ListView mListViewPacote;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceBundle) {
        View view = inflater.inflate(R.layout.fragment_pacote_listagem, null);
        ButterKnife.inject(this, view);
        configurarListView();
        return view;
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

    private void configurarListView() {
        Pacote pacote = new Pacote();
        pacote.setNome("Marcello");
        mPacotes = new ArrayList<Pacote>();
        mPacotes.add(pacote);

        mPacoteListagemListViewAdapter = new PacoteListagemListViewAdapter(getActivity(), mPacotes);
        mListViewPacote.setAdapter(mPacoteListagemListViewAdapter);
        mListViewPacote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BusProvider.getInstance().post(new PacoteListagemItemClickEvent(parent, view, position, id));
            }
        });
    }

}
