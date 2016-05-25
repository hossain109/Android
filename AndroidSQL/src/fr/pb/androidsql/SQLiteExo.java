package fr.pb.androidsql;

import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.R.string;
import android.app.ListActivity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SQLiteExo extends ListActivity {
	private VilleDAOExo gos;
	private SQLiteDatabase sldb;
	private VilleDAOExo idaoExo;
	private Context contexte;
	String lsMessage = "";
	TextView textViewMessage;
	TextView textViewAffichage;
	List<Ville> aaliste;

	private boolean ibOK;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite_exo);
		textViewMessage = (TextView) findViewById(R.id.textViewMessage);
		textViewAffichage = (TextView) findViewById(R.id.textViewAffichage);

		boolean lbConnection = false;
		String[] tVilles = null;

		try {
			String lsChemin = "/data/data/fr.pb.androidsql/databases/cours.db";
			this.sldb = SQLiteDatabase.openDatabase(lsChemin, null,
					SQLiteDatabase.OPEN_READWRITE);

			
			lbConnection = true;

			Log.e("cnx", Boolean.toString(lbConnection));
			
			idaoExo = new VilleDAOExo(sldb);

			aaliste = idaoExo.selectAll();
			if (aaliste.size() == 0) {
				lsMessage = "Aucun enregistrement";
				tVilles = new String[1];
				tVilles[0] = "Vide";
			} else {
				lsMessage = "";
				tVilles = new String[aaliste.size()];
				for (int i = 0; i < aaliste.size(); i++) {
					Ville ville = aaliste.get(i);
					tVilles[i] = ville.getNomVille();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			lsMessage = e.getMessage();
		}

		textViewMessage.setText(lsMessage);

		ArrayAdapter<String> arayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, tVilles);
		this.setListAdapter(arayAdapter);

	}

}
