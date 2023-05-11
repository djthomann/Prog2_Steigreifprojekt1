public class Broetchen extends Zutat{
    
    private int backzeit;
    private int hoehe;
    

    public Broetchen(int nummer, String name, float preis, boolean vegetarisch, boolean vegan, int backzeit, int hoehe) {
        super(nummer, name, preis, false, vegetarisch, vegan); // Brtöchen sind nie klassisch, sondern mindestens vegetarisch!
        this.backzeit = backzeit;
        this.hoehe = hoehe;
    }

    
    public int backzeit() {
    	return backzeit;
    }

    public float backzeitMinuten() {
    	
    	return (float) backzeit/60;
    }
    /** 
     * @return float
     */
    public float berechneHoehe() {
        System.out.println("Brötchen - Grundhöhe" + hoehe + "Schwund: " + hoehe*0.035f*backzeitMinuten());
        System.out.println("Schwund pro Minute: " + hoehe*0.025);
        System.out.println("Backzeit: " + backzeitMinuten());
        return hoehe + ((hoehe*0.025f)*backzeitMinuten());
    }

    public void zubereiten() {
        System.out.println(getName() +" "+ backzeitMinuten() + " Minuten rösten und aufschneiden");
        }
}
