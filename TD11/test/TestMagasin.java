import XML.ChargeurMagasin;
import donnees.ComparateurAlbum;
import donnees.ComparateurArtiste;
import donnees.ComparateurCd;
import donnees.Magasin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

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
}
