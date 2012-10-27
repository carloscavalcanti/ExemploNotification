package com.example.exemplonotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button botao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botao = (Button) findViewById(R.id.button1);
        botao.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		 criarNotification();
	}
	
	private void criarNotification() {
		NotificationManager notificationManager = (NotificationManager)      
                                   getSystemService(NOTIFICATION_SERVICE);
		Notification notification = new  
               Notification(R.drawable.ic_launcher, "Uma nova mensagem!", 
                            System.currentTimeMillis());
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, NovaActivity.class), 0);
		notification.setLatestEventInfo(this, "Titulo", "Conteúdo", 
                                       pendingIntent);
		notificationManager.notify(R.string.app_name, notification);
	}
    
}
