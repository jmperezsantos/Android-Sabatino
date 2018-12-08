package mx.ipn.cic.listviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.ipn.cic.listviewexample.adapters.ListViewAdapter;
import mx.ipn.cic.listviewexample.model.SongModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvLista = findViewById(R.id.lvLista);

        final ListViewAdapter listViewAdapter = new ListViewAdapter(generateList(10));

        lvLista.setAdapter(listViewAdapter);

        lvLista.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, //ListView
                                            View view, //Vista presionada
                                            int position, //Posición del elemento presionado
                                            long id //Id del elemento presionado
                    ) {

                        Adapter adapter = adapterView.getAdapter();

                        SongModel song = (SongModel) adapter.getItem(position);

                        Toast.makeText(getApplicationContext(),
                                "Se presionó " + song.getName(),
                                Toast.LENGTH_LONG).show();

                    }
                }
        );

    }

    private List<SongModel> generateList(int items) {

        List<SongModel> aux = new ArrayList<>();

        for (int x = 1; x <= items; x++) {

            SongModel song = new SongModel("Nombre " + x,
                    "Artista " + x);
            aux.add(song);

        }

        return aux;
    }
}
