package mx.ipn.cic.gridviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import mx.ipn.cic.gridviewexample.model.SongModel;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvArtist = findViewById(R.id.tvArtist);
        ImageView ivAlbum = findViewById(R.id.ivImage);

        Intent intent = getIntent();

        SongModel dato = (SongModel)
                intent.getSerializableExtra("DATO");

        tvTitle.setText(dato.getTitle());
        tvArtist.setText(dato.getArtist());

        ivAlbum.setImageResource(dato.getImage());

    }
}
