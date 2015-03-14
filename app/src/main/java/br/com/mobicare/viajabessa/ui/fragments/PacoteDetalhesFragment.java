package br.com.mobicare.viajabessa.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;

import br.com.mobicare.viajabessa.R;
import br.com.mobicare.viajabessa.events.PacoteListagemItemClickEvent;
import br.com.mobicare.viajabessa.models.Pacote;
import br.com.mobicare.viajabessa.utils.BusProvider;
import br.com.mobicare.viajabessa.utils.PicassoCache;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class PacoteDetalhesFragment extends Fragment {
    private Pacote mPacote;

    @InjectView(R.id.pacote_nome)
    TextView textViewPacoteNome;

    @InjectView(R.id.pacote_foto)
    ImageView imageViewPacoteFoto;

    @InjectView(R.id.pacote_valor)
    TextView textViewPacoteValor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceBundle) {
        View view = inflater.inflate(R.layout.fragment_pacote_detalhes, null);
        ButterKnife.inject(this, view);
        carregarParametros();
        carregarUi();
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

    private void carregarParametros() {
        if (getArguments() != null) {
            mPacote = (Pacote) getArguments().getSerializable(getString(R.string.pacote_selecionado));
        } else {
            mPacote = new Pacote();
        }
    }

    private void carregarUi() {
        textViewPacoteNome.setText(mPacote.getNome());
        textViewPacoteValor.setText(String.format(getString(R.string.format_money), mPacote.getValor()));
        PicassoCache.getInstance(getActivity())
                .load(mPacote.getFoto())
                .resize(50, 50)
                .centerCrop()
                .into(imageViewPacoteFoto);
    }

}
