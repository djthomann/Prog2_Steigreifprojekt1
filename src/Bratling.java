public class Bratling extends Zutat{
    
    private int bratzeit;
    private int hoehe;
    

    public Bratling(int nummer, String name, float preis, boolean klassisch, boolean vegetarisch, boolean vegan, int bratzeit, int hoehe) {
        super(nummer, name, preis, klassisch, vegetarisch, vegan);
        this.bratzeit = bratzeit;
        System.out.println(name + this.bratzeit);
        this.hoehe = hoehe;
    }

    
    /** 
     * @return float
     */
    public float berechneHoehe() {
        System.out.println("Bratling - Grundhöhe" + hoehe + "Schwund: " + ((hoehe*0.035f)*bratzeitGesamt()));
        System.out.println("Schwund pro Minute: " + hoehe*0.035);
        System.out.println("Bratzeit: " + bratzeitGesamt());
        return hoehe - ((hoehe*0.035f)*bratzeitGesamt());
    }
    
    public float bratzeitGesamt() {
    	return (float) bratzeit/60;
    }

    public int bratzeitMinuten() {
    	return bratzeit/60;
    }
    
    public int bratzeitSekunden() {
    	return  bratzeit-(bratzeitMinuten()*60);
    }
    
    public void zubereiten() {
        System.out.println(getName() + " von jeder Seite " + bratzeitMinuten() + " Minuten und " + bratzeitSekunden()+ " Sekunden grillen" );
    }
}
