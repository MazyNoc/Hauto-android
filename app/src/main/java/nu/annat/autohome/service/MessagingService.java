package nu.annat.autohome.service;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import nu.annat.autohome.R;

public class MessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        System.out.println(remoteMessage.getData().get("test"));

        Notification notification = new NotificationCompat.Builder(this, "info")
            .setSmallIcon(R.drawable.hauto_bulbs)
            .setContentTitle("Dogbell clicked")
            .setContentText("Eiji wants out")
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .build();

        NotificationManagerCompat.from(this).notify(0, notification);

    }
}
