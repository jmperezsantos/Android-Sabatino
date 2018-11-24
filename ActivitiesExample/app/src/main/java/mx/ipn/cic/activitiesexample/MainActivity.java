package mx.ipn.cic.activitiesexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPassword;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Obtener referencias de UI al código Java
        etUser = this.findViewById(R.id.etUser);
        etPassword = this.findViewById(R.id.etPassword);
        btnEntrar = this.findViewById(R.id.btnLogin);

        //Asignar un comportamiento
        this.btnEntrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                evaluarCampos();

            }

        });

    }

    private void evaluarCampos() {

        Log.i("TAG", "Hola Mundo desde Botón");

        if (etUser.getText().toString().isEmpty() ||
                etPassword.getText().toString().isEmpty()) {
            //Mostrar un mensaje al usuario

            Toast.makeText(this,//getApplicationContext();
                    "Ambos campos deben completarse",
                    Toast.LENGTH_SHORT).show();

        }else {
            //Evaluar si es un usuario válido

            if(etUser.getText().toString().equals("usuario") &&
                    etPassword.getText().toString().equals("123")){

                //Usuario válido
                Toast.makeText(this,//getApplicationContext();
                        "Usuario válido",
                        Toast.LENGTH_LONG).show();

                //Mostrar otra interfaz
                Intent intent = new Intent(this, Main2Activity.class);

                //Envío de parámetros
                intent.putExtra("unEntero", 5);
                intent.putExtra("unFlotante", 5.5f);
                intent.putExtra("unaCadena", "Hola Mundo!");

                startActivity(intent);

            }else {
                //Usuario inválido
                Toast.makeText(this,//getApplicationContext();
                        "Usuario inválido",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}



