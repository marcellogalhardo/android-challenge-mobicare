package br.com.mobicare.viajabessa.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.mobicare.viajabessa.R;
import br.com.mobicare.viajabessa.models.Pacote;
import br.com.mobicare.viajabessa.utils.PicassoCache;
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
        mViewHolder.textViewNome.setText(mPacotes.get(position).getNome());
        mViewHolder.textViewValor.setText(String.format(mContext.getString(R.string.format_money),
                mPacotes.get(position).getValor()));
        PicassoCache.getInstance(mContext)
                .load(mPacotes.get(position).getFoto())
                .fit()
                .centerCrop()
                .into(mViewHolder.imageViewFoto);
        return convertView;
    }

    public static class ViewHolder {
        @InjectView(R.id.pacote_nome)
        TextView textViewNome;

        @InjectView(R.id.pacote_foto)
        ImageView imageViewFoto;

        @InjectView(R.id.pacote_valor)
        TextView textViewValor;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
