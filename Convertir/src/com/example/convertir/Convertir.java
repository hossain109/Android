package com.example.convertir;

import android.R.integer;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import java.util.Formatter;

import android.text.InputFilter.LengthFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Convertir extends Activity implements OnClickListener{
	EditText editTextEuroDollar,editTextDollarEuro;
	Button buttonConvertir;
	TextView textViewResultant;
	float cours = (float) 1.2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertir);
        editTextEuroDollar = (EditText)findViewById(R.id.editTextEuroDollar);
        editTextDollarEuro  = (EditText)findViewById(R.id.editTextDollarEuro);
        textViewResultant = (TextView)findViewById(R.id.textViewResultant);
        buttonConvertir = (Button)findViewById(R.id.buttonConvertir);
        
        buttonConvertir.setOnClickListener(this);

        		
    }
    
    public void onClick(View v ) {
    	

    	if(v==buttonConvertir){
    		if(( !editTextEuroDollar.getText().toString().trim().equals(""))){
    			//alerte
    			String lsTitre = "Alerte";
    			String lsMessage = "Appliquez !";


    			DialogInterface.OnClickListener ecouteur = new DialogInterface.OnClickListener() {
    				@Override
    				public void onClick(DialogInterface dialog, int codeBouton) {

    					// -1
    					if(codeBouton == Dialog.BUTTON_POSITIVE) {
    						Toast.makeText(getBaseContext(), "Saisies validées !!!", Toast.LENGTH_LONG).show();
    					}
    					// -2
    					if(codeBouton == Dialog.BUTTON_NEGATIVE) {
    						Toast.makeText(getBaseContext(), "Saisies annulées !!!", Toast.LENGTH_LONG).show();
    					}
    				}
    			};



    			AlertDialog.Builder ad = new AlertDialog.Builder(this);
    			ad.setTitle(lsTitre);
    			ad.setMessage(lsMessage);
    			ad.setNegativeButton("Annuler", ecouteur);
    			ad.setPositiveButton("OK", ecouteur);
    			ad.show();
    		} // / buttonValider
    			//alerte	
    	    	
    	    	
    			
		String euroDollar = editTextEuroDollar.getText().toString().trim();
		float valeurEuroDollar = Float.parseFloat(euroDollar);
		//String dollarEuro = editTextDollarEuro.getText().toString();
		//float valeurDollarEuro = Integer.parseInt(dollarEuro);
		float resultatn = valeurEuroDollar*cours;	
		Formatter f = new Formatter();
		f.format("%5.2f", resultatn);
		String stringResultant = Double.toString(resultatn);
		textViewResultant.setText(stringResultant+" Dollar(s)");
		Toast.makeText(getBaseContext(), "C'est conveti parfaitment", Toast.LENGTH_LONG).show();
    		}
    		else if(!editTextDollarEuro.getText().toString().trim().equals("")){
    			//alerte
    	    	
    			
    			String dollarEuro = editTextDollarEuro.getText().toString().trim();
    			float valeurDollarEuro = Float.parseFloat(dollarEuro);
    			float resultatn = valeurDollarEuro/cours;	
    			Formatter f = new Formatter();
    			f.format("%5.2f", resultatn);
    			String stringResultant = Double.toString(resultatn);
    			textViewResultant.setText(stringResultant+" Euro(s)");
    			Toast.makeText(getBaseContext(), "C'est conveti parfaitment", Toast.LENGTH_LONG).show();
    		}
    		else{
    			textViewResultant.setText("Il faut mettre saisie.");
    		}
    	}
	
    
}
