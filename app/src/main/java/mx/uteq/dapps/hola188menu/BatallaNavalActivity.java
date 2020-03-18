package mx.uteq.dapps.hola188menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BatallaNavalActivity extends AppCompatActivity {

    private GridLayout gridLayoutj1;
    private GridLayout gridLayoutj2;
    private Button btnIniciar;

    private int barcosJ1 = 0;
    private int barcosJ2 = 0;
    private List<Integer> listaBj1;
    private List<Integer> listaBj2;

    private int turno = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batalla_naval);

        gridLayoutj1 = findViewById(R.id.gl_j1);
        gridLayoutj2 = findViewById(R.id.gl_j2);
        btnIniciar = findViewById(R.id.btn_continuar);

        listaBj1 = new ArrayList<>();
        listaBj2 = new ArrayList<>();

    } //oncreate

    public void tirar(View v) {

        /*
        Acomodamos los barcos de
        ambos jugadores
         */
        if (listaBj2.size() < 6) {
            acomodarBarcos(v);
        }

        /*
        Con todos los barcos acomodados
        ahora si buscamos coincidencias
        al tirar
         */
        else {
            /*
            Tomamos el boton
            Seleccionado
             */
            ImageButton btnSel = (ImageButton) v;
            btnSel.setEnabled(false);

            /*
            Tomamos la posicion del
            tag del boton seleccionado
             */
            int posTag = Integer.parseInt(
                    btnSel.getTag().toString()
            );
            /*
            Si el turno es del jugador 1
             */
            if(turno == 1) {
                /*
                Buscamos si esa posición se encuentra
                en la lista de barcos del jugaodr 2
                 */
                if(listaBj2.contains(posTag)) {
                    /*
                    Cambiamos la imagen por la de un barco hundido
                     */
                    btnSel.setBackgroundResource(R.drawable.hundido);
                }

                /*
                Si en esa pos no hay barco dej j2
                 */
                else {
                    /*
                    Cambiamos la imagen por la de un error
                     */
                    btnSel.setBackgroundResource(R.drawable.nobarco);
                }

                //Cambiamos de turno
                turno = 2;

                //Esperamos 300 milis y Cambiamos de tablero
                //Esperamos 300 milisegundos y Cambiamos de tablero
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gridLayoutj1.setVisibility(View.GONE);
                        gridLayoutj2.setVisibility(View.VISIBLE);
                    }
                }, 300);
            }

            else if (turno == 2) {
                if(listaBj1.contains(posTag)) {
                    btnSel.setBackgroundResource(R.drawable.hundido);
                }

                else {
                    btnSel.setBackgroundResource(R.drawable.nobarco);
                }

                //Cambiamos de turno
                turno = 1;

                //Esperamos 300 milisegundos y Cambiamos de tablero
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gridLayoutj2.setVisibility(View.GONE);
                        gridLayoutj1.setVisibility(View.VISIBLE);
                    }
                }, 300);
            }
        }

    } //tirar

    public void iniciar(View v) {
        /*
        Recorremos todos los botones de ambos GRID para mostrar nuevamente
        la imgen de la mira
        y habilitar todos
         */
        ImageButton btn;
        for (int i = 0; i < gridLayoutj1.getChildCount(); i++) {
            btn = (ImageButton) gridLayoutj1.getChildAt(i);
            btn.setBackgroundResource(R.drawable.mira);
            btn.setEnabled(true);
        }

        for (int i = 0; i < gridLayoutj2.getChildCount(); i++) {
            btn = (ImageButton) gridLayoutj2.getChildAt(i);
            btn.setBackgroundResource(R.drawable.mira);
            btn.setEnabled(true);
        }

        /*
        Pasamos el turno al jugador 1
         */
        turno = 1;

        /*
        Mostramos el tablero del J1
         */
        gridLayoutj1.setVisibility(View.VISIBLE);
        gridLayoutj2.setVisibility(View.GONE);

        /*
        Ocultamos el boton iniciar
         */
        btnIniciar.setVisibility(View.GONE);

    } //iniciar

    public void acomodarBarcos(View v) {
        //Tomamos la info. del ImageButton
        //seleciconado
        ImageButton btnSel = (ImageButton) v;

        //Deshabilitamos el boton seleccionado
        btnSel.setEnabled(false);

        /*
        Si el turno es para el jugador 1, mostramos
        su tablero
         */
        if (turno == 1) {

            //Mostramos un barco en la posicion seleccionada
            btnSel.setBackgroundResource(R.drawable.barquito1);

            /*
            Agregamos el tag de la posición de ese boton a
            la lista de barcos del jugador
             */
            listaBj1.add(
                    Integer.parseInt(
                            btnSel.getTag().toString()
                    )
            );

            /*
            Cuando lleguemos a 6 barcos del turno 1
            Mostramos un mensaje para indicar que
            ahora se acmodarán los barcos del jugador 2
             */
            if (listaBj1.size() == 6) {
                AlertDialog.Builder alerta;
                alerta = new AlertDialog.Builder(this);
                alerta.setTitle("Listo");
                alerta.setMessage("<<Jugador 2>>\nPosiciona tus barcos");
                alerta.setCancelable(false);
                alerta.setNeutralButton(
                        "Continuar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                gridLayoutj1.setVisibility(View.GONE);
                                gridLayoutj2.setVisibility(View.VISIBLE);
                                turno = 2;
                            }
                        }
                );
                alerta.show();
            }
        }

        if (turno == 2) {
            btnSel.setBackgroundResource(R.drawable.barquito2);
            listaBj2.add(
                    Integer.parseInt(
                            btnSel.getTag().toString()
                    )
            );

            /*
            Cuando lleguemos a 6 barcos del turno 2
            Habilitamos el boton continuar y ocultamos
            ambos Grids
             */
            if (listaBj2.size() == 6) {
                AlertDialog.Builder alerta;
                alerta = new AlertDialog.Builder(this);
                alerta.setTitle("Listo");
                alerta.setMessage("A jugar!");
                alerta.setCancelable(false);
                alerta.setNeutralButton(
                        "Entendido",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                gridLayoutj2.setVisibility(View.GONE);
                                btnIniciar.setEnabled(true);
                            }
                        }
                );
                alerta.show();
            }
        }
    } //Acomodarbarcos
}
