package fr.pb.androidsql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.ImageView;

// ---------------------------------------
public class AffichageImageFromData extends Activity {
	private TextView textView1;
	private ImageView imageView1;
	String lsChemin = "";
	Context contexte = getBaseContext();
	StringBuilder lsbResultatsData = new StringBuilder();
	File[] tDossiers;


	@Override
	// -----------------
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.affichage_image_from_data);

		textView1 = (TextView) findViewById(R.id.textViewMessage);
		imageView1 = (ImageView) findViewById(R.id.imageviewTest);

		testsDivers();
		/*
		 * //Affiche image du SDCard
		 * 
		 * StringBuilder lsbContenu = new StringBuilder(""); String
		 * lsCheminRacineSD =
		 * Environment.getExternalStorageDirectory().getAbsolutePath(); String
		 * lsFichier = ""; InputStream is = null;
		 * 
		 * try { // from SD // --- Technique URI lsFichier = "sql.png"; URI uri
		 * = new URI("file:///" + lsCheminRacineSD + "/" + lsFichier);
		 * 
		 * URL url = uri.toURL(); // --- Connexion URLConnection urlCon =
		 * url.openConnection(); // --- Recuperation du flux is =
		 * urlCon.getInputStream();
		 * 
		 * // --- Affichage d'une image --- // Bitmap bitmap =
		 * BitmapFactory.decodeStream(is); imageView1.setImageBitmap(bitmap);
		 * 
		 * //lsbContenu.append("OK"); } catch (Exception e) {
		 * lsbContenu.append(e.getMessage()); }
		 * 
		 * // --- Messages textView1.setText(lsbContenu.toString());
		 */

	} // / onCreate

	private void testsDivers() {
		Context contexte = getBaseContext();
		StringBuilder lsbResultatsFiles = new StringBuilder();

		File dir;
		String[] tFichiers;
		//File[] tDossiers;

		try {
			/*
			 * Le dossier files donc /data/data/nom.du.package/files/
			 */
			// Renvoie /data/data/fr.pb.data.fichier/files
			dir = contexte.getFilesDir();
			lsChemin = dir.getAbsolutePath() + "/";
			lsbResultatsFiles.append("Dossier files\n");
			lsbResultatsFiles.append("\n");

			// Liste les fichiers
			tFichiers = dir.list();
			lsbResultatsFiles.append("Contenu : \n");
			for (int i = 0; i < tFichiers.length; i++) {
				lsbResultatsFiles.append(tFichiers[i]);
				lsbResultatsFiles.append("\n");
				
			//ajouter le chemin	
				
				
				
			}
		} catch (Exception e) {
			lsbResultatsFiles.append(e.getMessage());

		}
		textView1.setText(lsbResultatsFiles.toString());
	}

} // / class
