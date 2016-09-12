package mx.grupogarcia.courser_app4.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import mx.grupogarcia.courser_app4.database.DbHelper;

import java.util.ArrayList;

/**
 * Created by Luis Garcia on 03/09/2016.
 */
public class MascotaConstructor {

    private Context context;

    public MascotaConstructor(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerFavoritas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + Mascota.TABLA_NOMBRE + " ORDER BY " + Mascota.CAMPO_VOTOS + " DESC LIMIT 5";
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            Mascota mascota = new Mascota();
            mascota.setId(cursor.getInt(0));
            mascota.setFoto(cursor.getInt(1));
            mascota.setNombre(cursor.getString(2));
            mascota.setVotos(cursor.getInt(3));
            mascotas.add(mascota);
        }

        return mascotas;
    }

    public ArrayList<Mascota> obtenerMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + Mascota.TABLA_NOMBRE;
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            Mascota mascota = new Mascota();
            mascota.setId(cursor.getInt(0));
            mascota.setFoto(cursor.getInt(1));
            mascota.setNombre(cursor.getString(2));
            mascota.setVotos(cursor.getInt(3));
            mascotas.add(mascota);
        }

        return mascotas;
    }

    public void insertar(Mascota mascota) {
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.insert(Mascota.TABLA_NOMBRE, null, mascota.toContentValues());
    }

    public void actualizar(Mascota mascota) {
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.update(Mascota.TABLA_NOMBRE, mascota.toContentValues(), Mascota.CAMPO_ID + "=?", new String[]{String.valueOf(mascota.getId())});
    }
}
