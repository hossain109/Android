package fr.pb.electionfo;

import java.io.*;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/*
 * Lire les donnees du fichier CSV /res/raw/repertoire.txt
 * Les afficher dans un TextView
 * Au prealable le fichier est cree ou copier/coller dans /res/raw
 */
public class BureauxRes2data extends Activity {

	
	private TextView textViewMessage;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.bureaux_res_2_data);
		
		textViewMessage =  (TextView)findViewById(R.id.textViewMessage);

		StringBuilder lsbContenu = new StringBuilder("");
		String lsLigne = "";
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;

		try {
			// --- Avec un buffer
			is = getBaseContext().getResources().openRawResource(R.raw.bureaux);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			while ((lsLigne = br.readLine()) != null) {
				lsbContenu.append(lsLigne);
				lsbContenu.append("\n");
			}
			br.close();
			isr.close();
			is.close();
			// ecriture dans la portable

			// File resolveMe = new
			// File("/data/data/fr.pb.electionfo/files/bureau.txt");
			// resolveMe.createNewFile();

			String lsFichier = getFilesDir().getAbsolutePath() + "/bureaux.txt";
			FileWriter fw = new FileWriter(lsFichier, true); // true = mode
																// append
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(lsbContenu.toString());
			bw.close();
			fw.close();

		} catch (Exception e) {
			lsbContenu.append("Exception : " + e.getMessage());
		}
		textViewMessage.setText(lsbContenu.toString());
	} // / on Create

} // / class