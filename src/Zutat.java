public class Zutat {
    
    private int nummer;
    private String name;
    private float preis;
    private boolean klassisch, vegetarisch, vegan;

    private static int laengsterName;

    public Zutat(int nummer, String name, float preis, boolean klassisch, boolean vegetarisch, boolean vegan) {
        this.nummer = nummer;
        this.name = name;
        this.preis = preis;
        this.klassisch = klassisch;
        this.vegetarisch = vegetarisch;
        this.vegan = vegan;
        if(name.length() > laengsterName) {
            laengsterName = name.length();
        }
    }

    
    /** 
     * @return int
     */
    public void zubereiten() {
    }

    public float berechneHoehe() {
        return 0;
    }

    public String toString() {
        String s = nummer + " | " + name + " ";
        if(name.length() < laengsterName) {
            for(int i = 0; i < laengsterName - name.length(); i++) {
                s = s.concat(" ");
            }
        }
        s = s.concat("| " + preis + " Euro");
        return s;
    }

    public float getPreis() {
        return preis;
    }

    public boolean istKlassisch() {
        return klassisch;
    }

    public boolean istVegetarisch() {
        return vegetarisch;
    }

    public boolean istVegan() {
        return vegan;
    }

    public int getNummer() {
        return nummer;
    }

    public String getName() {
        return name;
    }

}
