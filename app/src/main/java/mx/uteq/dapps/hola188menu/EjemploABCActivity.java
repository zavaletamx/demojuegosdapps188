package mx.uteq.dapps.hola188menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EjemploABCActivity extends AppCompatActivity {

    private List<String> contenidoLista;
    private ListView lvABC;
    private ArrayAdapter adaptador;
    private SwipeRefreshLayout srlABC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_a_b_c);

        contenidoLista = new ArrayList();
        lvABC = findViewById(R.id.lv_abc);
        srlABC = findViewById(R.id.srl_abc);

        contenidoLista.add("23 RZZ - 9000");
        contenidoLista.add("78 AAA - 1450");
        contenidoLista.add("199 ABCD - 200");

        adaptador = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                contenidoLista
        );

        lvABC.setAdapter(adaptador);

        /*
        Click
         */
        lvABC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSeleccionado = lvABC.getItemAtPosition(position).toString();
                //INDEXOF, regresa la pos de un caracter en una cadena de texto
                //Toast.makeText(EjmploABCActivity.this, valorSeleccionado.indexOf(" ")+"", Toast.LENGTH_SHORT).show();

                //substring, retorna una porción de un string en las coordenadas indicadas
                String usuarioId = valorSeleccionado.substring(0,valorSeleccionado.indexOf(" "));
                Toast.makeText(EjemploABCActivity.this, usuarioId, Toast.LENGTH_SHORT).show();

                //A OTRA VENTANA PASANDO PUTEXTRA EL ID
                //VOLLEY Y MOSTRAR EL MISMO FORMULARIO DE INSERTAR CON LOS VALORES

            }
        });

        /*
        LongClick
         */
        lvABC.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSeleccionado = lvABC.getItemAtPosition(position).toString();
                String usuarioId = valorSeleccionado.substring(0,valorSeleccionado.indexOf(" "));
                Toast.makeText(EjemploABCActivity.this, usuarioId, Toast.LENGTH_SHORT).show();

                AlertDialog.Builder alert = new AlertDialog.Builder(EjemploABCActivity.this);
                alert.setTitle("¡Hey!")
                        .setMessage("¿Deseas eliminar a "+valorSeleccionado+"?")
                        .setCancelable(false)
                        .setIcon(android.R.drawable.ic_delete)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //IR A ELIMINAR PASANDO EL ID DEL USUARIO AL SERVICIO
                            }
                        })
                        .setNegativeButton("NO", null)
                        .show();

                return  false;
            }
        });

    }
}
