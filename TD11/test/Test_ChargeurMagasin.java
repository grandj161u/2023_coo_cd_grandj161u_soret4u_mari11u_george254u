import donnees.Magasin;
import org.junit.jupiter.api.Test;
import XML.ChargeurMagasin;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test_ChargeurMagasin {

    @Test
    public void Test_ChargerMagasin_OK_01 () throws FileNotFoundException {
        ChargeurMagasin m = new ChargeurMagasin("musicbrainzSimple");
        Magasin res = new Magasin();

        res = m.chargerMagasin();

        assertEquals(12, res.getNombreCds(), "Il doit y avoir 12 CD");
    }

    @Test
    public void Test_ChargerMagasin_KO_02 (){
        ChargeurMagasin m = new ChargeurMagasin("MauvaisRep");


        FileNotFoundException exception = assertThrows(
                FileNotFoundException.class,
                () ->  {m.chargerMagasin();}
        );
    }
}
