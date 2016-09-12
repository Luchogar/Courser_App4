package mx.grupogarcia.courser_app4.view;

import mx.grupogarcia.courser_app4.model.Mascota;

import java.util.ArrayList;

/**
 * Created by Luis Garcia on 03/09/2016.
 */
public interface IMascotasFragmentView {
    public void setRecyclerView(ArrayList<Mascota> mascotas);
}
