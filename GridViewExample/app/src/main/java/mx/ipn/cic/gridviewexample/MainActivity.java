package mx.ipn.cic.gridviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
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

                navegar(item);

            }
        });

        fillCarrusel();

    }

    private void fillCarrusel() {

        LinearLayout linearLayout = findViewById(R.id.content);
        LayoutInflater inflater = LayoutInflater.from(this);

        for (final SongModel song : SongModel.defaultItems(10)) {

            View view = inflater.inflate(R.layout.layout_gv_item, linearLayout, false);

            TextView title = view.findViewById(R.id.tvTitle);

            title.setText(song.getTitle());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,
                            "Presionó " + song,
                            Toast.LENGTH_LONG).show();

                    navegar(song);
                }
            });

            linearLayout.addView(view);

        }


    }

    private void navegar(SongModel item) {

        Intent intent = new Intent(this, Main2Activity.class);

        intent.putExtra("DATO", item);

        startActivity(intent);

    }


}
