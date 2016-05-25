package fr.pb.androidsql;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;

/*
 * Classe qui sert de fournisseur de donnees SQL (SQLite en l'occurrence)
 * 
 * Methodes : onCreate, query, insert, update, delete, getType
 */
public class FournisseurSQLite extends ContentProvider {

    private SQLiteDatabase db;

    public static final Uri CONTENT_URI = Uri.parse("content://fr.pb.androidsql.villes");

    @Override
    public boolean onCreate() {
        Context context = getContext();
        GestionnaireOuvertureSQLite dbHelper = new GestionnaireOuvertureSQLite(context, null);
        this.db = dbHelper.getWritableDatabase();
        return (this.db == null) ? false : true;
    } /// onCreate



    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor curseur = null;
        // --- Tous les enregistrements
        try {
            // --- query(table, tColonnes, sWhere, tParamsWhere, sGroupBy, sHaving, sOrdeBy)
            curseur = this.db.query("villes", projection, selection, selectionArgs, null, null, sortOrder);
        }
        catch(SQLiteException e) {
            curseur = null;
        }
        return curseur;
    } /// query



    @Override
    public Uri insert(Uri uri, ContentValues values) {
          Uri u=null;
          try {
    	  long rowID = db.insert(uri.getLastPathSegment(), "", values);
    		  u = Uri.parse(String.valueOf(rowID));
    	  // getContext().getContentResolver().notifyChange(uri, null);
          }catch(SQLiteException e){
        	  u=null;
          }
   	   return uri;
    } /// insert



    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    } /// update



    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        // --- delete(table, sWhere, tWhere)
        int count = this.db.delete("villes", "cp=?", selectionArgs);
        return count;
    } /// delete



    @Override
    public String getType(Uri uri) {
        return null;
    } /// getType

} /// FournisseurSQLite