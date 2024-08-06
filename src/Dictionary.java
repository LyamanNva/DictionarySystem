import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private String name;
    private Map<String, String> words;

    public Dictionary(String name) {
        this.name = name;
        this.words = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addWord(String word, String translation) {
        words.put(word, translation);
    }

    public void removeWord(String word) {
        words.remove(word);
    }

    public String translate(String word) {
        return words.get(word);
    }

    public Map<String, String> getAllWords() {
        return words;
    }
}