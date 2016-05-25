package fr.pb.geolocalisationmenu;

import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

/**
 * 
 * @author pascal
 * 
 */
public class TestsReseaux extends Activity implements OnClickListener {

	// Attribut pour les widgets
	private Button buttonTestWIFI;
	private Button buttonTestGPS;
	private TextView textViewMessageTests;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.tests_reseaux);
		initInterface();

	} // / onCreate

	private void initInterface() {

		// Liaison widget <--> Attribut
		buttonTestWIFI = (Button) findViewById(R.id.buttonTestWIFI);
		buttonTestGPS = (Button) findViewById(R.id.buttonTestGPS);
		textViewMessageTests = (TextView) findViewById(R.id.textViewMessageTests);

		buttonTestWIFI.setOnClickListener(this);
		buttonTestGPS.setOnClickListener(this);

	} // / initInterface

	@Override
	public void onClick(View vue) {

		LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		if (vue == buttonTestWIFI) {
			boolean lbWiFi = manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
			if (lbWiFi) {
				textViewMessageTests.setText("Wi-Fi disponible");
			} else {
				textViewMessageTests.setText("Wi-Fi indisponible");
			}
		}

		if (vue == buttonTestGPS) {

			boolean lbGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
			if (lbGPS) {
				textViewMessageTests.setText("GPS disponible");
			} else {
				textViewMessageTests.setText("GPS indisponible");
			}

		}
	} // / onClick

} // / class