package fr.pb.multiplesactivites;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditeurInsert extends Activity implements OnClickListener{

	EditText editTextNomEditeur;
	EditText editTextSiteEditeur;

	Button buttonOKEditeur;
	Button buttonKOEditeur;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editeur_insert);
		
		 editTextNomEditeur = (EditText)findViewById(R.id.editTextNomEditeur);
		 editTextSiteEditeur = (EditText)findViewById(R.id.editTextSiteEditeur);

		 buttonOKEditeur = (Button)findViewById(R.id.buttonOKEditeur);
		 buttonKOEditeur = (Button)findViewById(R.id.buttonKOEditeur);
		 
		 buttonKOEditeur.setOnClickListener(this);
		 buttonOKEditeur.setOnClickListener(this);
	}
	 @Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 if(v == buttonOKEditeur) {
			 Intent intentResultat = new Intent();
			 intentResultat.putExtra("nomEditeur", editTextNomEditeur.getText().toString());
			 setResult(RESULT_OK, intentResultat);
			 finish();
		 }
		 if(v == buttonKOEditeur) {			
			setResult(RESULT_CANCELED);
			 finish();
		 }
	}


}
