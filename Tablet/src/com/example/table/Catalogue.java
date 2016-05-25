package com.example.table;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Catalogue extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.catalogue);
	} /// onCreate

	public void afficherAuthentification(View vue) {
		Intent intention = new Intent(this, Authentification.class);
		startActivity(intention);
	} /// afficherAuthentification

	public void afficherCatalogue(View vue) {
		Intent intention = new Intent(this, Catalogue.class);
		startActivity(intention);
	} /// afficherCatalogue

	public void retourAccueil(View vue) {
		this.finish();
	} /// retourAccueil

} /// class Catalogue