package pe.upc.desarrollomoviltf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PreciosActivity extends AppCompatActivity {
    private List<Prenda> peliculaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PrendaAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precios);
        setTitle("Precios por Tipo de Prenda");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new PrendaAdapter(peliculaList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        recyclerView.setAdapter(mAdapter);

        preparePeliculaData();
    }

    private void preparePeliculaData() {
        Prenda pelicula = new Prenda("Pantalones",   "S/. 6.00");
        peliculaList.add(pelicula);

        pelicula = new Prenda("Camisas",  "S/. 5.00");
        peliculaList.add(pelicula);

        pelicula = new Prenda("Polos", "S/. 3.00");
        peliculaList.add(pelicula);

        mAdapter.notifyDataSetChanged();
    }

}
