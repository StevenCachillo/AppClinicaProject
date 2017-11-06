package com.jquirogl.appclinicaproject.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.jquirogl.appclinicaproject.R;
import com.jquirogl.appclinicaproject.interfaces.ItemClickListener;

/**
 * Created by jquirogl on 06/11/2017.
 */

public class RecyclerServiciosHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imgServicio;
    TextView txtNombreServicio, txtSedeServicio;

    ItemClickListener itemClickListener;

    public RecyclerServiciosHolder(View itemView) {
        super(itemView);

        imgServicio = (ImageView) itemView.findViewById(R.id.imgServicio);
        txtNombreServicio = (TextView) itemView.findViewById(R.id.txtNombreServicio);
        txtSedeServicio = (TextView) itemView.findViewById(R.id.txtSedeServicio);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        this.itemClickListener.onItemClick(view, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener= itemClickListener;
    }
}
