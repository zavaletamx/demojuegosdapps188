package mx.uteq.dapps.hola188menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ScrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
    }

    //VER/CARGAR EL MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //INTERACTUAR CON EL MENU
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
        Para poder interactuar con un elemento del menu, necesitamos
        conocer su ID
         */
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(
                    this,
                    "EN EL MENU",
                    Toast.LENGTH_LONG
            ).show();
        }

        /*
        Redireccionar a otras actividades
        startActivity(
            intent(
                DIONDE ESTOY,  .this
                A DONDE VOY    .class
            )
        )
         */
        if (id == R.id.menu_inicio) {
            startActivity(
                    new Intent(
                            ScrollActivity.this,
                            MainActivity.class
                    )
            );
        }


        return true;
    }
}
