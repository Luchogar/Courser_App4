package mx.grupogarcia.courser_app4.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import mx.grupogarcia.courser_app4.model.Mascota;
import mx.grupogarcia.courser_app4.R;

/**
 * Created by Luis Garcia on 10/09/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mascotas.db";
    private static final int DATABASE_VESION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VESION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Mascota.crearTabla());

        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.chihuahua, "1 Luna",1).toContentValues());
        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.dogo, "2 Bethoven",2).toContentValues());
        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.husky, "3 taco",3).toContentValues());
        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.pastor, "4 flaca",4).toContentValues());
        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.pug, "5 Comotu",5).toContentValues());
        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.terrier, "6 caramelo",6).toContentValues());
        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.bulldog, "7 rex",7).toContentValues());
        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.dogo, "8 Primo",8).toContentValues());
        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.husky, "9 Clara",9).toContentValues());

        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.terrier, "10 Pelusa",10).toContentValues());
        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.bulldog, "11 grisma",11).toContentValues());
        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.chihuahua, "12 Penrock",12).toContentValues());
        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.husky, "13 Fito",13).toContentValues());
        sqLiteDatabase.insert(Mascota.TABLA_NOMBRE, null, new Mascota(R.drawable.husky, "14 Perry",14).toContentValues());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
