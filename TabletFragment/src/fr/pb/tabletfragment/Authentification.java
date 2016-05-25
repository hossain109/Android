package fr.pb.tabletfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class Authentification extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.authentification);
	} /// onCreate
	public void retourAccueil(View vue) {
		finish();
	}
} /// class Authentification 