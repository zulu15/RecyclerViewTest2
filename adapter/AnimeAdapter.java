package com.zulu.recyclerviewtest2.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zulu.recyclerviewtest2.R;
import com.zulu.recyclerviewtest2.models.Anime;

import java.util.List;


public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeHolder> {

    private List<Anime> animes;
    public AnimeAdapter(List<Anime> animes){
        this.animes=animes;
    }

    /**
     * Se encarga de crear cada item
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public AnimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_anime,parent,false);
        return new AnimeHolder(v);
    }

    /**
     * Se encarga de modificar el contenido de cada item
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(AnimeHolder holder, int position) {
        Anime currentAnime = animes.get(position);
        holder.imagen.setImageResource(currentAnime.getImagen());
        holder.txtNombre.setText(currentAnime.getNombre());
        holder.txtVisitas.setText(String.valueOf(currentAnime.getVisitas()));
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public static class AnimeHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView txtNombre,txtVisitas;
        public AnimeHolder(View item) {
            super(item);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TAG","Se selecciono la fila numero: "+getAdapterPosition());
                    Toast.makeText(v.getContext(),"Se selecciono la fila "+getAdapterPosition(),Toast.LENGTH_SHORT).show();
                }
            });
            imagen = (ImageView) item.findViewById(R.id.imagen);
            txtNombre = (TextView) item.findViewById(R.id.nombre);
            txtVisitas= (TextView) item.findViewById(R.id.visitas);
        }

    }


}
