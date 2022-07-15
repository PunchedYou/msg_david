import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Zeugnis zeugnis = new Zeugnis();
        System.out.println();

        // Eingabe e = new Eingabe();
        // Fach[] faecher = e.datenEinlesen();

        System.out.println("Fächer: Manueller Test");
        Fach[] faecher = {
                new Fach("Mathe", true, 12),
                new Fach("Informatik", true, 8),
                new Fach("Erdkunde", false, 14),
                new Fach("Physik", false, 4),
                new Fach("Englisch", false, 1),
                new Fach("Sport", false, 15),
                new Fach("Geschichte", false, 3),
                new Fach("Darstellendes Spiel", false, 15),
        };

        System.out.println("\n---------------\n");

        Ausgabe a = new Ausgabe();
        a.berechneSchnitt(faecher);
        a.konsolenAusgabe(zeugnis, faecher);
        a.dateiAusgabe(zeugnis, faecher);

        sc.close();
    }
}