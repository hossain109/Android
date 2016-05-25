package fr.pb.electionfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.content.DialogInterface;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CandidatFO extends Activity implements OnClickListener {
    Spinner spinnerCandidat;
    Button buttonValider;
    TextView textViewCandidat;
    ImageView imageViewCandidat;
    TextView textViewVotants;
    TextView textViewPercentage,textViewInscription;
    
   

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.candidat_fo);

		initInterface();
		//ajout adapter
		List<String> listesCandidat = lireRessourceXML(R.xml.candidat, "candidat","nomcandidat");
		ArrayAdapter<String> aaResult = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listesCandidat);
		spinnerCandidat.setAdapter(aaResult);
		
		//textViewCandidat.setText(spinnerCandidat.getSelectedItem().toString());
		buttonValider.setOnClickListener(this);
		
		//les valuer des candidats
		//String candidat =  spinnerCandidat.getSelectedItem().toString();

		
		//les images des candidat
	

		
	}
      @Override
    public void onClick(View v) {
    	// TODO Auto-generated method stub
    	  if(buttonValider==v){
    		   
    		    String[] candidats = {"Anne Hidalgo","NKM","Christophe Najdovski","Danielle Simonnet","Charles Beigbeder","Wallerand de Saint-Just"};
    			String[] votans = {"250","300","100","150","400","150"};
    			String[] images= {"anne","anne1","anne2","anne3","anne4","france"};
    			String numeroInscrit = "1550";
    			String[] imageCandidat = new String[6];
 
    			images[0] = String.valueOf(R.drawable.anne);
    			images[1] = String.valueOf(R.drawable.anne1);
    			images[2] = String.valueOf(R.drawable.anne2);
    			images[3] = String.valueOf(R.drawable.anne3);
    			images[4] = String.valueOf(R.drawable.anne4);
    			images[5] = String.valueOf(R.drawable.france);
    			

    			 double inscrit = Double.parseDouble(numeroInscrit);
    			 double votant =0.0;

    			 String candidat = spinnerCandidat.getSelectedItem().toString();
    			 //imageCandidat.
    				try {
    					
    					List<Map<String, String>> listeCandidat = new ArrayList<Map<String, String>>();
    					
    					Map<String, String>hm;
    					for (int i = 0; i < candidats.length; i++) {
    						hm = new HashMap<String, String>();
							hm.put("candidat", candidats[i]);
							hm.put("votant", votans[i]);
							hm.put("image", images[i]);
							hm.put("inscrit", inscrit+"");
							listeCandidat.add(hm);
						}

    			        for (int i = 0 ; i < listeCandidat.size() ; i++) {
    			        	if(spinnerCandidat.getSelectedItemPosition()==i){
    			            Map<String, String> myMap = listeCandidat.get(i);

    			            for (Entry<String, String> entrySet : myMap.entrySet()) {
    			               if(entrySet.getKey().equals("candidat")){textViewCandidat.setText(entrySet.getValue());}
    			               if(entrySet.getKey().equals("votant")){
    			            	  votant= Double.parseDouble(entrySet.getValue());
    			            	   textViewVotants.setText(entrySet.getValue());}
    			               if(entrySet.getKey().equals("image")){
    			            	   String condidatImage = entrySet.getValue();
    			            	   int liIdImage = Integer.valueOf(condidatImage);
    			            		imageViewCandidat.setImageResource(liIdImage);   
    			               }

    
    			                //Toast.makeText(getBaseContext(), "Key = " + entrySet.getKey() + " , Value = " + entrySet.getValue(), Toast.LENGTH_LONG).show();
    			            }
    			            double resultat = (votant*100)/inscrit;
    			            textViewPercentage.setText(String.format("%.2f", resultat));
    			            textViewInscription.setText(numeroInscrit);
    			            	}
    			        }
    					 
    					
    				} catch (Exception e) {
    					Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
    				}
    			 

    	  }
    	
    }
	
	//interface
	private void initInterface(){
		spinnerCandidat = (Spinner)findViewById(R.id.spinnerCandidat);
		buttonValider = (Button)findViewById(R.id.buttonValider);
		textViewCandidat = (TextView)findViewById(R.id.textViewCandidat);
		textViewVotants = (TextView)findViewById(R.id.textViewVotants);
		textViewInscription = (TextView)findViewById(R.id.textViewInscription);
		textViewPercentage = (TextView)findViewById(R.id.textViewPercentage);
		imageViewCandidat = (ImageView)findViewById(R.id.imageViewCandidat);
		
	}
    

	
	private List<String> lireRessourceXML(int aiResource, String asBalise, String nomcandidat){
		List<String> liste = new ArrayList<String>();
		
		try {
			// --- On ouvre le document XML
			XmlPullParser xpp = getResources().getXml(aiResource);
			// --- Tant que le document n'a pas ete analyse jusqu'a fin
			while (xpp.getEventType() != xpp.END_DOCUMENT) {
				// --- Si c'est une balise ouvrante
				if (xpp.getEventType() == xpp.START_TAG) {
					// --- Si la balise s'appelle [XXX]
					if (xpp.getName().equals(asBalise)) {
						// --- Pour aller sur le noeud #text
						String lsValeurAttribut = xpp.getAttributeValue(null, "nomcandidat");
						if (lsValeurAttribut != null) {
						    // Code qui ajoute la valeur quelque part 
							liste.add(lsValeurAttribut);
						}
					
					} // / IF balise "XXX" trouvee

				} // / IF start_tag

				// --- On passe a la balise suivante ou element suivant
				xpp.next();
				
			}
			
		} catch (Throwable e) {
			// TODO: handle exception
			textViewCandidat.setText("Erreur" + e.getMessage());
		}
		
		return liste;
	}


	
}
