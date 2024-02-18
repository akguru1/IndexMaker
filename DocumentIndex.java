import java.util.ArrayList;
import java.util.*;

public class DocumentIndex extends ArrayList<IndexEntry> {
    //  Creates an empty DocumentIndex with the default initial capacity.
    public DocumentIndex() {
        super();
    }

    //  Creates an empty DocumentIndex with a given  initial capacity.
    public DocumentIndex(int initialCapacity) {
        super(initialCapacity);
    }

    public void addWord(String word, int num){
        if (word.length() >0) {
            int index = foundOrInserted(word.trim());
            get(index).add(num);
        }
    }

    public void addAllWords(String str, int num) {
        String[] words = str.split(" ");
        for (String word : words) {
        // Remove special characters and convert to uppercase
            addWord(word.replaceAll("[^a-zA-Z0-9]", "").toUpperCase(), num);
        }
    }

    private int foundOrInserted(String word){
        int index = 0;
        for(IndexEntry entry : this){
            int comparison = entry.getWord().compareToIgnoreCase(word);
            if(comparison == 0){
                return index;
            }
            else if(comparison > 0){
                break;
            }
            index++;
        }
        add(index, new IndexEntry(word.replaceAll("[^a-zA-Z0-9]", "")));
        return index;
    }
    

    public static void main(String[] args){
        DocumentIndex doc = new DocumentIndex();
        doc.addAllWords("Good morning students", 1);
        doc.addAllWords("_Zoy, it's a fine morning", 2);
        System.out.println(doc);
    }
}
