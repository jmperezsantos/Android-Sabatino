package mx.ipn.cic.listviewexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mx.ipn.cic.listviewexample.R;
import mx.ipn.cic.listviewexample.model.SongModel;


public class ListViewAdapter extends BaseAdapter {

    private List<SongModel> list;

    /**
     * Constructor personalizado, recibe la lista de canciones.
     * @param songs
     */
    public ListViewAdapter(List<SongModel> songs) {

        this.list = songs;

    }

    /**
     * @return Regresa el número de items a mostrar en la interfaz
     */
    @Override
    public int getCount() {

        return list.size();

    }

    /**
     * @param position índice del elemento en la colección
     * @return Regresa el elemento de la lista "lógica" en la posición "position"
     */
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    /**
     * @param position
     * @return Regresa el "id (hashcode)" del elemento de la lista "lógica" en la posición "position"
     */
    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    /**
     * @param position     índice del elemento a mostrar
     * @param reusableView Vista "reutilizable" de la Interfaz
     * @param viewGroup    Vista "contenedora" de los items
     * @return Vista "contenedora" de los items
     */
    @Override
    public View getView(int position, View reusableView, ViewGroup viewGroup) {

        //Si la vista a reutilizar es nula, se debe construir
        if (reusableView == null) {

            Context context = viewGroup.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            reusableView = inflater.inflate(R.layout.layout_item,
                    viewGroup,
                    false);

        }

        //Se obtiene el objeto en la posición "position"
        SongModel song = (SongModel) getItem(position);

        //Se asignan las propiedades a los elementos en la UI

        TextView tvTitle = reusableView.findViewById(R.id.tvSongName);
        tvTitle.setText(song.getName());

        TextView tvArtist = reusableView.findViewById(R.id.tvArtist);
        tvArtist.setText(song.getArtist());

        //Se regresa la vista ya configurada
        return reusableView;
    }
}








