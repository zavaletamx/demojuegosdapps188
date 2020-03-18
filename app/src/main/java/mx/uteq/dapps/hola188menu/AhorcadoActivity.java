package mx.uteq.dapps.hola188menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AhorcadoActivity extends AppCompatActivity {

    //Palabra para jugar
    private String palabra = "CASA";

    //ARREGLO DE LAS LETRAS DE LA PALABRA
    private char[] letras;

    //AREGLO DE LOS GUIONES DE LA PALABRA
    private char[] guiones;

    //CONTADOR DE ERRORES
    private int errores = 0;

    //CONTADOR DE LETRAS ENCONTRADAS
    private int coincidencias = 0;

    private ImageView ivAhorcado;
    private TextView tvGuiones;
    private EditText etPalabra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado);

        ivAhorcado = findViewById(R.id.iv_ahorcado);
        tvGuiones = findViewById(R.id.tv_guiones);
        etPalabra = findViewById(R.id.et_letra);

        /*
        Inicializar los arreglos
        toCharArray()
         */
        letras = palabra.toCharArray();

        /*
        Generar el arreglo de guiones
         */
        guiones = new char[palabra.length()];
        for(int i = 0; i < guiones.length; i++) {
            guiones[i] = '_';
        }

        /*
        Armar la cadena de texto que se muestra
        en la vista con los guiones
         */
        String guionesVista="";
        for(char g : guiones) {
            guionesVista += g + " ";
        }

        pintaImagen();

        tvGuiones.setText(guionesVista);

    }

    public void pintaImagen() {
        /*
        Dependiendo del numero de errores
        es la imagen que mostramos
         */
        switch (errores) {
            case 0 :
                ivAhorcado.
                        setImageResource(
                                R.drawable.ahorcado0
                        );
                break;

            case 1 :
                ivAhorcado.
                        setImageResource(
                                R.drawable.ahorcado1
                        );
                break;

            case 2 :
                ivAhorcado.
                        setImageResource(
                                R.drawable.ahorcado2
                        );
                break;

            case 3 :
                ivAhorcado.
                        setImageResource(
                                R.drawable.ahorcado3
                        );
                break;

            case 4 :
                ivAhorcado.
                        setImageResource(
                                R.drawable.ahorcado4
                        );
                break;

            case 5 :
                ivAhorcado.
                        setImageResource(
                                R.drawable.ahorcado5
                        );
                break;

                default:
                    ivAhorcado.
                            setBackgroundResource(
                                    R.drawable.ahorcado5
                            );
                    break;
        }
    }

    public void tirar(View v) {
        /*
        Tomamos la letra del campo de texto
        la pasamos a matyusculas y la
        enviamos a un metodo para comparar
        si la letra existe en el
        arreglo de letras de mi palabra
         */
        /*String valor = etPalabra.
                getText().
                toString();

        valor = valor.toUpperCase();

        char letra = valor.charAt(0);*/

        char letra = etPalabra.
                getText().
                toString().
                toUpperCase().
                charAt(0);

        if (existeLetra(letra)) {
            /*
            Actualizar los guiones
            del TextView
             */
            String guionesVista = "";
            for(int i = 0; i < guiones.length; i++) {
                guionesVista += guiones[i] + " ";
            }
            //MOSTRAMOS EL CAMBIO
            tvGuiones.setText(guionesVista);
        }

        //LA LETRA NO EXISTE
        else {
            errores++;
            pintaImagen();
        }
    }

    /*
    Buscar una coincidencia en las letras
    de mi palabra
     */
    public boolean existeLetra(char l) {
        //Recorremos letras
        boolean encontrado = false;
        for(int i = 0; i < letras.length; i++) {
            //SI LA LETRA EXISTE
            if (l == letras[i]) {
                encontrado = true;
                //MOSTRAMOS LA LETRA
                guiones[i] = letras[i];
                //TENEMOS OTRA COINCIDENCIA
                coincidencias++;
            }
        }

        return encontrado;
    }

}
