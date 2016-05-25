package fr.pb.leslistes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;

import android.widget.SimpleAdapter;
import android.widget.Toast;

import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import android.widget.ListView;

/*
 * ListePaysComplexe : liste des pays avec drapeau, nom, code ISO, indicatif telephonique
 */
public class ListePaysComplexe extends ListActivity {

	private TextView textViewPays;
	private ImageView imageViewPays;

	@Override
	// -----------------
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.liste_pays_complexe);

		textViewPays = (TextView)findViewById(R.id.textViewPays);
		imageViewPays = (ImageView)findViewById(R.id.imageViewPays);

		String[] tNomsPays = {"Fidji","Finlande","France"};
		String[] tCodeAlpha = {"FJ","FI","FR"};
		String[] tIndicatifsTelephoniques = {"679","358","33"};

		// Recupere l'id de l'image fidji ... en base decimale
		String[] tImages = new String[3];
		tImages[0] = String.valueOf(R.drawable.download);
		tImages[1] = String.valueOf(R.drawable.finlande);
		tImages[2] = String.valueOf(R.drawable.favicon_amandine);

		try {

			List<Map<String, String>> listePays = new ArrayList<Map<String, String>>();
			Map<String, String> hm;

			for(int i = 0; i < tNomsPays.length; i++) {
				hm = new HashMap<String, String>();

				hm.put("image", tImages[i]);
				hm.put("nom", tNomsPays[i]);
				hm.put("code_alpha", "Code ISO : " + tCodeAlpha[i]);
				hm.put("code_tel", "Indicatif téléphonique : " + tIndicatifsTelephoniques[i]);

				listePays.add(hm);
			}

			SimpleAdapter sa = new SimpleAdapter(
				this.getBaseContext(),
				listePays,
				R.layout.pays_ligne,
				new String[] { "image", "nom", "code_alpha", "code_tel" },
				new int[] { R.id.imageViewDrapeau, R.id.nom, R.id.code_alpha, R.id.code_tel }
			);

			this.setListAdapter(sa);

		} catch (Exception e) {
			Toast.makeText(getBaseContext(), "Erreur ? " + e.getMessage(), Toast.LENGTH_LONG).show();
		}

	} // / onCreate






@Override
// ------------------------
public void onListItemClick(ListView parent, View vue, int position, long id) {

	Map<String, String> hm = (Map<String, String>) parent.getItemAtPosition(position);

	textViewPays.setText(hm.get("nom"));
	int liIdImage = Integer.valueOf(hm.get("image"));
	imageViewPays.setImageResource(liIdImage);

} // / onListItemClick

} // / classe