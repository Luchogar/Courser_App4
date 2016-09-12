package mx.grupogarcia.courser_app4.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.grupogarcia.courser_app4.R;
import mx.grupogarcia.courser_app4.adapter.MiMascotaAdaptador;
import mx.grupogarcia.courser_app4.model.Mascota;

import java.util.ArrayList;
/*Parte inferior de la ventana Mi mascota */

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascotasFragment extends Fragment {

    private RecyclerView rvMiMascotaFotos;
    private ArrayList<Mascota> mascotas;

    public PerfilMascotasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil_mascotas, container, false);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        rvMiMascotaFotos = (RecyclerView) v.findViewById(R.id.rvMiMascotaFotos);
        rvMiMascotaFotos.setLayoutManager(gridLayoutManager);

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.chihuahua, "Luna",1));
        mascotas.add(new Mascota(R.drawable.dogo, "Nethoven ",2));
        mascotas.add(new Mascota(R.drawable.husky, "Taco ",3));
        mascotas.add(new Mascota(R.drawable.pastor, "Flaca ",4));
        mascotas.add(new Mascota(R.drawable.pug, "Comotu ",5));
        mascotas.add(new Mascota(R.drawable.terrier, "Miko ",6));
        mascotas.add(new Mascota(R.drawable.chihuahua, "Frex ",6));

        MiMascotaAdaptador adapter = new MiMascotaAdaptador(mascotas);
        rvMiMascotaFotos.setAdapter(adapter);

        return v;
    }

}