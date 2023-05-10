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
    public double backzeitMinuten() {
    	
    	return (double) backzeit/60;
    }
    /** 
     * @return float
     */
    public float berechneHoehe() {
        return hoehe += ((backzeit*0.025)*backzeitMinuten());
    }

    public void zubereiten() {
        System.out.println(getName() +" "+ backzeitMinuten() + " Minuten rösten und aufschneiden");
        }
}
