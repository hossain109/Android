package fr.pb.web;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.app.Activity; 
import android.os.Bundle; 
import android.os.AsyncTask; 
import android.widget.TextView; 

import java.net.HttpURLConnection; 
import java.io.*; 
import java.net.URL; 

/** 
 * Un fichier text ASCII stocke sur un serveur distant dans un TextView 
 */ 
public class CSVFormWeb extends Activity { 

    private TextView textViewCSV; 

    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.csv_form_web); 
        textViewCSV = (TextView) findViewById(R.id.textViewCSV); 

        new TacheAsynchrone().execute(); 

    } /// onCreate 

    /* 
     * AsyncTask<Params, Progress, Result> 
    */ 
    private class TacheAsynchrone extends AsyncTask<String, Integer, String> { 
        @Override 
        // ---------------------------- 
        protected String doInBackground(String... asParametres) { 
            // String... parametre : nombre variable d'arguments 
            // Se deplace dans un thread d'arriere-plan 
            StringBuilder lsbResultat = new StringBuilder(); 

            //String lsURL = "http://10.0.2.2/RessourcesPourAndroid/pays.txt"; 
            String lsURL = "http://172.26.10.21:80/RessourcesPourAndroid/pays.txt"; 

            URL urlConnection = null; 
            HttpURLConnection httpConnection = null; 

            try { 
                // Instanciation de HttpURLConnection avec l'objet url 
                urlConnection = new URL(lsURL); 
                httpConnection = (HttpURLConnection) urlConnection.openConnection(); 

                // Choix de la methode get ou post 
                httpConnection.setRequestMethod("GET"); 

                // Autorise l'envoi de donnees 
                // Sets the flag indicating whether this URLConnection allows input. 
                httpConnection.setDoInput(true); 

                // Connexion 
                httpConnection.connect(); 

                // Lecture du flux 
                InputStream inputStream = httpConnection.getInputStream(); 

                // Comme l'on recoit un flux Text ASCII 
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)); 
                String lsLigne = ""; 
                while ((lsLigne = br.readLine()) != null) { 
                    lsbResultat.append(lsLigne); 
                    lsbResultat.append("\n"); 
                }
                br.close();
                inputStream.close();

            } catch (IOException e) { 
                lsbResultat.append(e.getMessage()); 
            } finally { 
                // Deconnexion 
                httpConnection.disconnect(); 
            } 

            // Renvoie la valeur a onPostExecute 
            return lsbResultat.toString(); 
        } /// doInBackground 

        @Override 
        // ------------------------- 
        protected void onPostExecute(String asResultat) { 
            // Synchronisation avec le thread de l'UI 
            // Affiche le resultat final 
            textViewCSV.setText(asResultat); 
        } /// onPostExecute 
    } /// TacheAsynchrone 

} /// class 