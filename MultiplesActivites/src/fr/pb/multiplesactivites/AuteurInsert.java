package fr.pb.multiplesactivites;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuteurInsert extends Activity implements OnClickListener{
	
	EditText editTextNomAuteur;
	private EditText editTextSiteAuteur;
	private EditText editTextPhotoAuteur;

	Button buttonOKAuteur;
	Button buttonKOAuteur;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.auteur_insert);
		

	    editTextNomAuteur = (EditText)findViewById(R.id.editTextNomAuteur);
	    editTextSiteAuteur = (EditText)findViewById(R.id.editTextSiteAuteur);
	    editTextPhotoAuteur = (EditText)findViewById(R.id.editTextPhotoAuteur);

	    buttonOKAuteur = (Button)findViewById(R.id.buttonOKAuteur);
	    buttonKOAuteur = (Button)findViewById(R.id.buttonKOAuteur);
	    
	    buttonKOAuteur.setOnClickListener(this);
	    buttonOKAuteur.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		 if(v == buttonOKAuteur) {
			 Intent intentResultat = new Intent();
			 intentResultat.putExtra("nomAuteur", editTextNomAuteur.getText().toString());
			 intentResultat.putExtra("siteAuteur", editTextSiteAuteur.getText().toString());
			// intentResultat.putExtra("nomAuteur", editTextNomAuteur.getText().toString());
			 setResult(RESULT_OK, intentResultat);
			 finish();
		 }
		 if(v == buttonKOAuteur) {			
			setResult(RESULT_CANCELED);
			 finish();
		 }
	}

}
