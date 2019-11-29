package com.example.durnkblerg;


import java.util.*;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class BackgroundServices extends Service {
    private static final Object CATEGORY_SERVICE = 0;
    private BroadcastReceiver receiver;
   public int counter=0;
   Game obj=new Game();

   Context mContext;

   static int flag=0;
   static int flag2=0;

   String curent_app="";

   public BackgroundServices(){}

   public void onCreate(){
       super.onCreate ();
       mContext=this;

       if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O)
           startMyOwnForeGround();
       else
           startForeground ( 1, new Notification (  ) );
   }

   @RequiresApi(Build.VERSION_CODES.O)
   private void startMyOwnForeGround()
   {
       String NOTIFICATION_CHANNEL_ID = "example";
       String channelName = "Background Service";
       NotificationChannel chan =new NotificationChannel ( NOTIFICATION_CHANNEL_ID,channelName, NotificationManager.IMPORTANCE_DEFAULT );
       chan.setLightColor ( Color.BLUE );

       NotificationManager manager=(NotificationManager)getSystemService ( Context.NOTIFICATION_SERVICE );
       assert manager!=null;
       manager.createNotificationChannel ( chan );

       NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder ( this,NOTIFICATION_CHANNEL_ID );
       Notification notification = notificationBuilder.setOngoing ( true )
               .setContentTitle ( "App is running in the background" )
               .setPriority ( NotificationManager.IMPORTANCE_MIN )
               .setCategory ( (String) CATEGORY_SERVICE )
               .build ();
       startForeground ( 2,notification );


   }
    public int OnStartOnCommand(Intent intent, int flags,int startId){
    super.onStartCommand ( intent,flags,startId );
    startTimer();
    return START_STICKY;

    }

    public void onDestroy(){
       super.onDestroy ();
       stoptimertask();

       Intent broadcastIntent=new Intent (  );
       broadcastIntent.setAction ( "restart service" );
       broadcastIntent.setClass ( this,Game.class );
       this.sendBroadcast ( broadcastIntent );
    }

    private Timer timer;
   private TimerTask timerTask;
   public void startTimer(){
       timer =new Timer (  );
       timerTask = (new TimerTask (){

           public void run(){
               if(flag==0){

                   String current_app = printForegroundTask ();
                   Intent lockIntent =new Intent(mContext,Game.class);
                   lockIntent.putExtra("pack",printForegroundTask());
                   lockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   mContext.startActivity(lockIntent);
               }

           }




       });
       timer.schedule(timerTask,0,100);
   }

   public void stoptimertask(){
       if(timer!=null){
           timer.cancel ();
           timer=null;
       }
   }

   @Nullable
    @Override
    public IBinder onBind(Intent intent){return null;}

    private String printForegroundTask(){
       String currentApp="Null";
       if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
           UsageStatsManager usm=(UsageStatsManager)this.getSystemService ( Context.USAGE_STATS_SERVICE );
           long time=System.currentTimeMillis ();
           List <UsageStats> appList=usm.queryUsageStats ( UsageStatsManager.INTERVAL_DAILY, time-1000*1000,time-1000*1000 );
                   if(appList!=null&&appList.size()>0){
                       SortedMap<Long, UsageStats>mySortedMap=new TreeMap <> (  );
                       for(UsageStats usageStats:appList){
                           mySortedMap.put(usageStats.getLastTimeUsed (),usageStats);
                       }
                       if(mySortedMap!=null&&!mySortedMap.isEmpty ()){
                           currentApp=mySortedMap.get(mySortedMap.lastKey ()).getPackageName ();
                       }
                   }
       }else{
           ActivityManager am=(ActivityManager)this.getSystemService ( Context.ACTIVITY_SERVICE );
           List<ActivityManager.RunningAppProcessInfo>tasks=am.getRunningAppProcesses ();
           currentApp=tasks.get(0).processName;
       }
  return currentApp;
        }

    private class CATEGORY_SERVICE {
    }
}


