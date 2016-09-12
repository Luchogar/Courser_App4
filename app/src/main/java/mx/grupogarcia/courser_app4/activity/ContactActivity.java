package mx.grupogarcia.courser_app4.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import mx.grupogarcia.courser_app4.R;
import mx.grupogarcia.courser_app4.library.GMailSender;

public class ContactActivity extends AppCompatActivity {

    private Toolbar mainToolbar;
    private TextInputEditText edtNombre, edtCorreo, edtComentario;
    private Button btnComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mainToolbar = (Toolbar) findViewById(R.id.mainToolbar);

        edtNombre = (TextInputEditText)findViewById(R.id.edtNombre);
        edtCorreo = (TextInputEditText)findViewById(R.id.edtCorreo);
        edtComentario = (TextInputEditText)findViewById(R.id.edtComentario);

        btnComentario = (Button) findViewById(R.id.btnComentario);

        if (mainToolbar != null)
        {
            setSupportActionBar(mainToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //CAMBIAR USUARIO Y CONTRASEÑA
                String user = "XXXXXXXXXX@gmail.com";
                String password = "XXXXXXXXXX";
                try {
                    GMailSender sender = new GMailSender(user, password);
                    sender.sendMail(getResources().getString(R.string.app_name) + ": " + edtNombre.getText().toString(),
                            edtComentario.getText().toString(),
                            user,
                            edtCorreo.getText().toString());
                    edtNombre.setText("");
                    edtCorreo.setText("");
                    edtComentario.setText("");
                    Snackbar.make(view, "Correo Enviado", Snackbar.LENGTH_LONG).show();
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }
        });
    }
}
