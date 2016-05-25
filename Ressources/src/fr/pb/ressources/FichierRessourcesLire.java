package fr.pb.ressources;

import java.io.*;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/*
 * Lire les donnees du fichier CSV /res/raw/repertoire.txt
 * Les afficher dans un TextView
 * Au prealable le fichier est cree ou copier/coller dans /res/raw
 */
public class FichierRessourcesLire extends Activity {

	private TextView textViewFichier;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.fichier_ressources_lire);

		textViewFichier = (TextView)findViewById(R.id.textViewFichier);

		StringBuilder lsbContenu = new StringBuilder("");
		String lsLigne = "";
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;

		try {
			// --- Avec un buffer
			is = getBaseContext().getResources().openRawResource(R.raw.repertoire);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			while ((lsLigne = br.readLine()) != null) {
				lsbContenu.append(lsLigne);
				lsbContenu.append("\n");
			}
			br.close();
			isr.close();
			is.close();
		}
		catch(Exception e) {
			lsbContenu.append(e.getMessage());
		}
		textViewFichier.setText(lsbContenu.toString());
	} /// on Create

} /// class
