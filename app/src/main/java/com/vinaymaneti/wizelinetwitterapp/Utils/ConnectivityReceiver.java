package com.vinaymaneti.wizelinetwitterapp.Utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

/**
 * Created by vinay on 18/01/17.
 */

public class ConnectivityReceiver extends BroadcastReceiver {

    public static ConnectivityReceiverListener mConnectivityReceiverListener;

    public ConnectivityReceiver() {
        super();
    }

    // this is with the help of broadcast receivers
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if (mConnectivityReceiverListener != null)
            mConnectivityReceiverListener.OnNetworkConnectionChanged(isConnected);
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

            Network[] activeNetworks = cm.getAllNetworks();
            for (Network n : activeNetworks) {
                NetworkInfo nInfo = cm.getNetworkInfo(n);
                if (nInfo.isConnected())
                    return true;
            }

        } else {
            NetworkInfo[] info = cm.getAllNetworkInfo();
            if (info != null)
                for (NetworkInfo anInfo : info)
                    if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }

        return false;

    }

    public interface ConnectivityReceiverListener {
        void OnNetworkConnectionChanged(boolean isConnected);
    }
}
