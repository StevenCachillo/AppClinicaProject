package com.jquirogl.appclinicaproject.recycler;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.jquirogl.appclinicaproject.R;
import com.jquirogl.appclinicaproject.interfaces.ItemClickListener;

/**
 * Created by jquirogl on 06/11/2017.
 */

public class RecyclerServiciosAdapter extends RecyclerView.Adapter<RecyclerServiciosHolder> {

    Context context;
    String [] nombreServ,sedeServ, descripcionServ, coberturaServ, precioServ;
    int[] imagenes;

    Dialog dialog;

    public RecyclerServiciosAdapter(Context context, String[] nombreServ, String[] sedeServ, String[] descripcionServ, String[] coberturaServ, String[] precioServ, int[] imagenes){
        this.context=context;
        this.nombreServ=nombreServ;
        this.sedeServ=sedeServ;
        this.descripcionServ=descripcionServ;
        this.coberturaServ=coberturaServ;
        this.precioServ=precioServ;
        this.imagenes=imagenes;
    }

    @Override
    public RecyclerServiciosHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_servicios,null);

        RecyclerServiciosHolder holder = new RecyclerServiciosHolder(view);

        return holder;
    }

    //vincular datos a las vistas
    @Override
    public void onBindViewHolder(RecyclerServiciosHolder holder, int position) {

        holder.imgServicio.setImageResource(imagenes[position]);
        holder.txtNombreServicio.setText(nombreServ[position]);
        holder.txtSedeServicio.setText(sedeServ[position]);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                dialog = new Dialog(context);

                //no mostrar el titulo
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                //set custom view
                dialog.setContentView(R.layout.dialog_layout);

                ImageView imgServicio = (ImageView)dialog.findViewById(R.id.imgServicioDialog);
                TextView descServicio = (TextView)dialog.findViewById(R.id.txtDescServicioDialog);
                TextView cobeServicio = (TextView)dialog.findViewById(R.id.txtCobServicioDialog);
                TextView precioServicio = (TextView) dialog.findViewById(R.id.txtPrecioServicioDialog);

                //asignamos datos al dialog_layout
                imgServicio.setImageResource(imagenes[position]);
                descServicio.setText(descripcionServ[position]);
                cobeServicio.setText(coberturaServ[position]);
                precioServicio.setText(precioServ[position]);

                //show
                dialog.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return nombreServ.length;
    }
}
