package fr.pb.androidsql;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class VilleDAOExo {

	private static final String TABLE_NAME = "villes";
	private SQLiteDatabase sldb;

	// --- CONSTRUCTEUR
	public VilleDAOExo(SQLiteDatabase bd) {
		this.sldb = bd;

		}
	
	
	
	public List<Ville> selectAll(){
		List<Ville> aliste = new ArrayList<Ville>();
		
		// --- Tous les enregistrements
				try {
					String[] cols = { "cp", "nom_ville" , "id_pays"};

					Cursor curseur = this.sldb.query(TABLE_NAME, cols, null, null, null, null, null);

					// Cursor curseur =
					// this.ibd.rawQuery("SELECT cp, nom_ville FROM villes", null);
					while (curseur.moveToNext()) {
						Ville ville = new Ville();
						ville.setNomVille(curseur.getString(1));
						aliste.add(ville);
					}
				} catch (SQLiteException e) {
					Ville ville = new Ville();
					ville.setNomVille(e.getMessage());
				}
		
		return aliste;
		
	}


}