package nu.annat.autohome.service;

import android.app.Notification;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import nu.annat.autohome.R;
import nu.annat.autohome.api.Registration;
import nu.annat.autohome.rest.Server;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);

        String refreshedToken = s;
        Server.getInstance().getService().register(new Registration(refreshedToken)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {

            }
        });

    }
}
