import XML.ChargeurMagasin;
import donnees.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMagasin {

    @Test
    //test de la methode trierAlbum
    void testTrierAlbum() throws FileNotFoundException {
        //preparation des donnees
        String repertoire = "musicbrainzSimple/";
        ChargeurMagasin charge = new ChargeurMagasin(repertoire);
        Magasin magasin = charge.chargerMagasin();
        //Test de la methode
        magasin.trier(new ComparateurAlbum());
        //Tests
        assertEquals("Believe",magasin.getCd(0).getNomCD(),"le premier album doit etre Believe");
        assertEquals("Whitney Houston",magasin.getCd(magasin.getNombreCds()-1).getNomCD(), "le dernier album doit etre Whitney Houston");
    }

    @Test
    //test la methode trierArtiste
    void testTrierArtiste() throws FileNotFoundException {
        //preparation des donnees
        String repertoire = "musicbrainzSimple/";
        ChargeurMagasin charge = new ChargeurMagasin(repertoire);
        Magasin magasin = charge.chargerMagasin();
        //Test de la methode
        magasin.trier(new ComparateurArtiste());
        //Tests
        assertEquals("Bénabar",magasin.getCd(0).getNomArtiste(),"le premier artiste doit etre Bénabar");
        assertEquals("Zebda",magasin.getCd(magasin.getNombreCds()-1).getNomArtiste(), "le dernier artiste doit etre Zebda");
    }

    /** @Test

    * Validation de la fonctionnalité triArtiste dans le cas où les éléments sont déjà triés

    public void verifierTriArtiste_SiDejaTrie() {
        // Initialisation
        Magasin boutique = new Magasin();
        CD album1 = new CD("Bieber", "Believe");
        CD album2 = new CD("Red Hot Chili Pepper", "Californication");
        CD album3 = new CD("Vian", "Le deserteur");
        CD album4 = new CD("Juliette", "Mutatis Mutandis");

        // Ajouter des CDs dans le magasin
        boutique.ajouteCd(album1);
        boutique.ajouteCd(album4);
        boutique.ajouteCd(album2);
        boutique.ajouteCd(album3);

        // Exécution de la méthode de tri
        boutique.trier(new ComparateurAlbum());

        // Vérifications
        CD cdCourant = boutique.getCd(0);
        // Comparaison des références
        assertEquals("Bieber a le plus petit nom", cdCourant, album1);

        cdCourant = boutique.getCd(1);
        assertEquals("Juliette vient après", cdCourant, album4);

        cdCourant = boutique.getCd(2);
        assertEquals("Red Hot vient ensuite", cdCourant, album2);

        cdCourant = boutique.getCd(3);
        assertEquals("Vian est le dernier", cdCourant, album3);
    } */

    @Test
        //test la methode trierArtiste
    void testTrierNbPistes() throws FileNotFoundException {
        //preparation des donnees
        String repertoire = "musicbrainzSimple/";
        ChargeurMagasin charge = new ChargeurMagasin(repertoire);
        Magasin magasin = charge.chargerMagasin();
        //Test de la methode
        magasin.trier(new ComparateurPiste());
        //Tests
        assertEquals("Whitney Houston",magasin.getCd(0).getNomArtiste(),"le premier artiste doit etre Whitney Houston");
        assertEquals("Justin Bieber",magasin.getCd(magasin.getNombreCds()-1).getNomArtiste(), "le dernier artiste doit etre Justin Bieber");
    }
}
