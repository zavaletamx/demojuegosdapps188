package mx.uteq.dapps.hola188menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlackjackActivity extends AppCompatActivity {

    /*
    Elementos gráficos del 21
     */
    private GridLayout gridLayoutCrupier;
    private GridLayout gridLayoutJugador;
    private TextView tvPtsJugador;
    private TextView tvPtsCrupier;

    /*
    Components lógicos del juego
     */
    private List<ImageView> naipes;
    private int puntosJugador;
    private int puntosCrupier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blackjack);

        /*
        Inicializamos los componentes
         */
        gridLayoutCrupier = findViewById(R.id.gl_crupier);
        gridLayoutJugador = findViewById(R.id.gl_jugador);
        tvPtsJugador = findViewById(R.id.tv_pts_jugador);
        tvPtsCrupier = findViewById(R.id.tv_pts_crupier);

        naipes = new ArrayList<>();
        puntosJugador = 0;
        puntosCrupier = 0;

        /*
        Armamos nuestro ArrayList de cartas
         */
        iniciarCartas();

        /*
        Para iniciar el juego, tomamos 2 cartas
        Una para el jugador y una para el crupier
         */
        tomarNaipe(1);
        tomarNaipe(2);

    } //onCreate

    /*
     * Método que inicializa el arreglo
     * de ImageButton con la información
     * de cada carta
     */
    public void iniciarCartas() {
        /*
        Creamos una imagen genérica
         */
        ImageView naipe;

        /*
        Inicializamos cada ImageButton con la
        imagen de la carta que le corresponde
         */
        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_a_diamante);
        naipe.setTag("a");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_2_diamante);
        naipe.setTag("2");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_3_diamante);
        naipe.setTag("3");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_4_diamante);
        naipe.setTag("4");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_5_diamante);
        naipe.setTag("5");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_6_diamante);
        naipe.setTag("6");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_7_diamante);
        naipe.setTag("7");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_8_diamante);
        naipe.setTag("8");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_9_diamante);
        naipe.setTag("9");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_10_diamante);
        naipe.setTag("10");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_j_diamante);
        naipe.setTag("10");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_q_diamante);
        naipe.setTag("10");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_k_diamante);
        naipe.setTag("10");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_a_trebol);
        naipe.setTag("a");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_2_trebol);
        naipe.setTag("2");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_3_trebol);
        naipe.setTag("3");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_4_trebol);
        naipe.setTag("4");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_5_trebol);
        naipe.setTag("5");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_6_trebol);
        naipe.setTag("6");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_7_trebol);
        naipe.setTag("7");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_8_trebol);
        naipe.setTag("8");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_9_trebol);
        naipe.setTag("9");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_10_trebol);
        naipe.setTag("10");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_j_trebol);
        naipe.setTag("10");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_q_trebol);
        naipe.setTag("10");
        naipes.add(naipe);

        naipe = new ImageView(this);
        naipe.setLayoutParams(new LinearLayout.LayoutParams(150, 240));
        naipe.setBackgroundResource(R.drawable.naipe_k_trebol);
        naipe.setTag("10");
        naipes.add(naipe);

        /*
        Ordenamos de manera aleatoria
        las cartas
         */
        Collections.shuffle(naipes);
    } //iniciarCartas

    /*
    Metodo para tomar una carta del mazo
     */
    public void tomarNaipe(int turno) {
        /*
        Tomamos la primer carta
         */
        ImageView tomaNaipe = naipes.get(0);

        /*
        Tomamos la información dle Tag
         */
        String contenidoTag = tomaNaipe.getTag().toString();

        /*
        Si la cartas es del jugador
         */
        if (turno == 1) {
            /*
            Agregamos la carta a su juego
             */
            gridLayoutJugador.addView(tomaNaipe);

            /*
            Para darle un puntaje, revisamos lo siguiente:
            - Si la carta es un As puede valer 1 u 11
                - Si la suma de los puntos actuales MAS 11 es mayor a 21,
                  le damos el valor de 1, de lo contrario vale 11
            - Todas las demás cartas tienen su valor en el Tag (de 2  10)
             */
            puntosJugador += contenidoTag.equals("a") ? ((puntosJugador + 11 > 21) ? 1 : 11) : Integer.parseInt(contenidoTag);

            /*
            Mostramos los puntos en pantalla
             */
            tvPtsJugador.setText("Puntos jugador: " + puntosJugador + "pts.");
        }

        /*
        Repetimos para el jugador 2
         */
        else if (turno == 2) {
            gridLayoutCrupier.addView(tomaNaipe);
            puntosCrupier += contenidoTag.equals("a") ? ((puntosCrupier + 11 > 21) ? 1 : 11) : Integer.parseInt(contenidoTag);
            tvPtsCrupier.setText("Puntos crupier: " + puntosCrupier + "pts.");
        }
        naipes.remove(0);
    }

    /*
    Por defecto, este demo pide 2 cartas, la del jugador y la del Crupier
     */
    public void pedirNaipe(View v) {
        tomarNaipe(1);
        tomarNaipe(2);
    }
}
