package fr.pb.electionfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.app.ListActivity;


public class BureauFO extends ListActivity {

	private final String FICHIER_CSV = "bureau.txt";
	ArrayList<String> lsbContenu = new ArrayList<String>();
	//List<String> arrayList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bureau_fo);
		
		lire();

		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lsbContenu);
		this.setListAdapter(arrayAdapter);
	} // / onCreate

	// --------------
	private void lire() {
		

		File f;
		String lsChemin = getFilesDir().getAbsolutePath();
		FileInputStream fis;
		InputStreamReader isr;
		BufferedReader br;
		String lsLigne = "";

		try {
			f = new File(lsChemin + "/" + FICHIER_CSV);
			Log.e("chemen", lsChemin);
			if (f.exists()) {
				fis = getBaseContext().openFileInput(FICHIER_CSV);
				isr = new InputStreamReader(fis);
				br = new BufferedReader(isr);

				while ((lsLigne = br.readLine()) != null) {

					lsbContenu.add(lsLigne);
					String[] ligne = lsLigne.split(";");
					lsbContenu.add(ligne[1]+ "  "+ligne[3]);
					
					
				}

				br.close();
				isr.close();
				fis.close();
			} else {
				lsbContenu.add("Le fichier ");
				lsbContenu.add(FICHIER_CSV);
				lsbContenu.add(" n'existe pas");
			}

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}

	} // / lire

} // / DataFichierEcrire