package mx.grupogarcia.courser_app4.model;

import android.content.ContentValues;

/**
 * Created by Luis Garcia on 28/08/2016.
 */
public class Mascota {

    public static final String TABLA_NOMBRE = "mascota";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_FOTO = "foto";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_VOTOS = "votos";

    private int id;
    private int foto;
    private String nombre;
    private int votos;

    public Mascota() {
    }

    public Mascota(int foto, String nombre, int votos) {
        this.foto = foto;
        this.nombre = nombre;
        this.votos = votos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public static final String crearTabla(){
        return "CREATE TABLE " + TABLA_NOMBRE + " (" +
                CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CAMPO_FOTO + " INTEGER, " +
                CAMPO_NOMBRE + " TEXT, " +
                CAMPO_VOTOS + " INTEGER)";
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CAMPO_FOTO, foto);
        contentValues.put(CAMPO_NOMBRE, nombre);
        contentValues.put(CAMPO_VOTOS, votos);
        return contentValues;
    }
}
