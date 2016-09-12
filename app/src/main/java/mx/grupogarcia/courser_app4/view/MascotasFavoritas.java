package mx.grupogarcia.courser_app4.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import mx.grupogarcia.courser_app4.R;
import mx.grupogarcia.courser_app4.adapter.MascotaAdaptador;
import mx.grupogarcia.courser_app4.model.Mascota;
import mx.grupogarcia.courser_app4.presenter.IMascotasFavoritasPresenter;
import mx.grupogarcia.courser_app4.presenter.MascotasFavoritasPresenter;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements IMascotasFavoritasView {

    private Toolbar mainToolbar;
    private RecyclerView rvMascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        mainToolbar = (Toolbar) findViewById(R.id.mainToolbar);
        rvMascotasFavoritas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);

        if (mainToolbar != null) {
            setSupportActionBar(mainToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        IMascotasFavoritasPresenter presenter = new MascotasFavoritasPresenter(this, this);
    }

    @Override
    public void setRecyclerView(ArrayList<Mascota> mascotas) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFavoritas.setLayoutManager(llm);
        MascotaAdaptador adapter = new MascotaAdaptador(mascotas, this);
        rvMascotasFavoritas.setAdapter(adapter);
    }
}
