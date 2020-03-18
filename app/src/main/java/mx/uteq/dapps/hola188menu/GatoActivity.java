package mx.uteq.dapps.hola188menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class GatoActivity extends AppCompatActivity {

    private Button btnG1;
    private Button btnG2;
    private Button btnG3;

    private String jugador1;
    private String jugador2;

    private int turno = 1;
    private int tiros = 0;

    private int tiempo = 0;
    private int segundos = 0;
    private int minutos = 0;
    private Timer timer;

    private TextView tvTiempo;
    private TextView tvTurno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gato);

        /*
        1.- Recuperar las variables del activity anterior
            getIntent.getStringExtra();
         */
        jugador1 = getIntent().
                getStringExtra("jugador1");
        jugador2 = getIntent().
                getStringExtra("jugador2");

        btnG1 = findViewById(R.id.btn_g1);
        btnG2 = findViewById(R.id.btn_g2);
        btnG3 = findViewById(R.id.btn_g3);

        tvTurno = findViewById(R.id.tv_turno);
        tvTiempo = findViewById(R.id.tv_cron);

        tvTurno.setText(jugador1);

        /*
        Timer
        los temporizadores utilizan hilos
        de ejecución para NO saturar el
        funcionamiento de un programa
         */
        timer = new Timer();

        /*
        Iinicializamos la cuenta de tiempo
        en segundo plano
         */
        timer.scheduleAtFixedRate(
                new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        //INCREMENTAMOS EL TIEMPO
                                        tiempo++;
                                        tvTiempo.setText(tiempo+"");
                                    }
                                }
                        );
                    }
                },
                1000,
                1000
        );

    } //Oncreate

    /*
    Metodo generico para todos los clic
    de todos los botones del gato
     */
    public void tirar(View v) {
        Button bSeleccionado = (Button) v;

        //Si el turno es 1 TIRA X
        if (turno == 1) {
            bSeleccionado.setText("X");
            //CAMBIAMOS EL TURNO
            turno = 2;
            tvTurno.setText(jugador2);
        }

        //Si el turno es 2 TIRA O
        else if (turno == 2) {
            bSeleccionado.setText("O");
            //CAMBIAMOS EL TURNO
            turno = 1;
            tvTurno.setText(jugador1);
        }

        //DESHABILITAR EL BOTON TIRADO
        bSeleccionado.setEnabled(false);

        //Incrementar los tiros
        tiros++;
    }


}
