package fr.pb.multiplesactivites;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AccueilLibrairie extends ListActivity{
	TextView textViewMessageAccueil;
	Intent intentionEditeurInsert;
	Intent intentionAuteurInsert;
	Intent intentionInsertLivre;
	String nomEditeur;
	String[] tMneu = {"Editeur+","Auteur+","Livre+"};
	ArrayAdapter<String> adapterMenu ;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil_librairie);
        textViewMessageAccueil = (TextView)findViewById(R.id.textViewMessageAccueil);
     
        String[] tMenu = new String[3];
        tMenu[0] = "Editeur+";
        tMenu[1] = "Auteur+";
        tMenu[2] = "Livre++";
        ArrayAdapter<String> aaListe = new ArrayAdapter<String>(this, R.layout.ligne_avec_image, R.id.etiquette, tMenu);
        this.setListAdapter(aaListe);
    }

    @Override
    protected void onListItemClick(ListView parent, View v, int position, long id) {
    	// TODO Auto-generated method stub
    	try {
			if(position==0){
				intentionEditeurInsert = new Intent(this,EditeurInsert.class);
				startActivityForResult(intentionEditeurInsert, 1);
			}
			if(position==1){
				intentionAuteurInsert = new Intent(this,AuteurInsert.class);
				startActivityForResult(intentionAuteurInsert, 2);
			}
			if(position==2){
				intentionInsertLivre = new Intent(this,InsertLivre.class);
				startActivityForResult(intentionInsertLivre, 3);
			}
		} catch (Exception e) {
			// TODO: handle exception
			textViewMessageAccueil.setText(e.getMessage());
		}
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	switch (requestCode) {
    	case 1: // Editeur
			switch (resultCode) {
			case RESULT_OK:
				// --- Recuperation des donnees recues
				textViewMessageAccueil.setText("Validation éditeur " + data.getStringExtra("nomEditeur"));
				nomEditeur = data.getStringExtra("nomEditeur");
				Intent intent = new Intent(this,InsertLivre.class);
				intent.putExtra("envoiEditeur", nomEditeur);
				startActivity(intent);
				return;
			case RESULT_CANCELED:
				textViewMessageAccueil.setText("Annulation éditeur");
				return;
			} // / switch (resultCode)

		case 2: // Auteur
			switch (resultCode) {
			case RESULT_OK:
				// --- Recuperation des donnees recues
				textViewMessageAccueil.setText("Validation auteur " + data.getStringExtra("nomAuteur")+"Site Auteur "+data.getStringExtra("siteAuteur"));
				return;
			case RESULT_CANCELED:
				textViewMessageAccueil.setText("Annulation auteur");
				return;
			}
			
		case 3: // InsertLivre
			switch (resultCode) {
			case RESULT_OK:
				// --- Recuperation des donnees recues
				textViewMessageAccueil.setText("Titre: " + data.getStringExtra("titre")+"Nom de Editeur " + data.getStringExtra("editeur")+"Nom Auteur " + data.getStringExtra("auteur"));
				
				return;
			case RESULT_CANCELED:
				textViewMessageAccueil.setText("Annulation Insert Livre");
				return;
			}
			
		} // / switch (requestCode)
    }
    
}
