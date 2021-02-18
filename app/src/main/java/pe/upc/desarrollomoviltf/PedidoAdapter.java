package pe.upc.desarrollomoviltf;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import static androidx.core.content.ContextCompat.startActivity;

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.MyViewHolder> {

    private List<Pedido> pedidosList;



    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView titulo, fecha;

        public MyViewHolder(View view) {
            super(view);
            titulo = (TextView) view.findViewById(R.id.titulo);
            fecha = (TextView) view.findViewById(R.id.fecha);
        }
    }


    public PedidoAdapter(List<Pedido> pedidosList) {
        this.pedidosList = pedidosList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pedido_fila, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Pedido pedido = pedidosList.get(position);
        holder.titulo.setText(pedido.getTitulo());
        holder.fecha.setText("Fecha: "+pedido.getFecha());
    }

    @Override
    public int getItemCount() {
        return pedidosList.size();
    }
}
