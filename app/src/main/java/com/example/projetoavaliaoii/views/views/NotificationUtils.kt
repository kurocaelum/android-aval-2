package com.example.projetoavaliaoii.views.views

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.projetoavaliaoii.R

object NotificationUtils {
    val CHANNEL_ID = "default"

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(context: Context){
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager

        val channelName = "Padrão"
        val channelDescription = "Canal padrão de notificações"

        val channel = NotificationChannel(
            CHANNEL_ID,
            channelName,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = channelDescription
            enableLights(true)
        }

        notificationManager.createNotificationChannel(channel)
    }

    fun notificationTarefa(context: Context){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            createNotificationChannel(context)

        val notificationBuilder =
            NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_favorite)
                .setContentTitle("Titulo") //TODO pegar do banco
                .setContentText("Texto") //TODO pegar do banco
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setColor(ActivityCompat.getColor(context, R.color.colorAccent))
                .setDefaults(Notification.DEFAULT_ALL)

        val notificationManager =
            NotificationManagerCompat.from(context)
        notificationManager.notify(1, notificationBuilder.build())
    }
}