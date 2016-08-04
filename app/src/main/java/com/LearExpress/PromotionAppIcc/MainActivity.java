package com.LearExpress.PromotionAppIcc;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.estimote.sdk.SystemRequirementsChecker;

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button boton;
    EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button)findViewById(R.id.btn_go_next);
        texto = (EditText)findViewById(R.id.editText);


        boton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                //Create of intent
                Intent intent = new Intent(MainActivity.this, HomeScreen.class);

                //Create Bundle
                Bundle b = new Bundle();
                b.putString("Nombre", texto.getText().toString());
                Log.e("PRINT_NOMBRE","Este es mi texto: "+b.getString("Nombre"));

                //Anadir la info al intent
                intent.putExtras(b);

                //Iniciamos la nueva activity
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();


        MyApplication app = (MyApplication) getApplication();
        Log.e(TAG,"Preshow Frm MainActivity");
        texto = (EditText)findViewById(R.id.editText);
        texto.setText("");

        if (!SystemRequirementsChecker.checkWithDefaultDialogs(this)) {
            Log.e(TAG, "Can't scan for beacons, some pre-conditions were not met");
            Log.e(TAG, "Read more about what's required at: http://estimote.github.io/Android-SDK/JavaDocs/com/estimote/sdk/SystemRequirementsChecker.html");
            Log.e(TAG, "If this is fixable, you should see a popup on the app's screen right now, asking to enable what's necessary");
        } else if (!app.isBeaconNotificationsEnabled()) {
            Log.d(TAG, "Enabling beacon notifications");
            app.enableBeaconNotifications();
        }
    }


    protected void SendAlert(String s){
        new AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage(s)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void testUpload(){
    //This is the test of Push code
        int i = 1 + 1;
        int ii = 2 + 2;
        int iii = i + ii;

    }
    
    private void testDownload(){
    //This is the test of Pull code    
        int i = 1 + 1;
    }
}
