package mx.ipn.cic.gridviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

import mx.ipn.cic.gridviewexample.R.layout;
import mx.ipn.cic.gridviewexample.adapter.SongsAdapter;
import mx.ipn.cic.gridviewexample.model.SongModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_main);

        GridView gridView = findViewById(R.id.gvCuadricula);

        List<SongModel> items = SongModel.defaultItems(20);
        SongsAdapter songsAdapter = new SongsAdapter(items);

        gridView.setAdapter(songsAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view,
                                    int position,
                                    long elementId) {

                Adapter adapter = adapterView.getAdapter();
                SongModel item = (SongModel) adapter.getItem(position);

                Toast.makeText(getApplicationContext()
                        , "Presionó: " + item,
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}
