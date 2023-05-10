public class Salat extends Zutat{
    
    public Salat(int nummer, String name, float preis) {
        super(nummer, name, preis, false, false, true); // Salat ist immer vegan
    }

    public void zubereiten() {
        System.out.println(getName() + " wird gewaschen und geschleudert");
        }
}
