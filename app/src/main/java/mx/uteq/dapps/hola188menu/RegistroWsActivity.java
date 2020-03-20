package mx.uteq.dapps.hola188menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistroWsActivity extends AppCompatActivity {

    private EditText etNombre, etScore;
    private ProgressBar pbRegistro;

    private String nombre;
    private String score;

    /*
    Para conectarnos remotamente a un servicios, necesitamos
     */
    private RequestQueue conexionServidor;
    private StringRequest peticionServidor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ws);

        etNombre = findViewById(R.id.et_nombre);
        etScore = findViewById(R.id.et_score);
        pbRegistro = findViewById(R.id.pb_registro);

        //Inicializamos la variable a la conexion
        conexionServidor = Volley.newRequestQueue(this);

    }

    public void registroWs(final View v) {

        //Validar el contenido de los ET
        nombre = etNombre.getText().toString().toUpperCase();
        score =  etScore.getText().toString();

        /*
        Inhabilitar el form
         */
        etNombre.setText("");
        etNombre.setEnabled(false);
        etScore.setText("");
        etScore.setEnabled(false);
        v.setEnabled(false);

        pbRegistro.setVisibility(View.VISIBLE);

        /*
        1.- TIPO DE PETICION (GET/POST)
        2.- URL DONDE ESTA EL SERVICIO
        3.- ACCION SI EL SERVICIO FUNCIONA
        4.- ACCION SI SE GENERA UN ERROR
        5.- SI ES POST, PASAR VARIABLES
         */
        peticionServidor = new StringRequest(
                Request.Method.POST,
                "http://otmintegs.sytes.net:9000/aws-demo/index.php/servicios/create_score",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Convertimos la respuesta a JSON
                        Toast.makeText(RegistroWsActivity.this, response, Toast.LENGTH_LONG).show();
                        limpiarCampos(v);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Mostrar el error
                        Toast.makeText(RegistroWsActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                        limpiarCampos(v);
                    }
                }
        ){
            //Metodo que pasa los parametros al servicio
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<>();
                //Nombrar cada valor con el nombre de
                //A LA DERECHA su variable eq. en php (CodeIgniter)
                //A LA IZQUIERDA el valor de ANDROID
                parametros.put("nombre", nombre);
                parametros.put("score", score);

                return parametros;
            }
        };
        //Ejecutar el servicio
        conexionServidor.add(peticionServidor);

    } //registroWs

    public void limpiarCampos(View btn) {
        etNombre.setEnabled(true);
        etScore.setEnabled(true);
        btn.setEnabled(true);
        pbRegistro.setVisibility(View.GONE);
    }

}
