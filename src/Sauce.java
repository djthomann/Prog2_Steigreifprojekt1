public class Sauce extends Zutat{
    
    private int menge;
    private String geschmack;

    public Sauce(int nummer, String name, float preis, boolean klassisch, boolean vegetarisch, boolean vegan, int menge, String geschmack) {
        super(nummer, name, preis, klassisch, vegetarisch, vegan);
        this.menge = menge;
        this.geschmack = geschmack;
    }

    
    /** 
     * @return String
     */
    public String getGeschmack() {
        return geschmack;
    }

    public void zubereiten() {
        System.out.println(getName() + " wird geschüttelt");
        }
}
