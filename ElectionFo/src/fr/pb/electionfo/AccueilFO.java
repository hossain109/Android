package fr.pb.electionfo;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AccueilFO extends ListActivity {

	String[] tVilles = {"Paris","Arrondissement","Bureaux","Parti","Candidat"};
	ArrayAdapter<String> listeAdapter;
;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil_fo);
     
       
        ArrayAdapter<String> aaListe = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tVilles);

        // --- Methode de la classe ListActivity pour remplir la liste 
        this.setListAdapter(aaListe);
    }
    
    @Override
    protected void onListItemClick(ListView parent, View v, int position, long id) {
    	// TODO Auto-generated method stub
    	try {
			if(position==4){
				Intent intentCandidat = new Intent(this,CandidatFO.class);
				startActivity(intentCandidat);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	//String lsSelection = parent.getItemAtPosition(position).toString();
		//textViewSelection.setText(lsSelection);
    }
    
}