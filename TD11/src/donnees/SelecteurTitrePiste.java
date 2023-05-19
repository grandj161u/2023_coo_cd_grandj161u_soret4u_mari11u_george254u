package donnees;

public class SelecteurTitrePiste implements Selecteur{

    private String nomArtiste;

    public SelecteurTitrePiste(String nomArtiste) {
        this.nomArtiste = nomArtiste;
    }

    @Override
    public boolean garderCd(CD cd) {
        return true;
    }
}
