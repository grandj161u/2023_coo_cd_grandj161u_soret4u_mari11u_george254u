import XML.ChargeurMagasin;
import donnees.Magasin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMagasin {

    @Test
    void testTrierAlbum() throws FileNotFoundException {
        String repertoire = "musicbrainzSimple/";
        ChargeurMagasin charge = new ChargeurMagasin(repertoire);
        Magasin magasin = charge.chargerMagasin();

        magasin.trierAlbum();

        assertEquals("Believe",magasin.getCd(0).getNomCD(),"le premier album doit etre Believe");
        assertEquals("Whitney Houston",magasin.getCd(magasin.getNombreCds()-1).getNomCD(), "le dernier album doit etre Whitney Houston");
    }
}
