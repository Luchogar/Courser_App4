package mx.grupogarcia.courser_app4.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.grupogarcia.courser_app4.R;
import mx.grupogarcia.courser_app4.adapter.MascotaAdaptador;
import mx.grupogarcia.courser_app4.model.Mascota;
import mx.grupogarcia.courser_app4.presenter.IMascotasFragmentPresenter;
import mx.grupogarcia.courser_app4.presenter.MascotasFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasFragment extends Fragment implements IMascotasFragmentView{

    private RecyclerView rvMascotas;

    public MascotasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        IMascotasFragmentPresenter presentador = new MascotasFragmentPresenter(getContext(), this);
        return v;
    }


    @Override
    public void setRecyclerView(ArrayList<Mascota> mascotas) {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
        MascotaAdaptador adapter = new MascotaAdaptador(mascotas, getContext());
        rvMascotas.setAdapter(adapter);
    }
}
