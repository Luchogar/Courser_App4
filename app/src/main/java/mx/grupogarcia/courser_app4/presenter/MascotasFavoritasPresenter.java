package mx.grupogarcia.courser_app4.presenter;

import android.content.Context;

import mx.grupogarcia.courser_app4.model.MascotaConstructor;
import mx.grupogarcia.courser_app4.view.IMascotasFavoritasView;

/**
 * Created by Luis Garcia on 04/09/2016.
 */
public class MascotasFavoritasPresenter implements IMascotasFavoritasPresenter {

    private Context context;
    private IMascotasFavoritasView iMascotasFavoritasView;
    private MascotaConstructor mascotaConstructor;

    public MascotasFavoritasPresenter(Context context, IMascotasFavoritasView iMascotasFavoritasView) {
        this.context = context;
        this.iMascotasFavoritasView = iMascotasFavoritasView;
        obtenerDatos();
    }

    @Override
    public void obtenerDatos() {
        mascotaConstructor = new MascotaConstructor(context);
        iMascotasFavoritasView.setRecyclerView(mascotaConstructor.obtenerFavoritas());
    }
}
