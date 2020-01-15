package bonsai;

import java.util.ArrayList;

public class WordManager {
    
    private ArrayList<String> words = new ArrayList<>();
    private ArrayList<String> used = new ArrayList<>();
    
    public WordManager() {
        words.add("apple");
        words.add("banana");
        words.add("cantaloupe");
        words.add("durian");
        words.add("eggplant");
        words.add("fig");
        words.add("grapes");
        words.add("honeydew");
        words.add("imbe");
        words.add("jackfruit");
        words.add("kiwi");
        words.add("lime");
        words.add("mangosteen");
        words.add("nectarine");
        words.add("orange");
        words.add("plum");
        words.add("quince");
        words.add("raspberry");
        words.add("strawberry");
        words.add("tangerine");
        words.add("uglifruit");
        words.add("voavanga");
        words.add("watermelon");
        words.add("xigua");
        words.add("yuzu");
        words.add("zucchini");
    }
    
    public String getWord() {
        if (words.size()<=0) {
            recycle();
        }
        int i = (int)(Math.random()*words.size());
        String word = words.get(i);
        words.remove(i);
        used.add(word);
        return word;
    }
    
    public void recycle() {
        for (String i: used) {
            words.add(i);
        }
        used.clear();
    }
    
}
