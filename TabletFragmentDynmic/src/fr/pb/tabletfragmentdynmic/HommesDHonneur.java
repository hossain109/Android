package fr.pb.tabletfragmentdynmic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// --------------------------------------------
public class HommesDHonneur extends Fragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstance) {
		View vue = inflater.inflate(R.layout.hommes_dhonneur, container, false);
		return vue;
	} // / onCreate
}