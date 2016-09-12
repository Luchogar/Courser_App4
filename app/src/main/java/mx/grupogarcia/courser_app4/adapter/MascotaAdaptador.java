package mx.grupogarcia.courser_app4.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import mx.grupogarcia.courser_app4.R;
import mx.grupogarcia.courser_app4.model.Mascota;
import mx.grupogarcia.courser_app4.model.MascotaConstructor;

import java.util.ArrayList;

/**
 * Created by Luis Garcia on 28/08/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private Context context;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Context context) {
        this.mascotas = mascotas;
        this.context = context;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder m, int position) {
        final Mascota mascota = mascotas.get(position);

        m.ivMascotaFoto.setImageResource(mascota.getFoto());
        m.tvMascotaNombre.setText(mascota.getNombre());
        m.tvMascotaVotos.setText(String.valueOf(mascota.getVotos()));

        m.ivMascotaFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, mascota.getNombre(), Snackbar.LENGTH_LONG).show();
            }
        });
        m.ivMascotaVotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mascota.setVotos(mascota.getVotos() +1 );
                m.tvMascotaVotos.setText(String.valueOf(mascota.getVotos()));

                MascotaConstructor mascotaConstructor = new MascotaConstructor(context);
                mascotaConstructor.actualizar(mascota);

                Snackbar.make(view, "+1 Voto para " + mascota.getNombre(), Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivMascotaFoto;
        private TextView tvMascotaNombre;
        private TextView tvMascotaVotos;
        private ImageView ivMascotaVotar;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            ivMascotaFoto = (ImageView) itemView.findViewById(R.id.ivMascotaFoto);
            tvMascotaNombre = (TextView) itemView.findViewById(R.id.tvMascotaNombre);
            tvMascotaVotos = (TextView) itemView.findViewById(R.id.tvMascotaVotos);
            ivMascotaVotar = (ImageView) itemView.findViewById(R.id.ivMascotaVotar);
        }
    }
}
