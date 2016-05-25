package fr.pb.multimeidaenregistrement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.R.color;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class EnregistrementVoix extends Activity implements OnClickListener,OnCompletionListener{

	private static final String LOG_TAG = "AudioRecordTest";
	private static String isNomFichier = null;

	private MediaRecorder mediaEnregistreur = null;
	private MediaPlayer mediaEcouteur = null;

	private ImageButton imageButtonEnregistrer;
	private ImageButton imageButtonEcouter;
	private TextView textViewMessage;

	private boolean ibEnregistrement;
	private boolean ibEcoute;
	
	List<String> liste = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enregistrement_voix);
        
        initInterface();
        

		isNomFichier = Environment.getExternalStorageDirectory().getAbsolutePath();
		isNomFichier += "/lance.3gp";

		ibEnregistrement = false;
		ibEcoute = false;
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,liste);
		//this.setListAdapter(adapter);
		
		List<String> arrayListe =  lire();
    }


	private List<String> lire(){
		
		
    	return null;
    }
	private void initInterface() {
		// Liaison widget <--> Attribut
		imageButtonEcouter = (ImageButton) findViewById(R.id.imageButtonEcouter);
		imageButtonEnregistrer = (ImageButton) findViewById(R.id.imageButtonEnregistrer);
		textViewMessage = (TextView) findViewById(R.id.textViewMessage);

		imageButtonEnregistrer.setOnClickListener(this);
		imageButtonEcouter.setOnClickListener(this);
	
	} // / initInterface
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub		
		super.onPause();
		
		if (mediaEnregistreur != null) {
			mediaEnregistreur.release();
			mediaEnregistreur = null;
		}

		if (mediaEcouteur != null) {
			mediaEcouteur.release();
			mediaEcouteur = null;
		}
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(imageButtonEnregistrer == v){
			if(ibEnregistrement){
				textViewMessage.setText("Arrêt de l'enregistrement");
				imageButtonEnregistrer.setImageResource(android.R.drawable.ic_btn_speak_now);
				imageButtonEnregistrer.setBackgroundColor(Color.GREEN);
				arreterEnregistrement();
			}
			else {
				textViewMessage.setText("Enregistrement");
				imageButtonEnregistrer.setImageResource(android.R.drawable.stat_notify_call_mute);
				imageButtonEnregistrer.setBackgroundColor(Color.RED);
				demarrerEnregistrement();
				}
			ibEnregistrement = !ibEnregistrement;
		}
		
		if(imageButtonEcouter == v){
			if (ibEcoute) {
				textViewMessage.setText("Arrêt écoute enregistrement");
				imageButtonEcouter.setImageResource(android.R.drawable.ic_media_play);
				imageButtonEcouter.setBackgroundColor(Color.GREEN);
				arreterEcoute();
			} else {
				textViewMessage.setText("Ecoute enregistrement");
				imageButtonEcouter.setImageResource(android.R.drawable.ic_media_pause);
				imageButtonEcouter.setBackgroundColor(Color.RED);
				demarrerEcoute();
			}
			ibEcoute = !ibEcoute;
		}
		
		
		
	}
	private void arreterEnregistrement() {
		mediaEnregistreur.stop();
		mediaEnregistreur.release();
		mediaEnregistreur = null;
	} // / arreterEnregistrement
	
	private void demarrerEnregistrement() {
		mediaEnregistreur = new MediaRecorder();
		mediaEnregistreur.setAudioSource(MediaRecorder.AudioSource.MIC);
		mediaEnregistreur.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		mediaEnregistreur.setOutputFile(isNomFichier);
		mediaEnregistreur.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

		try {
			mediaEnregistreur.prepare();
			mediaEnregistreur.start();
		} catch (IOException e) {
			Log.e(LOG_TAG, "Echec de la préparation");
		}
	} // / demarrerEnregistrement
	
	private void demarrerEcoute() {
		mediaEcouteur = new MediaPlayer();
		try {
			mediaEcouteur.setOnCompletionListener(this);
			mediaEcouteur.setDataSource(isNomFichier);
			mediaEcouteur.prepare();
			mediaEcouteur.start();
		} catch (IOException e) {
			Log.e(LOG_TAG, "Echec de la préparation");
		}
	} // / demarrerEcoute

	/**
	 *
	 */
	private void arreterEcoute() {
		mediaEcouteur.release();
		mediaEcouteur = null;
	} // / arreterEcoute

	@Override
	public void onCompletion(MediaPlayer mp) {
		// TODO Auto-generated method stub
		imageButtonEcouter.setImageResource(android.R.drawable.ic_media_play);
		imageButtonEcouter.setBackgroundColor(Color.GREEN);
		ibEcoute = !ibEcoute;
		textViewMessage.setText("Lecture audio terminée");
		
	}

    
}
