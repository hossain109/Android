package fr.pb.leslistes;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListeSimple extends ListActivity {

	private TextView textViewSelection;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.liste_simple);
		String[] tVilles = {"Paris","Lyon","Lille","Marseille","Bordeaux"};

        textViewSelection = (TextView) findViewById(R.id.textViewSelection);

        ArrayAdapter<String> aaListe = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tVilles);

        // --- Methode de la classe ListActivity pour remplir la liste 
        this.setListAdapter(aaListe);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.liste_simple, menu);
		return true;
	}

	@Override
	public void onListItemClick(ListView parent, View vue, int position, long id) {
		// Recupere le libelle de l'item selectionne de la ListView
		String lsSelection = parent.getItemAtPosition(position).toString();
		textViewSelection.setText(lsSelection);
	} // / onListItemClick()

}
