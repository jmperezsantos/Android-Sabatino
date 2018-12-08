package mx.ipn.cic.gridviewexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mx.ipn.cic.gridviewexample.R;
import mx.ipn.cic.gridviewexample.model.SongModel;

/**
 * En los adaptadores SIEMPRE se debe agregar un
 * constructor que reciba la colección de elementos
 * a mostrar en la interfaz (List<E>, Object[], Collection)
 */

public class SongsAdapter extends BaseAdapter {

    private List<SongModel> list;

    public SongsAdapter(List<SongModel> lista) {
        this.list = lista;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position,
                        View reusableView,
                        ViewGroup container) {

        //Si la vista a mostrar es nula, se debe construir.
        if (reusableView == null) {

            Context context = container.getContext();

            LayoutInflater inflater =
                    LayoutInflater.from(context);

            reusableView = inflater.inflate(R.layout.layout_gv_item,
                    container,
                    false);

        }

        //SongModel song = this.list.get(position);
        SongModel song = (SongModel) getItem(position);

        TextView tvTitle =
                reusableView.findViewById(R.id.tvTitle);

        ImageView ivImage =
                reusableView.findViewById(R.id.ivImage);

        tvTitle.setText(song.getTitle());

        ivImage.setImageResource(song.getImage());

        return reusableView;
    }
}



