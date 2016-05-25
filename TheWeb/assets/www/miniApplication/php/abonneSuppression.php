<?php
    // --- abonneSuppression.php
    // --- Supprimer un abonne avec PHP dans un fichier XML (../xml/abonnes.xml)
    // --- abonne pseudo="milou" email="milou@free.fr" mdp="milou"

    $nomFichier = "../xml/abonnes.xml";

    // --- PHP 5
    $dom = new DOMDocument;
    $dom->preserveWhiteSpace = false;
    $dom->load($nomFichier);
    $dom->formatOutput = true;
    $racine = $dom->documentElement;

    // --- Recuperation des abonnes
    $xpath = new DOMXPath($dom);
    $lsRequete = "/root/abonne[@pseudo='" . $_POST["pseudo"] . "' and @mdp = '" . $_POST["mdp"] . "']";
    $abonnes = $xpath->query($lsRequete);

    //echo $_POST["pseudo"] ;
    //echo $_POST["mdp"] ;
    //echo $lsRequete;
    // --- Si trouve
    if($abonnes->length > 0)
    {
        $abonne = $abonnes->item(0);
        $racine->removeChild($abonne);
        $dom->save($nomFichier);
        echo "Suppression réalisée et enregistrée";
    }
    else echo "Aucun pseudo trouvé";



    // --- PHP V4 et ca roule chez FREE
    // --- Ouverture du fichier et recuperation de la racine
//    $dom = domxml_open_file($nomFichier);
//    $root = $dom->document_element();
//
//    // --- Recherche et suppression de l'element
//    $lbTrouve = false;
//    $abonnes = $dom->get_elements_by_tagname("abonne");
//    foreach($abonnes as $abonne) {
//        $pseudo = $abonne->get_attribute("pseudo");
//        $mdp    = $abonne->get_attribute("mdp");
//        if($pseudo == $_POST["pseudo"] && $mdp == $_POST["mdp"]) {
//            $root->remove_child($abonne);
//            $lbTrouve = true;
//        }
//    }
//    if($lbTrouve) echo "Suppression réalisée et enregistrée";
//    else echo "Aucun pseudo trouvé";
//
//    // --- Sauvegarde du DOM dans le fichier
//    $dom->dump_file($nomFichier, false, true);
?>
