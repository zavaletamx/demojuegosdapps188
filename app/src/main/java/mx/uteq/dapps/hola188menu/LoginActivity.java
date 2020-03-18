package mx.uteq.dapps.hola188menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    /*
    Agregamos como atributos PRIVADOS
    cada componente grafico que deseamos
    controlar
     */
    private EditText etTelefono;
    private EditText etPin;

    private final String miTel = "4422048329";
    private final String miPin = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*
        Ligamos los ementos graficos
        con nuestros tributos por medio
        del metodo findViewById(R.id.__EL_ID__
         */
        etTelefono = findViewById(R.id.et_telefono);
        etPin = findViewById(R.id.et_pin);

    } // ONCREATE

    //Metodo que se invocara en el clic
    //del boton

    public void login (View v) {

        final String telefono = etTelefono.getText().toString();
        final String pin = etPin.getText().toString();

        //SI CUALQUIERA DE LOS DOS NO COINCIDE
        //MUESTRA UN TOAST
        if (!telefono.equals(miTel) ||
                !pin.equals(miPin)) {
            Toast.makeText(
                    this,
                    "TEL / PASS INCORRECTOS",
                    Toast.LENGTH_LONG
            ).show();

            /* alerta modal */
            AlertDialog.Builder alerta =
                    new AlertDialog.Builder(this);

            alerta.setTitle("¡Hey!");
            alerta.setMessage("Tel / Pin INCORRECTOS");
            alerta.setPositiveButton(
                    "Positive",  null
            );
            alerta.setNegativeButton(
                    "Negative", null
            );
            alerta.setNeutralButton(
                    "Neutral", null
            );
            alerta.setCancelable(false);
            alerta.setIcon(
                    android.R.drawable.ic_dialog_alert
            );
            alerta.show();
        }

        //Cuando todos los datos son correctos
        else {
            //Redireccionamos
            //a la siguiente actividad
            startActivity(
                    new Intent(
                            LoginActivity.this,
                            ListaActivity.class
                    )
            );
        }
    }
}
