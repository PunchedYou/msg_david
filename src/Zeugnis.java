import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Fach {
    private boolean lk;
    private String fachname;
    private int note;

    public Fach(String name, boolean lk, int note) {
        this.lk = lk;
        this.fachname = name;
        this.note = note;
    }

    public String getName() {
        return fachname;
    }

    public boolean getLk() {
        return lk;
    }

    public int getNote() {
        return note;
    }
}

public class Zeugnis {
    private String schueler;
    private String datum;
    private int fehltage;
    private int entschuldigt;
    private int unentschuldigt;

    public Zeugnis() {
        setSchueler();
        setDatum();

        System.out.println("Anzahl der Fehltage: ");
        fehltage = Integer.parseInt(Main.sc.nextLine());

        System.out.println("Anzahl davon Entschuldigt: ");
        entschuldigt = Integer.parseInt(Main.sc.nextLine());

        unentschuldigt = fehltage - entschuldigt;
    }

    // Getter

    public String getSchueler() {
        return schueler;
    }

    public String getDatum() {
        return datum;
    }

    public int getFehltage() {
        return fehltage;
    }

    public int getEntschuldigt() {
        return entschuldigt;
    }

    public int getUnentschuldigt() {
        return unentschuldigt;
    }

    // Setter

    public void setSchueler() {
        String str;
        do {
            System.out.println("Name des Schülers: ");
            str = Main.sc.nextLine();
        } while (!testSchueler(str));
        schueler = str;
    }

    public void setDatum() {
        String str;
        do {
            System.out.println("Datum der Zeugnisausgabe: ");
            str = Main.sc.nextLine();
        } while (!testDatum(str));
        datum = str;
    }

    // Prüfung

    private boolean testSchueler(String name) {
        Pattern pattern = Pattern.compile("^[a-zäöüß \\-]+$", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    private boolean testDatum(String datum) {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        df.setLenient(false);
        try {
            df.parse(datum);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}