package com.ajithvgiri.quotes.utils

import androidx.lifecycle.MutableLiveData
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.ConnectivityManager.CONNECTIVITY_ACTION
import android.net.Network
import android.net.NetworkCapabilities.TRANSPORT_CELLULAR
import android.net.NetworkCapabilities.TRANSPORT_WIFI
import android.net.NetworkInfo
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresApi


class InternetConnection(private val context: Context) : MutableLiveData<Boolean>() {
    var intentFilter = IntentFilter(CONNECTIVITY_ACTION)
    private var connectivityManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    private lateinit var networkCallback: NetworkCallback

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            networkCallback = NetworkCallback(this)
        }
    }

    override fun onActive() {
        super.onActive()
        updateConnection()
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> connectivityManager.registerDefaultNetworkCallback(
                networkCallback
            )
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
                val builder =
                    NetworkRequest.Builder().addTransportType(TRANSPORT_CELLULAR).addTransportType(TRANSPORT_WIFI)
                connectivityManager.registerNetworkCallback(builder.build(), networkCallback)
            }
            else -> {
                context.registerReceiver(networkReceiver, intentFilter)
            }
        }
    }

    override fun onInactive() {
        super.onInactive()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            connectivityManager.unregisterNetworkCallback(networkCallback)
        } else {
            context.unregisterReceiver(networkReceiver)
        }
    }


    private val networkReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            updateConnection()
        }
    }

    fun updateConnection() {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        postValue(activeNetwork?.isConnected)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    class NetworkCallback(private val internet: InternetConnection) : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network?) {
            internet.postValue(true)
        }

        override fun onLost(network: Network?) {
            internet.postValue(false)
        }
    }
}