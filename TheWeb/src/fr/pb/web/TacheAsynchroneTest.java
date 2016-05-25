package fr.pb.web;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/*
 * Executer une tache en arriere-plan en mode asynchrone
 */
public class TacheAsynchroneTest extends Activity implements OnClickListener {

	private TextView textViewProgressionPourcentage;
	private Button buttonTacheAsynchrone;
	private ProgressBar barreDeProgression;

	@Override
	// --------------------
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tache_asynchrone_test);

		initInterface();
	} // / onCreate

	// -----------------------
	private void initInterface() {

		textViewProgressionPourcentage = (TextView) findViewById(R.id.textViewProgressionPourcentage);
		buttonTacheAsynchrone = (Button) findViewById(R.id.buttonTacheAsynchrone);
		barreDeProgression = (ProgressBar) findViewById(R.id.barreDeProgression);

		buttonTacheAsynchrone.setOnClickListener(this);
		buttonTacheAsynchrone.setText("TacheAsynchroneTest");
	} // / initInterface

	@Override
	// ----------------
	public void onClick(View vue) {

		// --- Tache asynchrone
		if (vue == buttonTacheAsynchrone) {
			new TacheAsynchrone().execute("");

			
		} // / if buttonTacheAsynchrone

	} // / onClick

	/*
	 * AsyncTask<Params, Progress, Result>
	 */
	private class TacheAsynchrone extends AsyncTask<String, Integer, String> {
		@Override
		// ----------------------------
		protected String doInBackground(String... asParametres) {
			// String... parametre : nombre variable d'arguments

			// Se deplace dans un thread d'arriere-plan
			String lsResultat = "";
			int liProgression;

			// Execute la tache en arriere-plan et maj de la barre de progression
			for (liProgression = 0; liProgression < 100; liProgression++) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				// Sans l'appel a cette methode l'UI n'est pas maj
				publishProgress(liProgression);
				
			}

			lsResultat = Integer.toString(liProgression) + " %";
			// Renvoie la valeur a onPostExecute
			return lsResultat;
		} // / doInBackground

		@Override
		// ----------------------------
		protected void onProgressUpdate(Integer... aiProgressions) {
			// Synchronisation avec le thread de l'UI
			// MAJ de la barre de progression
			barreDeProgression.setProgress(aiProgressions[0]);
			textViewProgressionPourcentage.setText(Integer.toString(aiProgressions[0]) + " %");
		} // / onProgressUpdate

		@Override
		// -------------------------
		protected void onPostExecute(String asResultat) {
			// Synchronisation avec le thread de l'UI
			// Affiche le resultat final
			barreDeProgression.setProgress(100);
			textViewProgressionPourcentage.setText("Termine");
			
		} // / onPostExecute
	} // / TacheAsynchrone


}
