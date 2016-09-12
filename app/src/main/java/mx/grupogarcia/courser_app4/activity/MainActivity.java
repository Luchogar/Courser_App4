package mx.grupogarcia.courser_app4.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import mx.grupogarcia.courser_app4.R;
import mx.grupogarcia.courser_app4.adapter.PageAdapter;
import mx.grupogarcia.courser_app4.view.MascotasFavoritas;
import mx.grupogarcia.courser_app4.view.MascotasFragment;
import mx.grupogarcia.courser_app4.view.PerfilMascotasFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
        }
    }

    private  ArrayList<Fragment> agregarFragmentos(){
        ArrayList<Fragment> fragments = new  ArrayList<>();
        fragments.add(new MascotasFragment());
        fragments.add(new PerfilMascotasFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragmentos()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText(getResources().getString(R.string.mascotas));
        tabLayout.getTabAt(1).setText(getResources().getString(R.string.mi_mascota));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contexto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFavourites:
                Intent favoritas = new Intent(this, MascotasFavoritas.class);
                startActivity(favoritas);
                break;
            case R.id.mContact:
                Intent contacto = new Intent(this, ContactActivity.class);
                startActivity(contacto);
                break;
            case R.id.mAbout:
                Intent acerca = new Intent(this, AboutActivity.class);
                startActivity(acerca);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
