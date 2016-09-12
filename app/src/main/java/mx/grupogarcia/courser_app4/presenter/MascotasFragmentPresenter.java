package mx.grupogarcia.courser_app4.presenter;

import android.content.Context;


import mx.grupogarcia.courser_app4.model.Mascota;
import mx.grupogarcia.courser_app4.model.MascotaConstructor;
import mx.grupogarcia.courser_app4.view.IMascotasFragmentView;
import java.util.ArrayList;

/**
 * Created by Luis Garcia on 03/09/2016.
 */
public class MascotasFragmentPresenter implements IMascotasFragmentPresenter {

    private Context context;
    private IMascotasFragmentView iMascotasFragmentView;
    private MascotaConstructor mascotaConstructor;

    public MascotasFragmentPresenter(Context context, IMascotasFragmentView iMascotasFragmentView) {
        this.context = context;
        this.iMascotasFragmentView = iMascotasFragmentView;
        obtenerDatos();
    }

    @Override
    public void obtenerDatos() {
        mascotaConstructor = new MascotaConstructor(context);
        iMascotasFragmentView.setRecyclerView(mascotaConstructor.obtenerMascotas());
    }
}
