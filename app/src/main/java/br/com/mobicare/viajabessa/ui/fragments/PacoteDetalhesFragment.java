package br.com.mobicare.viajabessa.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.mobicare.viajabessa.R;
import br.com.mobicare.viajabessa.utils.BusProvider;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class PacoteDetalhesFragment extends Fragment {
    @InjectView(R.id.pacote_nome)
    TextView nome;

    @InjectView(R.id.pacote_foto)
    ImageView foto;

    @InjectView(R.id.pacote_valor)
    TextView valor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceBundle) {
        View view = inflater.inflate(R.layout.fragment_pacote_detalhes, null);
        ButterKnife.inject(this, view);
        mockUi();
        return view;
    }

    @Override public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    private void mockUi() {
        nome.setText("Teste");
    }

}
