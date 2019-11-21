package com.example.durnkblerg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BlockActivity extends AppCompatActivity {

    Button enableBtn, lockBtn, AppsBtn;


    static final int Result_enable = 1;
    DevicePolicyManager devicePolicyManager;
    ComponentName componentName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_block );

      enableBtn=(Button) findViewById ( R.id.enableBtn );
      lockBtn=(Button) findViewById ( R.id.lockBtn );
      AppsBtn=(Button)findViewById ( R.id.AppsBtn );

        devicePolicyManager = (DevicePolicyManager)getSystemService ( Context.DEVICE_POLICY_SERVICE );
        componentName = new ComponentName ( BlockActivity.this, Controller.class );




      final boolean active = devicePolicyManager.isAdminActive ( componentName );
      if(active){
            enableBtn.setText ("disable");
            lockBtn.setVisibility ( View.VISIBLE );
      } else{

          enableBtn.setText ("enable");
          lockBtn.setVisibility ( View.VISIBLE );

      }



      enableBtn.setOnClickListener ( new View.OnClickListener () {
          @Override
          public void onClick(View v) {
              boolean active = devicePolicyManager.isAdminActive ( componentName );
              if(active){
                    devicePolicyManager.removeActiveAdmin ( componentName );
                        enableBtn.setText ("enable");
                        lockBtn.setVisibility ( View.VISIBLE );

              }else{

                  Intent intent =new Intent ( DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN );
                  intent.putExtra ( DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName );
                  intent.putExtra ( DevicePolicyManager.EXTRA_ADD_EXPLANATION,"You should enable the app." );
                  startActivityForResult (intent, Result_enable  );
                  intent = new Intent ( AlarmClock.ACTION_SET_ALARM );
                  startActivity ( intent );

              }
              

          }
      } );

      lockBtn.setOnClickListener ( new View.OnClickListener () {
          @Override
          public void onClick(View v) {

              while(active) {


                  Intent intent = new Intent ( AlarmClock.ACTION_SET_ALARM ); 
                  devicePolicyManager.lockNow ();
              }


          }
      } );




    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data ) {
        switch (requestCode){
            case Result_enable:
                if(requestCode == Activity.RESULT_OK){
                enableBtn.setText ("disable");
                lockBtn.setVisibility ( View.VISIBLE );
            }else{
                    Toast.makeText (this,"failed", Toast.LENGTH_SHORT).show();
                }
                return;
        }
        super.onActivityResult ( requestCode, requestCode,data );
    }



}
