package fr.pb.geolocalisationmenu;

import android.content.Context; 
import android.location.Location; 
import android.location.LocationListener; 
import android.location.LocationManager; 
import android.os.Bundle; 
import android.app.Activity; 
import android.widget.*; 
import android.view.View; 
import android.view.View.*; 

// ----------------------------
public class GeolocalisationGPS extends Activity implements OnClickListener { 

    // Attributs pour les widgets 
    private TextView textViewLongitudeGPS; 
    private TextView textViewLatitudeGPS; 
    private Button buttonDemarrerGeolocalisationGPS; 
    private Button buttonArreterGeolocalisationGPS; 
    private TextView textViewMessageGPS; 

    private boolean ibEtatScanne = false;

    private LocationManager gestionnaire; 
    private LocationListener ecouteur; 

    @Override 
    protected void onCreate(Bundle savedInstanceState) { 

        super.onCreate(savedInstanceState); 
        setContentView(R.layout.geolocalisation_gps); 
        initInterface(); 
        initEvents(); 
    } /// onCreate 

    private void initInterface() { 
        // Liaison widget <--> Attribut 
        textViewLongitudeGPS = (TextView) findViewById(R.id.textViewLongitudeGPS); 
        textViewLatitudeGPS = (TextView) findViewById(R.id.textViewLatitudeGPS); 
        buttonDemarrerGeolocalisationGPS = (Button) findViewById(R.id.buttonDemarrerGeolocalisationGPS); 
        buttonArreterGeolocalisationGPS = (Button) findViewById(R.id.buttonArreterGeolocalisationGPS); 
        textViewMessageGPS = (TextView) findViewById(R.id.textViewMessageGPS); 
    } /// initInterface 

    private void initEvents() { 
        // Liaison widget <--> Events 
        buttonDemarrerGeolocalisationGPS.setOnClickListener(this); 
        buttonArreterGeolocalisationGPS.setOnClickListener(this); 
    } /// initEvents 

    @Override 
    public void onClick(View v) { 
 
        if (v == buttonDemarrerGeolocalisationGPS) { 
            textViewMessageGPS.setText("Etat : démarré"); 

            gestionnaire = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
            ecouteur = new EcouteurPosition(); 
            // public void requestLocationUpdates (String provider, long minTime, float minDistance, LocationListener listener) 
            // 1000 * 60 = 1 minute 
            // 10 metres
            gestionnaire.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000 * 60, 10, ecouteur); 
            ibEtatScanne = true;
        } 

        if (v == buttonArreterGeolocalisationGPS) {
            if (ibEtatScanne) {
                gestionnaire.removeUpdates(ecouteur);
                textViewMessageGPS.setText("Etat : arrêté");
                ibEtatScanne = false;
            } else {
                textViewMessageGPS.setText("Le service de géolocalisation via le GPS n'était pas démarré");
            }
        }

    } /// onClick 

    /** 
     * NESTED CLASS pour le Location Listener
     */ 
    private class EcouteurPosition implements LocationListener { 

        public void onProviderDisabled(String provider) { 
            textViewMessageGPS.setText("onProviderDisabled"); 
        } 

        public void onProviderEnabled(String provider) { 
            textViewMessageGPS.setText("onProviderEnabled"); 
        } 

        public void onStatusChanged(String provider, int status, Bundle extras) { 
            textViewMessageGPS.setText("onStatusChanged");
        } 

        public void onLocationChanged(Location location) { 
            textViewMessageGPS.setText("onLocationChanged"); 
            // Affichage des valeurs lat et long 
            textViewLongitudeGPS.setText(Double.toString(location.getLatitude()));
            textViewLatitudeGPS.setText(Double.toString(location.getLongitude()));
        } 

    } /// private nested class 

} /// class 