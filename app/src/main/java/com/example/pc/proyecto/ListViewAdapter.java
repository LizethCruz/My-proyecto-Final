package com.example.pc.proyecto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PC on 28/05/2017.
 */

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<Item> arrayListItem;
    private Context context;
    private LayoutInflater layoutInflater;



    public ListViewAdapter(ArrayList<Item> arrayListItem, Context context) {
        this.arrayListItem = arrayListItem;
        this.context = context;


    }

    @Override

    public int getCount() {
        return arrayListItem.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListItem.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        layoutInflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vistaItem = layoutInflater.inflate(R.layout.layout_item,  viewGroup,false);
        ImageView ivImagen = (ImageView) vistaItem.findViewById(R.id.ivImagen);
        TextView tvTitulo = (TextView) vistaItem.findViewById(R.id.tvTitulo);
        TextView tvContenido = (TextView) vistaItem.findViewById(R.id.tvContenido);

        ivImagen.setImageResource(arrayListItem.get(i).getImagen());
        tvTitulo.setText(arrayListItem.get(i).getTitulo());
        tvContenido.setText(arrayListItem.get(i).getContenido());

        return vistaItem;
    }
}
