package org.gdgyangon.kanaung;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Bundle bundle = getIntent().getExtras();

		if(getIntent().hasExtra("LAUNCH") && bundle.getString("LAUNCH").equals("YES")) {
			startService(new Intent(MainActivity.this, FlyService.class));
		}

		Button launch = (Button)findViewById(R.id.btnStart);
		launch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startService(new Intent(MainActivity.this, FlyService.class));
			}
		});

		Button stop = (Button)findViewById(R.id.btnStop);
		stop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				stopService(new Intent(MainActivity.this, FlyService.class));
			}
		});
		
	}

	@Override
	protected void onResume() {
		Bundle bundle = getIntent().getExtras();

		if(getIntent().hasExtra("LAUNCH") && bundle.getString("LAUNCH").equals("YES")) {
			startService(new Intent(MainActivity.this, FlyService.class));
		}
		super.onResume();
	}
}