package fr.pb.capteurlumiere;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * Capteur de lumiere
 * 
 */
public class CapteurLumiere extends Activity implements SensorEventListener {

	private TextView textViewLumiere;
	private SensorManager gestionnaireDeCapteur;
	private Sensor capteurDeLumiere;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.capteur_lumiere);

		textViewLumiere = (TextView) findViewById(R.id.textViewLumiere);

		// Recuperation du gestionnaire de capteurs
		gestionnaireDeCapteur = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

		// Recuperation du capteur de lumiere
		capteurDeLumiere = gestionnaireDeCapteur.getDefaultSensor(Sensor.TYPE_LIGHT);

		if(capteurDeLumiere == null){
			Toast.makeText(this, "Capteur de lumière indisponible", Toast.LENGTH_LONG).show();
		}
		else {
			Toast.makeText(this, "Capteur de lumière disponible", Toast.LENGTH_LONG).show();
		}

	} // / onCreate

	@Override
	// onResume : l'activite presente passe au premier plan
	protected void onResume() {

		super.onResume();
		// Enregistrer le listener de capteur
		if (capteurDeLumiere != null) {
			gestionnaireDeCapteur.registerListener(this, capteurDeLumiere, SensorManager.SENSOR_DELAY_NORMAL);
		}

	} // / onResume

	@Override
	// on Pause : une autre activite passe au premier plan
	protected void onPause() {

		super.onPause();
		// --- On passe a une autre APP
		// --- Desenregistrer le capteur
		if (capteurDeLumiere != null) {
			gestionnaireDeCapteur.unregisterListener(this, capteurDeLumiere);
		}

	} // / onPause

	@Override
	public void onAccuracyChanged(Sensor capteur, int precision) {
		// Sur changement de precison
	} // / onAccuracyChanged

	@Override
	public void onSensorChanged(SensorEvent event) {

		float lux;
		StringBuilder lsbMessage = new StringBuilder();

		if (event.sensor.getType() == Sensor.TYPE_LIGHT) {

			lsbMessage.append("\nLumière ?\n");

			lux = event.values[0];

			if (lux <= SensorManager.LIGHT_CLOUDY) {
				lsbMessage.append("Nuit\n");
			} else if (lux <= SensorManager.LIGHT_OVERCAST) {
				lsbMessage.append("Nuageux\n");
			} else if (lux <= SensorManager.LIGHT_SUNLIGHT) {
				lsbMessage.append("Ensoleillé\n");
			}
			lsbMessage.append(Integer.toString((int) lux));

			this.textViewLumiere.setText(lsbMessage.toString());

		} // / if Sensor.TYPE_LIGHT

	} // / onSensorChanged

} // / class