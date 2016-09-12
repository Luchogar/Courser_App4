package mx.grupogarcia.courser_app4.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mx.grupogarcia.courser_app4.R;
import mx.grupogarcia.courser_app4.model.Mascota;

import java.util.ArrayList;

/**
 * Created by Luis Garcia on 31/08/2016.
 */
public class MiMascotaAdaptador extends RecyclerView.Adapter<MiMascotaAdaptador.MiMascotaViewHolder> {

    private ArrayList<Mascota> mascotas;

    public MiMascotaAdaptador(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mi_mascota, parent, false);
        return new MiMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MiMascotaViewHolder m, int position) {
        final Mascota mascota = mascotas.get(position);
        m.ivMiMascotaFoto.setImageResource(mascota.getFoto());
        m.tvMiMascotaVotos.setText(String.valueOf(mascota.getVotos()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MiMascotaViewHolder extends RecyclerView.ViewHolder {

        private TextView tvMiMascotaVotos;
        private ImageView ivMiMascotaFoto;

        public MiMascotaViewHolder(View itemView) {
            super(itemView);
            ivMiMascotaFoto = (ImageView) itemView.findViewById(R.id.ivMiMascotaFoto);
            tvMiMascotaVotos = (TextView) itemView.findViewById(R.id.tvMiMascotaVotos);
        }
    }
}
