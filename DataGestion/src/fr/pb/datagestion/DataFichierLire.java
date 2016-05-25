package fr.pb.datagestion;

import java.io.*;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

// -------------------------
public class DataFichierLire extends Activity {

	private TextView textViewLecture;
	private final String FICHIER_CSV = "repertoire.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.data_fichier_lire);

		textViewLecture = (TextView) findViewById(R.id.textViewLecture);

		lire();

	} // / onCreate

	// --------------
	private void lire() {

		File f;
		String lsChemin = getFilesDir().getAbsolutePath();
		FileInputStream fis;
		InputStreamReader isr;
		BufferedReader br;
		StringBuilder lsb = new StringBuilder();
		String lsLigne = "";

		try {
			f = new File(lsChemin + "/" + FICHIER_CSV);
			if (f.exists()) {
				fis = getBaseContext().openFileInput(FICHIER_CSV);
				isr = new InputStreamReader(fis);
				br = new BufferedReader(isr);

				while ((lsLigne = br.readLine()) != null) {
					lsb.append(lsLigne);
					lsb.append("\n");
				}

				br.close();
				isr.close();
				fis.close();
			} else {
				lsb.append("Le fichier ");
				lsb.append(FICHIER_CSV);
				lsb.append(" n'existe pas");
			}
			textViewLecture.setText(lsb.toString());
		} catch (FileNotFoundException e) {
			textViewLecture.setText(e.getMessage());
		} catch (IOException e) {
			textViewLecture.setText(e.getMessage());
		}

	} // / lire

} // / DataFichierEcrire