package mx.uteq.dapps.hola188menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaRemotaActivity extends AppCompatActivity {

    private SwipeRefreshLayout srlListaRemota;
    private ListView lvListaRemota;
    private ArrayAdapter<String> adaptador;
    private ArrayList<String> listaDatos;

    private RequestQueue conexionServidor;
    private StringRequest peticionServidor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_remota);

        srlListaRemota = findViewById(R.id.srl_lista_remota);
        lvListaRemota = findViewById(R.id.lv_lista_remota);
        listaDatos = new ArrayList<>();

        /*
        Ligar el contenido del AL con el adaptador
         */
        adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listaDatos
        );

        lvListaRemota.setAdapter(adaptador);

        conexionServidor = Volley.newRequestQueue(this);

        /*
        Al inicio, invocar al Swipe y mostrar el contenido
         */
        srlListaRemota.post(new Runnable() {
            @Override
            public void run() {
                srlListaRemota.setRefreshing(true);
                consultaScores();
            }
        });

        /*
        Evento Swipe
         */
        srlListaRemota.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srlListaRemota.setRefreshing(true);
                consultaScores();
            }
        });

    } //ONCREATE

    /*
    Metodo que consume el servicio que retorna la lista
    de Scores
     */
    public void consultaScores() {
        /*
            1.- TIPO DE PETICION (GET/POST)
            2.- URL DONDE ESTA EL SERVICIO
            3.- ACCION SI EL SERVICIO FUNCIONA
            4.- ACCION SI SE GENERA UN ERROR
            5.- SI ES POST, PASAR VARIABLES
         */
        peticionServidor = new StringRequest(
                Request.Method.GET,
                "http://otmintegs.sytes.net:9000/aws-demo/index.php/servicios/get_scores",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        /*
                        Intentar convertir response en Objeto JSON
                         */
                        try {
                            JSONObject objResp = new JSONObject(response);
                            Toast.makeText(
                                    ListaRemotaActivity.this,
                                    objResp.getString("mensaje"),
                                    Toast.LENGTH_SHORT
                            ).show();

                            /*
                            Tomar el arreglo de la pos 'lista_score'
                             */
                            JSONArray listaScore = objResp.getJSONArray("lista_score");

                            /*
                            Eliminar el contenido anterior
                             */
                            listaDatos.clear();

                            /*
                            For para agregar cada objeto json a la lista
                            del Adaptador
                             */
                            for(int i = 0; i < listaScore.length(); i++) {
                                //Creamos un objeto para cada elemento
                                JSONObject score = listaScore.getJSONObject(i);

                                //Agregamos los valores a la lista del adaptador
                                listaDatos.add(
                                        score.getString("nombre") + " - " + score.getInt("score") + "pts."
                                );
                            }

                            //Actualizo el adaptador
                            adaptador.notifyDataSetChanged();

                        }
                        catch(Exception ex) {
                            Toast.makeText(
                                    ListaRemotaActivity.this,
                                    "ERROR :( -----> "+ex.getMessage(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        srlListaRemota.setRefreshing(false);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(
                                ListaRemotaActivity.this,
                                "ERROR :( -----> "+error.getMessage(),
                                Toast.LENGTH_SHORT
                        ).show();

                        srlListaRemota.setRefreshing(false);
                    }
                }
        );
        //Ejecutar servicio
        conexionServidor.add(peticionServidor);
    }
}
