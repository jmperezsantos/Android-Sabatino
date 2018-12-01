package mx.ipn.cic.activitiesexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        //Recibir parámetros

        Intent intent = getIntent();
        if (intent != null) {

            //Recepción de los parámetros
            int entero = intent.getIntExtra("unEntero", -1);
            float flotante = intent.getFloatExtra("unFlotante",
                    -1f);
            String cadena = intent.getStringExtra("unaCadena");

            TextView tvTitle = findViewById(R.id.tvTitle);

            String mensaje = String.format(
                    "Entero: %d Flotante: %f Cadena: %s",
                    entero,
                    flotante,
                    cadena);

            tvTitle.setText(mensaje);

        }

        Button btnAtras = findViewById(R.id.btnBack);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}



