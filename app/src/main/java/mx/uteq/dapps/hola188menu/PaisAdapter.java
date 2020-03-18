package mx.uteq.dapps.hola188menu;

/*
Por defecto todos los adaptadores para una
lista de componentes de Android deben heredar
de "BaseAdapter" e implementar 4 métodos
como mínimo (aunque no los uses)
*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PaisAdapter extends BaseAdapter {

    /*
    Atributos de la clase
    1.- Contexto
    2.- Lista de datos
    3.- El diseño para esta lista
     */
    private Context contexto;
    private ArrayList<Pais> datos;
    private LayoutInflater inflater;

    /*
    Constructor para indicar
    el contexto y los datos de la lista
     */
    public PaisAdapter(Context context,
                       ArrayList<Pais> datos) {
        this.contexto = context;
        this.datos = datos;
        //Preparamos el diseño de los elementos
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        //RETORNAMOS EL TAMAÑO DE LA LISTA
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /*
    GetView se ejectua POR CADA ELEMENTO
    DE LA LISTA
     */
    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent) {
        //MOSTRSAR EL DISEÑO DEL EMENTO
        convertView = inflater.inflate(
                R.layout.item_pais,null
        );

        //LIGAMOS LOS ELEMENTOS DEL ITEM
        TextView tvNombre = convertView.findViewById(
                R.id.tv_nombre
        );

        tvNombre.setText(
                datos.get(position).getNombre()
        );

        return convertView;

    }
}
