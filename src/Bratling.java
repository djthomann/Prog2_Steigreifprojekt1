public class Bratling extends Zutat{
    
    private int bratzeit;
    private int hoehe;
    

    public Bratling(int nummer, String name, float preis, boolean klassisch, boolean vegetarisch, boolean vegan, int bratzeit, int hoehe) {
        super(nummer, name, preis, klassisch, vegetarisch, vegan);
        this.bratzeit = bratzeit;
        this.hoehe = hoehe;
    }

    
    /** 
     * @return float
     */
    public float berechneHoehe() {
        return hoehe -= ((hoehe*0.035)*bratzeitGesamt());
    }
    
    public double bratzeitGesamt() {
    	return (double) bratzeit/60;
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
