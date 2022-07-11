import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ausgabe {
    private double schnitt;
    private boolean versetzung;

    public double berechneSchnitt(Fach[] faecher) {
        int ges = 0;
        int zaehler = 0;
        for (int i = 0; i < 8; i++) {
            if (faecher[i].getLk()) {
                ges += faecher[i].getNote() * 2;
            } else {
                ges += faecher[i].getNote();
            }

            if (faecher[i].getNote() < 5) {
                zaehler++;
            }
        }

        versetzung = zaehler < 3;

        double x = (double) ges / 10;
        double snt = (17 - x) / 3;
        schnitt = Math.round(10.0 * snt) / 10.0;
        return schnitt;
    }

    public void konsoleAusgabe(Zeugnis z, Fach[] faecher) {
        System.out.println("Name des Schülers: " + z.getSchueler());
        System.out.println("Zeugnisausstellung: " + z.getDatum());
        System.out.println("Fehltage: " + z.getFehltage());
        System.out.println("Unentschuldigt : " + z.getUnentschuldigt() + "\n");

        for (int i = 0; i < 8; i++) {
            System.out.println(faecher[i].getName() + ": " + faecher[i].getNote());
        }

        System.out.println("\nNotendurchschnitt: " + schnitt + "\n");

        if (z.getUnentschuldigt() >= 30) {
            versetzung = false;
        }

        if (versetzung) {
            System.out.println("Der Schüler wird versetzt.");
        } else {
            System.out.println("Der Schüler wird nicht versetzt.");
        }
    }

    public void write(Zeugnis z, Fach[] faecher) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Zeugnis.txt"))) {
            writer.write("Name des Schulers: " + z.getSchueler() + "\n");
            writer.write("Zeugnisausstellung: " + z.getDatum() + "\n\n");

            writer.write("Fehltage: " + z.getFehltage() + "\n");
            writer.write("Unentschuldigt : " + z.getUnentschuldigt() + "\n\n");

            for (int i = 0; i < 8; i++) {
                writer.write(faecher[i].getName() + ": " + faecher[i].getNote() + "\n");
            }

            writer.write("\nNotendurchschnitt: " + schnitt + "\n\n");

            if (z.getUnentschuldigt() >= 30) {
                versetzung = false;
            }

            if (versetzung) {
                writer.write("Der Schuler wird versetzt.\n");
            } else {
                writer.write("Der Schuler wird nicht versetzt.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nZeugnis.txt erfolgreich erstellt.");
    }
}
