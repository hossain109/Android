<!DOCTYPE html>
<html>

<head>
    <title>abonneAjout.php</title>

    <meta charset="utf-8" />
    <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <link rel="stylesheet" href="../jquery/jquery.mobile.css" />
    <link rel="stylesheet" href="../css/miniApplication.css" />

    <script type="text/javascript" src="../jquery/jquery.js"></script>
    <script type="text/javascript" src="../jquery/jquery.mobile.js"></script>
    <script type="text/javascript" src="../js/miniApplication.js"></script>
</head>



<body>
    <div data-role="page">

        <div data-role="header">
            <div data-role="controlgroup" data-type="horizontal">
                <a href="../miniApplication/accueil.html" data-role="button" data-icon="home" data-iconpos="left">&nbsp;</a>
                <a href="../miniApplication/inscription.html" data-role="button">Inscription</a>
                <a href="../miniApplication/desinscription.html" data-role="button">Désinscription</a>
                <a href="../miniApplication/catalogue.html" data-role="button">Catalogue</a>
            </div>
        </div><!-- /header -->

        <div data-role="content">

<?php
    // --- abonneAjout.php
    // --- Ajouter un abonne avec PHP dans un fichier XML
    // --- Par exemple dans ../xml/abonnes.xml
    // --- <abonne pseudo="Milou" email="milou@free.fr" mdp="milou" />
    // --- Le schema est : XML disque -> XLM memoire -> Ajout element en memoire -> XML Disque

    // --- Le fichier source et destination
    $nomFichier = "../xml/abonnes.xml";

    // --- PHP 5
    // --- Creation d'un arbre DOM en memoire
    $dom = new DomDocument('1.0');
    // --- Elimination des caracteres "parasites" (espace, RC, tab, ...)
    $dom->preserveWhiteSpace = false;
    // --- Chargement du fichier dans l'arbre DOM
    $dom->load($nomFichier);

    // --- Preservation de l'indentation
    $dom->formatOutput = true;

    // --- Creation element abonne
    $element = $dom->createElement("abonne");

    // --- Ajout des attributs avec les valeurs
    // --- REQUEST gere aussi bien les requetes GET que POST
    $element->setAttribute("pseudo", $_REQUEST["pseudo"]);
    $element->setAttribute("email", $_REQUEST["email"]);
    $element->setAttribute("mdp", $_REQUEST["mdp"]);

    // --- Ajout de l'element au niveau racine
    $dom->documentElement->appendChild($element);

    // ---- Sauvegarde sur le disque
    $dom->save($nomFichier);



    // --- PHP V4 et ca roule chez FREE
    // --- Ouverture du fichier et recuperation de la racine
//    $dom = domxml_open_file($nomFichier);
//    $root = $dom->document_element();
//
//    // --- Ajout de l'element
//    $element = $dom->create_element("abonne");
//    $element->set_attribute("pseudo", $_REQUEST["pseudo"]);
//    $element->set_attribute("email", $_REQUEST["email"]);
//    $element->set_attribute("mdp", $_REQUEST["mdp"]);
//    $root->append_child($element);
//
//    // --- Sauvegarde du DOM dans le fichier
//    $dom->dump_file($nomFichier, false, true);

    echo "Nouvel abonné(e) ajouté(e)";
?>

        </div><!-- /content -->

        <div data-role="footer" data-position="fixed">
            &COPY; PB & co
        </div><!-- /footer -->

    </div><!-- /page -->
</body>
</html>


