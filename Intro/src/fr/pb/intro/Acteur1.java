package fr.pb.intro;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.Typeface;

public class Acteur1 extends Activity implements OnClickListener,OnFocusChangeListener{
	//declaration
	EditText prenom;
	EditText nom;
	Button valider;
	TextView message;
	Button annuler;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acteur1);
        //initialisation
        prenom = (EditText)findViewById(R.id.editTextPrenom);
        nom = (EditText)findViewById(R.id.editText1);
        
        //prenom.setTextColor(color.black);
        //nom.setTextColor(color.black);
        //prenom.setTypeface(null,Typeface.NORMAL);
       //nom.setTypeface(null,Typeface.NORMAL);
        
        valider = (Button)findViewById(R.id.buttonValider);
        message = (TextView)findViewById(R.id.textViewMessage);
        annuler = (Button)findViewById(R.id.buttonAnnuler);
        
        prenom.setOnFocusChangeListener(this);
        nom.setOnFocusChangeListener(this);
       //ajout ecouteur 
       valider.setOnClickListener(this);
       annuler.setOnClickListener(this);

    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
    	// --- Focus editTextPrenom
    	if(v == prenom && hasFocus) {
    		prenom.setText("");
    		prenom.setTextColor(Color.BLACK);
    		prenom.setTypeface(null, Typeface.NORMAL);
    	} /// Focus editTextPrenom

    	// --- Focus editTextNom
    	if(v == nom && hasFocus) {
    		nom.setText("");
    		nom.setTextColor(Color.BLACK);
    		nom.setTypeface(null, Typeface.NORMAL);
    	} /// Focus editTextNom
    } /// onFocusChange
    
    //methode onClick
     public void onClick(View v) {
    	 if(v==valider){
    		 
    		 message.setText(prenom.getText().toString()+" "+nom.getText().toString());
    	 }
    	 //vider saisie et message
    	 if(v==annuler){
    		 prenom.setText("");
    		 message.setText("");
    	 }
     }
     
     }

