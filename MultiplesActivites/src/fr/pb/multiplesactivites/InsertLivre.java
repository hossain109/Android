package fr.pb.multiplesactivites;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;


public class InsertLivre extends Activity implements OnClickListener{
	//declaration
	Spinner spinnerEditeur,spinnerAuteur;
	EditText editTextLivre;
	Button buttonAnnuler;
	Button buttonOk;
	ArrayList<String> editeur;
	ArrayList<String> auteur;
	//Intent intent = new Intent();
	//declaration adapter
	ArrayAdapter<String> adapterEditeur;
	ArrayAdapter<String> adapterAuteur;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insert_livre);
		//affectation
		editTextLivre = (EditText)findViewById(R.id.editTextLivre);
		spinnerAuteur = (Spinner)findViewById(R.id.spinnerAuteur);
		spinnerEditeur = (Spinner)findViewById(R.id.spinnerEditeur);
		String stringRecoir = getIntent().getStringExtra("envoiEditeur");
		buttonOk = (Button)findViewById(R.id.buttonOk);
		buttonAnnuler = (Button)findViewById(R.id.buttonAnnuler);
		
		buttonOk.setOnClickListener(this);
		buttonAnnuler.setOnClickListener(this);
		//liste editeur
		editeur = new ArrayList<String>();
		
		Bundle params = this.getIntent().getExtras();
		String recoirEditeur = params.getString("envoiEditeur");
		editeur.add("AAA");
		editeur.add("BBB");
		editeur.add("CCC");
		editeur.add("DDD");
		editeur.add("EEE");
		editeur.add(recoirEditeur);
		
		// --- Transfo List (des editeurs) en tableau
				String[] tEditeurs = editeur.toArray(new String[editeur.size()]);
				// --- Tri du tableau
				Arrays.sort(tEditeurs);
				
				adapterEditeur = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,tEditeurs);
				adapterEditeur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinnerEditeur.setAdapter(adapterEditeur);
				

				
		//liste auteur
		auteur=new ArrayList<String>();
		auteur.add("ZZZ");
		auteur.add("XXX");
		auteur.add("WWW");
		auteur.add("VVV");
		auteur.add("UUU");
		String[] tAuteurs = auteur.toArray(new String[auteur.size()]);
		Arrays.sort(tAuteurs);
		
		adapterAuteur = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,tAuteurs);
		adapterAuteur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerAuteur.setAdapter(adapterAuteur);
				
		
	}
	//onclik method
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v == buttonOk){			
				 Intent intentResultat = new Intent();
				 intentResultat.putExtra("titre", editTextLivre.getText().toString());
				 intentResultat.putExtra("editeur", spinnerEditeur.getSelectedItem().toString());
				 intentResultat.putExtra("auteur", spinnerAuteur.getSelectedItem().toString());
				 setResult(RESULT_OK, intentResultat);
				 finish();
			 }
			 if(v == buttonAnnuler) {			
				setResult(RESULT_CANCELED);
				finish();
			 }
		}
		

	
}
