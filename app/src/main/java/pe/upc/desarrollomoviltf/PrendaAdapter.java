package pe.upc.desarrollomoviltf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PrendaAdapter extends RecyclerView.Adapter<PrendaAdapter.MyViewHolder> {

    private List<Prenda> peliculasList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView titulo, precio;

        public MyViewHolder(View view) {
            super(view);
            titulo = (TextView) view.findViewById(R.id.titulo);
            precio = (TextView) view.findViewById(R.id.precio);
        }
    }


    public PrendaAdapter(List<Prenda> peliculasList) {
        this.peliculasList = peliculasList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prenda_fila, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Prenda pelicula = peliculasList.get(position);
        holder.titulo.setText(pelicula.getTitulo());
        holder.precio.setText("Precio: "+pelicula.getPrecio());
    }

    @Override
    public int getItemCount() {
        return peliculasList.size();
    }
}
