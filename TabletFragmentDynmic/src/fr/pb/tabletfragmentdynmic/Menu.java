package fr.pb.tabletfragmentdynmic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

// -------------------------------
public class Menu extends Fragment implements OnItemClickListener {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstance) {

		View vue = inflater.inflate(R.layout.menu, container, false);

		ListView listView1 = (ListView) vue
				.findViewById(R.id.listViewMenuPrincipal);
		listView1.setOnItemClickListener(this);

		return vue;
	} // / onCreateView

	@Override
	public void onItemClick(AdapterView<?> av, View v, int position, long id) {

		FragmentManager fragmentManager = getFragmentManager();

		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

		Fragment fragment = null;

		switch (position) {
		case 0:
			fragment = new CouleurDuMensonge();
			break;
		case 1:
			fragment = new HommesDHonneur();
			break;
		default:
			break;
		}

		fragmentTransaction.replace(R.id.detailFragment, fragment);

		fragmentTransaction.commit();

	} // / onItemClick

} // / class Menu
