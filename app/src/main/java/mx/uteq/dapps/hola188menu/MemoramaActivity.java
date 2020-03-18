package mx.uteq.dapps.hola188menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MemoramaActivity extends AppCompatActivity {

    private ArrayList<ImageButton> ibCartas;
    private GridLayout glCartas;
    //Contador de tiros
    private int tiros = 0;
    private String tag1;
    private String tag2;

    private ImageButton carta1;
    private ImageButton carta2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorama);

        /*
        Inicializamos al gridLayout
         */
        glCartas = findViewById(R.id.gl_cartas);

        //Inicializamos la lista de botones
        ibCartas = new ArrayList<>();

        //Recorremos cada boton del Grid
        for(int i = 0; i < glCartas.getChildCount(); i++){
            //Guardamos cada boton en el ArrayList
            ibCartas.add(
                    (ImageButton) glCartas.getChildAt(i)
            );
        }
        //Eliminamos todos los botones del GRID
        glCartas.removeAllViews();

        //Ordenar aleatoriamente las
        //cartas
        Collections.shuffle(ibCartas);

        //Recorrer las cartas
        for(ImageButton ib : ibCartas) {
            //Añadimos el boton
            glCartas.addView(ib);
        }
    }

    public void tirar(View v) {
        Toast.makeText(
                this,
                "TAG: " + v.getTag(),
                Toast.LENGTH_SHORT
        ).show();

        //Voltear carta
        voltearCarta((ImageButton) v);

        //Aumentamos los tiros
        tiros++;

        if (tiros == 2) {
            //Guarddamos los dastos
            //De esa carta
            carta2 = (ImageButton) v;
            tag2 = v.getTag().toString();

            //SI LAS CARTAS SON IGUALES
            if(tag1.equals(tag2)) {
                //LAS DESHABILITAMOS
                carta1.setEnabled(false);
                carta2.setEnabled(false);
            }

            else {
                //CARTAS NO SON IGUALES
                //Esperamos 1 segundo para
                //voltear las cartas
                Handler h = new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        carta1.setImageResource(R.drawable.interrogacion);
                        carta2.setImageResource(R.drawable.interrogacion);
                        carta2 = null;
                        tag1 = null;
                        tag2 = "";
                    }
                }, 350);
            }

            //Reiniciamos los tiros
            tiros = 0;
        }

        else {
            //Tomamos la carta 1
            carta1 = (ImageButton) v;
            tag1 = v.getTag().toString();
        }

    }

    /*
    Voltear carta
     */
    public void voltearCarta(ImageButton ib) {
        switch (ib.getTag().toString()) {
            case "1":
                ib.setImageResource(R.drawable.carta1);
                break;
            case "2":
                ib.setImageResource(R.drawable.carta2);
                break;
            case "3":
                ib.setImageResource(R.drawable.carta3);
                break;
            case "4":
                ib.setImageResource(R.drawable.carta4);
                break;
            case "5":
                ib.setImageResource(R.drawable.carta5);
                break;
            case "6":
                ib.setImageResource(R.drawable.carta6);
                break;
        }
    }
}
