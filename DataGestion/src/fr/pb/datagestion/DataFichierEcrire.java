package fr.pb.datagestion;

import java.io.*;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

// ---------------------------
public class DataFichierEcrire extends Activity {

	private TextView textViewMessageEcrire;
	private final String FICHIER_TXT = "tintin.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.data_fichier_ecrire);

		textViewMessageEcrire = (TextView) findViewById(R.id.textViewMessageEcrire);

		ecrire(textViewMessageEcrire);

	} // / onCreate

	// ----------------
	private void ecrire(TextView tv) {

		FileOutputStream fos;
		OutputStreamWriter osw;
		BufferedWriter bw;

		try {
			fos = getBaseContext().openFileOutput(FICHIER_TXT, MODE_PRIVATE);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			bw.write("Tintin\n");
			bw.write("Milou\n");
			bw.write("Haddock\n");

			bw.close();
			osw.close();
			fos.close();
			tv.setText("Jusque là tout va bien !\nLe fichier " + FICHIER_TXT + " a été créé et rempli");
		} catch (Exception e) {
			tv.setText(e.getMessage());
		}

	} // / ecrire

} // / DataFichierEcrire