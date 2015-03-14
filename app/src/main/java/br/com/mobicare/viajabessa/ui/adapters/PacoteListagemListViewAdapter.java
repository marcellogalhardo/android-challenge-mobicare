package br.com.mobicare.viajabessa.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.mobicare.viajabessa.R;
import br.com.mobicare.viajabessa.models.Pacote;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class PacoteListagemListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<Pacote> mPacotes;
    private LayoutInflater mInflater;

    public PacoteListagemListViewAdapter(Context mContext, List<Pacote> mPacotes) {
        this.mContext = mContext;
        this.mPacotes = mPacotes;
        mInflater = LayoutInflater.from(this.mContext);
    }

    @Override
    public int getCount() {
        return mPacotes.size();
    }

    @Override
    public Object getItem(int position) {
        return mPacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if(convertView == null) {
            convertView = mInflater.inflate(R.layout.listview_pacote_listagem, null);
            mViewHolder = new ViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mTextViewNome.setText(mPacotes.get(position).getNome());
        return convertView;
    }

    public static class ViewHolder {
        @InjectView(R.id.pacote_nome)
        TextView mTextViewNome;

        @InjectView(R.id.pacote_foto)
        ImageView mImageViewFoto;

        @InjectView(R.id.pacote_valor)
        TextView mTextViewValor;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
