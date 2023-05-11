public class Gemuese extends Zutat {
    
    private int scheibenAnzahl;
    private int scheibenDicke;

    public Gemuese(int nummer, String name, float preis, int scheibenAnzahl, int scheibenDicke) {
        super(nummer, name, preis, false, false, true); // Gemüse ist immer vegan
        this.scheibenAnzahl = scheibenAnzahl;
        this.scheibenDicke = scheibenDicke;
    }

    /** 
     * @return float
     */
    public float berechneHoehe() {
        return scheibenAnzahl * scheibenDicke;
    }
    /**
     * Anleitung zum zzubereiten des Gemüses
     * */
    public void zubereiten() {
        System.out.println(getName() + " wird gewaschen");
        for(int i=0; i<scheibenAnzahl; i++) {
        	System.out.println("\t" + (i+1) + ". Scheibe mit " + scheibenDicke + "mm schneiden" );
        }
    }
}
