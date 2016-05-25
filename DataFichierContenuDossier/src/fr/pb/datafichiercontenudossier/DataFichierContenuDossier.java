package fr.pb.datafichiercontenudossier;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.app.ListActivity;

public class DataFichierContenuDossier extends ListActivity {

	private TextView textViewContenuDossier;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fichier_contenu_dossier);
		textViewContenuDossier = (TextView) findViewById(R.id.textViewContenuDossier);
		
		textViewContenuDossier.setText("Liste des Audio.");
		String lsChemin = "";
		List<String> lsb = new ArrayList<String>();

		try {
			File dir = this.getFilesDir();
			lsChemin = dir.getAbsolutePath();
	
			File f = new File(lsChemin);

			if (f.exists()) {
				// Liste les fichiers
				String[] tFichiers = f.list();
				//lsb.add("Contenu : \n");
				for (int i = 0; i < tFichiers.length; i++) {
					lsb.add(tFichiers[i]);

				}
			} else {
				lsb.add("Le chemin ");
				lsb.add(lsChemin);
				lsb.add(" n'existe pas");
			}
			//textViewContenuDossier.setText(lsb.toString());
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lsb);
			this.setListAdapter(adapter);
			
		} catch (Exception e) {
			textViewContenuDossier.setText(e.getMessage());
		}
	} // / onCreate
} // / DataFichierContenuDossier