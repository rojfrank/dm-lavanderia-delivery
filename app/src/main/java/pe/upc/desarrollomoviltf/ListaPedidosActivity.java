package pe.upc.desarrollomoviltf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaPedidosActivity extends AppCompatActivity {
    private List<Pedido> pedidosList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PedidoAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos);
        setTitle("Lista de Pedidos");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new PedidoAdapter(pedidosList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        recyclerView.setAdapter(mAdapter);



        preparePedidoData();
    }

    private void preparePedidoData() {
        /*pedidos de ejemplo*/

        Pedido pedido = new Pedido("Pedido 1",   "27-Ene-2021");
        pedidosList.add(pedido);

        pedido = new Pedido("Pedido 2",   "26-Ene-2021");
        pedidosList.add(pedido);

        pedido = new Pedido("Pedido 3",   "26-Ene-2021");
        pedidosList.add(pedido);

        mAdapter.notifyDataSetChanged();
    }
    public void verPedido(View view) {
        startActivity(new Intent(ListaPedidosActivity.this, PedidoActivity.class));
    }
}
