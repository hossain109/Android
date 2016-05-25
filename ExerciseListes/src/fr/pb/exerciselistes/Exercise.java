package fr.pb.exerciselistes;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Exercise extends Activity{
	private EditText editTextPrenom;
	private EditText editTextNom;
	private CheckBox checkBoxVivante;
	private RadioGroup radioGroup1;
	private RadioButton radio;
	private Button buttonValider;
	private Spinner spinnerNationalite;
	String valeurRadio="";

	
	//deroulantes pour naitionalite
	private String[] nationalite = {"Francais","Allemend","Espasgne","Royme-uni"};
	private ArrayAdapter<String> adpapterNationalite;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
       
        initInterface();

    }
    public void onClick(View v ) {
    	CheckBox checkBox = (CheckBox) findViewById(R.id.checkBoxVivante);
    	if(v==buttonValider){
    	    //checkbox
            if (checkBox.isChecked()) {
                //checkBox.setChecked(true);
                Toast.makeText(getBaseContext(), "Souvenir moi", Toast.LENGTH_LONG).show();
            }
    	}
    	
    }
    private void initInterface() {
    	

        editTextPrenom = (EditText) findViewById(R.id.editTextPrenom);
        editTextNom = (EditText) findViewById(R.id.editTextNom);
        buttonValider = (Button)findViewById(R.id.buttonValider);
        spinnerNationalite = (Spinner)findViewById(R.id.spinnerNationalite);
        radioGroup1  = (RadioGroup)findViewById(R.id.radioGroup1);
        
   

        
        //spinner fonctions
        adpapterNationalite = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nationalite);
        adpapterNationalite.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNationalite.setAdapter(adpapterNationalite);
        
        
    }

  
   
}
