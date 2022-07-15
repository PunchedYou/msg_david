import java.util.HashMap;
import java.util.Map;

public class Dictonary {
    private Map<String, Integer> dic = new HashMap<>();

    /*
     * 0 = NW
     * 1 = Sprache
     * 2 = Gesellsch.
     * 3 = Kunst
     */

    public Dictonary() {
        dic.put("Mathematik", 0);
        dic.put("Mathe", 0);
        dic.put("Informatik", 0);
        dic.put("Erdkunde", 0);
        dic.put("Physik", 0);
        dic.put("Chemie", 0);
        dic.put("Biologie", 0);
        dic.put("Deutsch", 1);
        dic.put("Englisch", 1);
        dic.put("Spanisch", 1);
        dic.put("Französisch", 1);
        dic.put("Latein", 1);
        dic.put("Politik", 2);
        dic.put("Geschichte", 2);
        dic.put("Religion", 2);
        dic.put("Werte und Normen", 2);
        dic.put("Kunst", 3);
        dic.put("Musik", 3);
        dic.put("Darstellendes Spiel", 3);
    }

    public int getNumber(String name) {
        if (dic.containsKey(name)) {
            return dic.get(name);
        } else {
            return 4;
        }
    }
}