package org.gdgyangon.kanaung;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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