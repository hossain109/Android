package fr.pb.multimedia;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class MultiMediaSon extends Activity implements OnClickListener{


	private ImageButton imageButtonPlay;
	private ImageButton imageButtonPause;
	private ImageButton imageButtonStop;

	private TextView textViewMessage;

	private MediaPlayer iMP;
	String status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_son);
        iMP = new MediaPlayer();
        
		imageButtonPlay = (ImageButton) findViewById(R.id.imageButtonPlay);
		imageButtonPause = (ImageButton) findViewById(R.id.imageButtonPause);
		imageButtonStop = (ImageButton) findViewById(R.id.imageButtonStop);

		textViewMessage = (TextView) findViewById(R.id.textViewMessage);
		
		imageButtonPlay.setOnClickListener(this);
		imageButtonPause.setOnClickListener(this);
		imageButtonStop.setOnClickListener(this);
		
		status = "Inactif";
		textViewMessage.setText(status);
        
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(imageButtonPlay == v){
			if(status.equals("Inactif") || status.equals("Stop")){
				iMP = MediaPlayer.create(this, R.raw.kalimba);
				status = "Audio est démarée";
				status = "Créé-Démarré";
			} // / if Inactif

			if (status.equals("Pause")) {
				// Repare au point ou c'est arrete
				status = "Démarré après Pause";
			} // / if Pause

			iMP.start();
		} // / imageButtonPlay

		if (v == imageButtonPause) {
			iMP.pause();
			status = "Pause";
		} // / imageButtonPause

		if (v == imageButtonStop) {
			iMP.stop();
			status = "Stop";
		} // / imageButtonStop

		textViewMessage.setText(status);
	} // / onClick

	@Override
	protected void onPause() {
		super.onPause();
		// --- Liberation des ressources si necessaire
		if (iMP != null) {
			iMP.release();
			iMP = null;
		}
	} // / onPause


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.multi_media_son, menu);
        return true;
    }




    
}
