package mx.uteq.dapps.hola188menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegGatoActivity extends AppCompatActivity {

    //1.- Crear atributos de los elementos
    //    que deseo controlar
    private EditText etJugador1, etJugador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_gato);

        /*
        2.- Ligar los atributos de esta clase
            con los elementos de la vista (XML)
         */
        etJugador1 = findViewById(R.id.et_j1);
        etJugador2 = findViewById(R.id.et_j2);

    } //ONCREATE

    //Click del boton iniciar
    public void aJugar(View v) {
        //Tomar los valores de los campos
        //y guardarlos en variables locales
        final String j1 = etJugador1.
                getText().
                toString();

        final String j2 = etJugador2.
                getText().
                toString();

        /*
        PASAR LOS JUGADORES A LA SIGUIENTE
        ACTIVIDAD
        putExtra("NOMBRE", VALOR)

        Cambiamos de actividad y mandamos
        los nombres de los jugadores
        */
        startActivity(
            new Intent(
                    RegGatoActivity.this,
                    GatoActivity.class
            )
            .putExtra("jugador1", j1)
            .putExtra("jugador2", j2)
        );

    }

} //CLASE
