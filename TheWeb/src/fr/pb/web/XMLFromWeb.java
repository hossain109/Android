package fr.pb.web;


import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;


/*
 * Recuperer du XML sur le WEB
 */
public class XMLFromWeb extends Activity {

    private TextView textViewXML;
    private static final String BALISE = "nom_ville";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_web);

        textViewXML = (TextView)findViewById(R.id.textViewXML);

        String URL = "http://172.26.10.21:80/RessourcesPourSmartphones/villesDoc.xml";
        String lsValeurs = "";
        InputStream is = null;

        /*
         * UTILISATION DE XPP
         */
     //   AnalyseurXMLXPP analyseurXPP = new AnalyseurXMLXPP();

       // is = analyseurXPP.getXmlISFromUrl(URL);

      //  lsValeurs = analyseurXPP.getValuesFromElement(is, BALISE);

        /*
         * AFFICHAGE
         */
        //textViewXML.setText(lsValeurs);

    } /// onCreate

} /// class