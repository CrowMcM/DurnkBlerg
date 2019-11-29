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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import android.view.View;

import java.util.List;

public class BlockActivity extends AppCompatActivity {



    AppAdapter installedAppAdapter;
    List<AppList>installedApps;

    ListView userInstalledApps;
    List<String>lock=new ArrayList <> (  );


    Button enableBtn, lockBtn, AppsBtn;


    static final int Result_enable = 1;
    ComponentName componentName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_block );



      enableBtn=(Button) findViewById ( R.id.enableBtn );
      lockBtn=(Button) findViewById ( R.id.lockBtn );
      AppsBtn=(Button)findViewById ( R.id.AppsBtn );

        userInstalledApps=(ListView)findViewById (R.id.AppList);
        componentName = new ComponentName ( BlockActivity.this, Controller.class );

        installedApps=getInstalledApps();
        installedAppAdapter=new AppAdapter ( BlockActivity.this.installedApps );


      lockBtn.setOnClickListener ( new View.OnClickListener () {
          @Override
          public void onClick(View v) {

                  Intent intent = new Intent ( AlarmClock.ACTION_SET_ALARM ); 


          }
      } );






    }



    private List<AppList> getInstalledApps() {
        return installedApps;
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
