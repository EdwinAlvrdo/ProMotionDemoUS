package com.LearExpress.PromotionAppIcc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends Activity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Log.e("FLAG_1","Llego");

        texto = (TextView)findViewById(R.id.textWelcome);
        Bundle b = this.getIntent().getExtras();
        Log.e("FLAG_2","Llego nombre: "+b.getString("Nombre"));

        texto.setText("Bienvenido "+b.getString("Nombre"));
        Log.e("FLAG_3","Llego");
    }


}
