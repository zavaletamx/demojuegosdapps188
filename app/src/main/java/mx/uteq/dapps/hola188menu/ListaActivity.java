package mx.uteq.dapps.hola188menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;

public class ListaActivity extends AppCompatActivity {

    private ListView lvLp;
    /*
    Uso de un adaptador

    ++ Colecciones generiucas
     */
    private ArrayAdapter<String> adaptador;
    private ArrayList<String> lenProgra;
    private SwipeRefreshLayout srlLp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lenProgra = new ArrayList<>();

        for(int i = 1; i<=20; i++) {
            lenProgra.add("Java");
            lenProgra.add("PHP");
            lenProgra.add("Python");
            lenProgra.add("JavaScript");
            lenProgra.add("React");
        }

        lvLp = findViewById(R.id.lv_lp);
        srlLp = findViewById(R.id.srl_lp);

        /*
        1.- Contexto (NOM_CLASE.this)
        2.- Diseño de la lista
        3.- Coleccion de valores
         */
        adaptador = new ArrayAdapter<>(
                ListaActivity.this,
                android.R.layout.simple_list_item_1,
                lenProgra
        );

        //indicamos
        // en que se va a mostrar el adaptador
        lvLp.setAdapter(adaptador);

        //EVENTO SWIPE
        srlLp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //ORTDENAMOS LOS COMPONENTES
                Collections.sort(lenProgra);

                //INDICAMOS LOS CAMBIOS
                //A LA VISTA
                adaptador.notifyDataSetChanged();

                //Ocultar LOADER
                srlLp.setRefreshing(false);
            }
        });

        //EVENTO QUE SE DISPARA AL SELECCIONAR
        //UN ELEMENTO DE LA LISTA
        lvLp.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String texto = lvLp.getItemAtPosition(
                                position
                        ).toString();

                        Toast.makeText(
                                ListaActivity.this,
                                "Pos: " + position +
                                        " Elemento:" + texto,
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

    } //ONCREATE

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta;
        alerta = new AlertDialog.Builder(this);
        alerta.setTitle("¡Aguas!");
        alerta.setMessage("¿Deseas salir?");
        alerta.setCancelable(false);
        alerta.setIcon(
                android.R.drawable.ic_dialog_info
        );

        alerta.setPositiveButton(
                "SI, amonos!",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(
                                new Intent(
                                        ListaActivity.this,
                                        LoginActivity.class
                                )
                        );
                    }
                }
        );
        alerta.setNeutralButton(
                "NO", null
        );
        alerta.show();
    }
} //CLASE
