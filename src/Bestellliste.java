/**
 * Verwaltung der Burger, über ein einfaches Array.
 * Es werden folgende Manipulatoren angeboten:
 *  - Burger Hinzufügen
 *  - Bestellungen Ausgeben
 *  - 
 */

public class Bestellliste {
    
    private Burger[] meineBurger;
    private int bestellteBurger;

    public Bestellliste() {
        meineBurger = new Burger[Burgerladen.MAXIMALE_BURGER];
        bestellteBurger = 0;
    }

    
    /** 
     * @param burger
     */
    public void burgerHinzufuegen(Burger burger) {
        meineBurger[bestellteBurger] = burger;
        bestellteBurger++;
    }

    public void bestellungenAusgeben() {

        for (int i = 0; i < meineBurger.length; i++) {
            if(meineBurger[i] != null) {
                System.out.println(i + " " + meineBurger[i].toString());  
                meineBurger[i].rezeptAusgeben();
            }
        }

    }

}
