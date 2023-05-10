import javax.management.loading.MLet;

/**
 * 
 * Hauptklasse in der Menu und Bestellliste verwaltet und Kommandos des Nutzers verarbeitet werden.
 * Über einen while-loop wird solange ein Kommando vom Nutzer abgefragt, bis dieser den laufend-boolean per Kommando "beenden" auf false setzt
 * 
 * @author Lisa Kügler, David Thomann
 * -> Done TODO: Zubereiten Methode für alle Zutaten implimentieren
 * -> Done TODO: rezeptAusgeben Methode (siehe Folie 5) in Burger Klasse
 * TODO: gesamtZubereitungsZeit und gesamtPreis Methoden implimentieren
 * -> DoneTODO: Dynamische Backzeit relevant für Höhe Brötchen und Bratling
 * TODO: burgerErstellen und zutatenListe erstellen Methoden abändern
 * TODO: Was muss abstract sein?
 * TODO: Genau ein Burgerbrötchen muss dabei sein
 * TODO: Ignore Case bei Eingabe
 * TODO: Evtl. Zeit im konstruktor zu Double (Auf der Folie steht int ist aber unpraktischer)
 * -> Done TODO: Bratzeit in Min + sek 
 * TODO: Dokumentation
 *  * 
 */

public class Burgerladen {

    // -------------------------------------------
    // FELDER

    /**
     * Zwei Konstanten waren aus der Aufgabe vorgegeben: Maximale Zutaten pro Burger und maximale Anzahl an Bestellungen/Burgern
     */
    public static final int MAXIMALE_ZUTATEN = 9;
    public static final int MAXIMALE_BURGER = 10;

    private static String eingabe;
    private static Menu meinMenu;
    private static Bestellliste meineBestellungen;
    private static boolean laufend;

    /**
     * Erstellen der Menu- und Bestellisten-Instanz 
     * Zentrale Verwaltungsstelle für Zutaten, die auf der Karte stehen sollen
     * 
     */

    public Burgerladen() {

        meinMenu = new Menu(16);

        meinMenu.zutatHinzufuegen(new Broetchen(10, "Hamburger (Standard)", 0.85f, true, false, 90, 27));
        meinMenu.zutatHinzufuegen(new Broetchen(11, "Hamburger Sesam", 0.95f, true, false, 90, 28));
        meinMenu.zutatHinzufuegen(new Broetchen(13, "Vegan-Brötchen", 0.55f, false, true, 240, 34));
        meinMenu.zutatHinzufuegen(new Broetchen(14, "Ciabatta", 0.45f, true, false, 330, 41));

        meinMenu.zutatHinzufuegen(new Bratling(20, "Rindfleisch (Original)", 1.85f, true, false, false, 270, 25));
        meinMenu.zutatHinzufuegen(new Bratling(21, "Hähnchenfleisch gegrillt", 1.15f, true, false, false, 180, 11));
        meinMenu.zutatHinzufuegen(new Bratling(22, "Falafel-Bratling", 1.45f, false, false, true, 210, 21));
        meinMenu.zutatHinzufuegen(new Bratling(23, "Gemüse-Bratling", 1.75f, false, true, false, 240, 25));

        meinMenu.zutatHinzufuegen(new Salat(30, "Eisbergsalat", 0.18f));
        meinMenu.zutatHinzufuegen(new Salat(31, "Rucolasalat", 0.25f));

        meinMenu.zutatHinzufuegen(new Gemuese(40, "Tomate", 0.25f, 3, 3));
        meinMenu.zutatHinzufuegen(new Gemuese(41, "Salzgurke", 0.15f, 4, 2));
        meinMenu.zutatHinzufuegen(new Gemuese(42, "Rote Zwiebelringe", 0.08f, 5, 2));
        meinMenu.zutatHinzufuegen(new Gemuese(43, "Jalapeno-Ringe", 0.08f, 5, 2));

        meinMenu.zutatHinzufuegen(new Sauce(50, "Ketchup", 0.10f, false, false, true, 5, "normal"));
        meinMenu.zutatHinzufuegen(new Sauce(51, "Sandwich-Sauce", 0.15f, false, true, false, 10, "normal"));
        meinMenu.zutatHinzufuegen(new Sauce(52, "Chili-Sauce", 0.25f, false, false, true, 8, "scharf"));
        meinMenu.zutatHinzufuegen(new Sauce(52, "Honig-Senf-Sauce", 0.25f, false, true, false, 8, "süß"));

        meineBestellungen = new Bestellliste();
        
        //Test Burger
        Burger burger = new Burger("NomNom");
        meineBestellungen.burgerHinzufuegen(burger);
        burger.zutatHinzufuegen(meinMenu.getZutat(14));
        burger.zutatHinzufuegen(meinMenu.getZutat(20));
        burger.zutatHinzufuegen(meinMenu.getZutat(40));
        burger.zutatHinzufuegen(meinMenu.getZutat(30));
        burger.zutatHinzufuegen(meinMenu.getZutat(52));
        
    }

    // ---------------------------------
    // METHODEN

    public static void burgerErstellen() {
        String name;
        System.out.println("Wie soll der Burger heißen?");
        name = StaticScanner.nextString();
        Burger burger = new Burger(name);
        meineBestellungen.burgerHinzufuegen(burger);
        zutatenlisteErstellen(burger);
        System.out.println("Fertiggestellter Burger:");
        System.out.println(burger.toString());
    }

    
    /** 
     * @param burger
     */
    public static void zutatenlisteErstellen(Burger burger) {
        int eingabe;
        Zutat zutat;
        do {
            System.out.println("Zutat-Nr. eingeben: ('0' stellt den Burger fertig)");
            eingabe = StaticScanner.nextInt();
            if(eingabe == 0) {
                System.out.println("Zutatenliste wird fertiggestellt.");
                return;
            } else {
                zutat = meinMenu.getZutat(eingabe);
                if(zutat != null) {
                    burger.zutatHinzufuegen(zutat);
                }
                System.out.println("Keine gültige Zutat-Nr.");
            }
        } while(burger.getZutatenmenge() < MAXIMALE_ZUTATEN);
    }

    /**
     * Interpretation der Eingabezeile mit verschiedenen Kommandos
     * 
     * @param eingabe der vom Nutzer eingegebene String
     */

    public static void eingabeVerarbeiten(String eingabe) {
        switch(eingabe) {
            case "menu":
                System.out.println("Das ist das Menü:");
                meinMenu.menuAusgeben();
                break;
            case "neuer Burger":
                System.out.println("Neuer Burger wird erstellt!");
                burgerErstellen();
                break;
            case "meine Burger":
                System.out.println("Das sind die aktuellen Bestellungen:");
                meineBestellungen.bestellungenAusgeben();
                break;
            case "bestellen":
                System.out.println("Die Bestellung wird bearbeitet");
                laufend = false;
                System.out.println("Deine Bestellten Burger:");
                meineBestellungen.bestellungenAusgeben();
                
                
                break;
            default:
                System.out.println(eingabe + " ist keine gültige Eingabe!");
                break;
        }
    }

    /**
     * Erstellen des Burgerladens und kommando-Schleife
     * 
     * @param args wird nicht intepretiert
     */
    public static void main(String[] args) {

        Burgerladen meinLaden = new Burgerladen();
        laufend = true;

        while(laufend) {
            System.out.println("Geben Sie ein, was Sie tun möchten");
            eingabe = StaticScanner.nextString();
            eingabeVerarbeiten(eingabe);
        }
    }
}