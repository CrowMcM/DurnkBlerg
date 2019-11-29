package com.example.durnkblerg;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;

import androidx.recyclerview.widget.RecyclerView;

public class RestartService extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction ().equals ( Intent.ACTION_BOOT_COMPLETED )) {
            Log.i ( "Broadcast Listened", "Service Tried to stop" );

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService ( new Intent ( context, BackgroundServices.class ) );
            } else {
                context.startService ( new Intent ( context, BackgroundServices.class ) );
            }

        }
    }
}

