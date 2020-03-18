package mx.uteq.dapps.hola188menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaPersoActivity extends AppCompatActivity {

    private ListView lvPaises;
    private ArrayList<Pais> paises;
    private PaisAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_perso);

        lvPaises = findViewById(R.id.lv_paises);
        paises = new ArrayList<>();

        Pais pa1 = new Pais();
        pa1.setIdPais(1);
        pa1.setNombre("México");
        pa1.setCapital("CDMX");
        pa1.setPob(129200000);
        paises.add(pa1);

        Pais pa2 = new Pais();
        pa2.setIdPais(1);
        pa2.setNombre("Canada");
        pa2.setCapital("Ottawa");
        pa2.setPob(37590000);
        paises.add(pa2);

        Pais pa3 = new Pais();
        pa3.setIdPais(1);
        pa3.setNombre("Alemania");
        pa3.setCapital("Berlín");
        pa3.setPob(82790000);
        paises.add(pa3);

        Pais pa4 = new Pais();
        pa4.setIdPais(1);
        pa4.setNombre("Honduras");
        pa4.setCapital("Tegucigalpa");
        pa4.setPob(9265000);
        paises.add(pa4);

        Pais pa5 = new Pais();
        pa5.setIdPais(1);
        pa5.setNombre("India");
        pa5.setCapital("Nueva Delhi");
        pa5.setPob(1352617328);
        paises.add(pa5);

        adaptador = new PaisAdapter(
                this,
                paises
        );

        lvPaises.setAdapter(adaptador);

    }
}
