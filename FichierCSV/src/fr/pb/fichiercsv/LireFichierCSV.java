package fr.pb.fichiercsv;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class LireFichierCSV extends ListActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lire_fichier_csv);

		List lsbContenu = new ArrayList<String>();
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
				String[] ligne=new String[2];
				ligne = lsLigne.split(";");
				lsbContenu.add(ligne[0]);
				lsbContenu.add(ligne[1]);
				

			}
			br.close();
			isr.close();
			is.close();
		}
		catch(Exception e) {
			lsbContenu.add(e.getMessage());
		}
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lsbContenu);
		
		this.setListAdapter(arrayAdapter);
    
    }


 
    
}
