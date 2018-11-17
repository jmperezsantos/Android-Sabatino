package mx.ipn.cic.interactionexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Obtener las referencias de los objetos en la UI
        final TextView tvOutput = findViewById(R.id.tvSaludo);
        final EditText etInput = findViewById(R.id.etEntrada);
        Button btnProcess = findViewById(R.id.btnPresiona);

        //Al botón asignarle un "comportamiento" (tap)
        btnProcess.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "Se presionó el botón (anónima)");

                //Dentro del comportamiento, al presionar el botón
                //  El texto ingresado en el EditText mostrarlo en el TextView
                //  Borrar el texto del EditText (vaciarlo)

                String texto = etInput.getText().toString();

                etInput.setText(null);
                tvOutput.setText(texto);

            }
        });

    }

}


















