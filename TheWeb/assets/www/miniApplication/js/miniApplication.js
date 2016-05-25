/*
 * miniapplication.js
 */ 

/*
 * getAttributsValeursURL()
 *  @returns {unresolved}
 * Recuperer les attributs d'une URL
 * 
 * Le but de cette fonction est de recuperer les attributs/valeurs de l'URL
 * http://ip/chemin/ressource?a1=v1&a2=v2...
 * On recupere d'abord : ?a1=v1&a2=v2...
 * On elimine le ? : a1=v1&a2=v2...
 */
function getAttributsValeursURL()
{
    // --- On recupere l'URL a partir du ? compris
    var sURL = new String(window.location.search);
    //console.log(sURL);

    // --- On recupere l'URL apres le ?
    // --- Et on la decode (decodeURI ne fonctionnant pas)
    var sAttributsValeurs = unescape(sURL.substr(1));
    //console.log(sAttributsValeurs);

    return sAttributsValeurs;
} /// getAttributsValeursURL



/*
 * getValeurs(atAttributsValeurs)
 * @param {type} atAttributsValeurs
 * @returns {Array}
 * 
 * A partir d'un tableau du type [a1=v1,a2=v2,...]
 * on recupere un tableau du type [v1,v2,...]
 */
function getValeurs(atAttributsValeurs)
{
    //console.log("atAttributsValeurs : " + atAttributsValeurs);
    //console.log("atAttributsValeurs : " + atAttributsValeurs[0]);

    var nTailleTableau = atAttributsValeurs.length;
//console.log("Taille tableau : " + nTailleTableau);
    var tValeurs = new Array(nTailleTableau);

    for(var i=0; i<nTailleTableau; i++) {
        //console.log("atAttributsValeurs[i] : " + atAttributsValeurs[i]);
        t = atAttributsValeurs[i].split("=");
        //console.log(t);
        tValeurs[i] = t[1];
    }

    return tValeurs;
} /// getValeurs
