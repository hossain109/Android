package fr.pb.capteurs;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/*
 * La liste des capteurs presents sur le terminal
 * Aucun capteur sur avd_233 (ie WQVGA 3.4" API 10 Version 2.3.3)
 * qq-uns sur avd_42_maps_320_480 (ie WQVGA 3.4" API 17 Version 4.2.2 avec Google APIs)
 * Samsung : accelerometer, orientation, proximity, gravity, linear_acceleration, 
 * rotation_vector, magnetic_field 
 */
public class Capteurs extends ListActivity {

	private SensorManager gestionnaireDeCapteur;
	private ArrayAdapter<String> aaCapteurs;
	private TextView textViewInfos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.capteurs);

		textViewInfos = (TextView) findViewById(R.id.textViewInfos);

		this.gestionnaireDeCapteur = (SensorManager) getSystemService(SENSOR_SERVICE);

		List<String> listeCapteurs = this.getListeCapteurs();
		ArrayAdapter<String> aaCapteurs = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listeCapteurs);

		this.setListAdapter(aaCapteurs);

		int liCapteurs = listeCapteurs.size();
		textViewInfos.setText(Integer.toString(liCapteurs)
				+ " capteur(s) sur ce terminal !");

	} // / onCreate

	/*
	 * Liste des capteurs
	 */
	private List<String> getListeCapteurs() {
		// --- Tous les capteurs de l'appareil
		List<Sensor> capteurs = this.gestionnaireDeCapteur
				.getSensorList(Sensor.TYPE_ALL);

		// --- Remplissage d'une List pour une liste deroulante
		List<String> listeCapteurs = new ArrayList<String>();

		for (Sensor capteur : capteurs) {
			listeCapteurs.add(this.getTypeCapteur(capteur.getType()));
		}

		return listeCapteurs;

	} // / getListeCapteurs

	/**
	 * 
	 * @param type
	 * @return
	 */
	private String getTypeCapteur(int type) {

		String lsType;

		switch (type) {
		case Sensor.TYPE_ACCELEROMETER:
			lsType = "TYPE_ACCELEROMETER";
			break;
		case Sensor.TYPE_LINEAR_ACCELERATION:
			lsType = "TYPE_LINEAR_ACCELERATION";
			break;
		case Sensor.TYPE_GRAVITY:
			lsType = "TYPE_GRAVITY";
			break;
		case Sensor.TYPE_GYROSCOPE:
			lsType = "TYPE_GYROSCOPE";
			break;
		case Sensor.TYPE_LIGHT:
			lsType = "TYPE_LIGHT";
			break;
		case Sensor.TYPE_MAGNETIC_FIELD:
			lsType = "TYPE_MAGNETIC_FIELD";
			break;
		case Sensor.TYPE_ORIENTATION:
			lsType = "TYPE_ORIENTATION";
			break;
		case Sensor.TYPE_PRESSURE:
			lsType = "TYPE_PRESSURE";
			break;
		case Sensor.TYPE_PROXIMITY:
			lsType = "TYPE_PROXIMITY";
			break;
		case Sensor.TYPE_ROTATION_VECTOR:
			lsType = "TYPE_ROTATION_VECTOR";
			break;
		case Sensor.TYPE_AMBIENT_TEMPERATURE:
			lsType = "TYPE_AMBIENT_TEMPERATURE";
			break;
		default:
			lsType = "TYPE_UNKNOW";
			break;
		} // / switch

		return lsType;

	} // / getTypeCapteur
/*
	@Override
	public void onListItemClick(ListView parent, View vue, int position, long id) {

		TextView tv = (TextView) vue;
		String lsChoix = tv.getText().toString();

		try {
			if (lsChoix.equalsIgnoreCase("TYPE_ACCELEROMETER")) {
				Intent accelerometre = new Intent(this, Accelerometre.class);
				startActivityForResult(accelerometre, 1);
			}

			if (lsChoix.equalsIgnoreCase("TYPE_MAGNETIC_FIELD")) {
				Intent boussole = new Intent(this, Boussole.class);
				startActivityForResult(boussole, 2);
			}

			if (lsChoix.equalsIgnoreCase("TYPE_ORIENTATION")) {
				Intent fausseBoussole = new Intent(this, FausseBoussole.class);
				startActivityForResult(fausseBoussole, 2);
			}
		} // / try

		catch (ActivityNotFoundException e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	} // / onListItemClick
*/
} // / classe Capteurs