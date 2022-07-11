import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Eingabe {
    public Fach[] datenEinlesen() {
        Fach[] arr = new Fach[8];
        for (int i = 0; i < 8; i++) {
            Fach f = new Fach(inputFach(), inputLk(), inputNote());
            arr[i] = f;
        }
        return arr;
    }

    // Scanner

    private String inputFach() {
        String fach;
        do {
            System.out.println("Gebe das Fach ein: ");
            fach = Main.sc.nextLine();
        } while (!testFach(fach));
        return fach;
    }

    private boolean inputLk() {
        System.out.println("Leistungskurs? (Ja/Nein): ");
        String lk = Main.sc.nextLine();
        return lk.equalsIgnoreCase("ja");
    }

    private int inputNote() {
        int note;
        do {
            System.out.println("Gebe die Note des Fachs ein: ");
            note = Integer.parseInt(Main.sc.nextLine());
        } while (!(note >= 0 && note <= 15));
        return note;
    }

    // Prüfung

    private boolean testFach(String fach) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(fach);
        return matcher.find();
    }
}