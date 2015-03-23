package br.com.mobicare.viajabessa.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFlat;
import com.gc.materialdesign.views.ButtonRectangle;
import com.gc.materialdesign.widgets.SnackBar;

import br.com.mobicare.viajabessa.R;
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

    @InjectView(R.id.pacote_descricao)
    TextView textViewDescricao;

    @InjectView(R.id.button_comprar)
    Button buttonComprar;

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
        textViewDescricao.setText(mPacote.getDescricao());
        PicassoCache.getInstance(getActivity())
                .load(mPacote.getFoto())
                .fit()
                .centerCrop()
                .into(imageViewPacoteFoto);
        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SnackBar snackbar = new SnackBar(getActivity(), getString(R.string.error_network_problem), getString(R.string.dialog_tryagain), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonComprar.performClick();
                    }
                });
                snackbar.show();
            }
        });
    }

}
