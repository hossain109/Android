package fr.pb.geolocalisationmenu;

import android.content.Intent; 
import android.app.ListActivity; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.*; 

public class GeolocalisationMenu extends ListActivity { 

    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.geolocalisation_menu); 
    } /// onCreate 

    @Override 
    public void onListItemClick(ListView parent, View v, int position, long id) { 

        Intent intention = null; 

        switch (position) { 
            case 0: 
                intention = new Intent(this, FournisseursGeolocalisation.class);
                startActivityForResult(intention, 1); 
                break; 
            case 1: 
                intention = new Intent(this, GeolocalisationWIFI.class); 
                startActivityForResult(intention, 1);
                break; 
            case 2: 
                intention = new Intent(this, TestsReseaux.class); 
                startActivityForResult(intention, 1);
                break; 
            case 3: 
                intention = new Intent(this, GeolocalisationGPS.class); 
                startActivityForResult(intention, 1);
                break; 
           // case 4: 
               // intention = new Intent(this, GeolocalisationAll.class); 
              //  startActivityForResult(intention, 1);
              //  break; 
            default: 
                Toast.makeText(getBaseContext(), "Bizarre!!! ", Toast.LENGTH_LONG).show(); 
        } 
    } // / onListItemClick() 

    @Override 
    public void onActivityResult(int requestCode, int resultCode, Intent data) { 
        finishActivity(requestCode); 
    } ///  onActivityResult 

} /// class 