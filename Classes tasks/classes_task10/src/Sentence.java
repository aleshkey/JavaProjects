import java.util.ArrayList;

public class Sentence {
    private ArrayList<Word> words = new ArrayList<Word>();

    public void setWord(Word word){
        words.add(word);
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        String rez ="";
        for(int i=0;i<words.size();i++) {
            rez = rez + words.get(i).toString();
        }
        rez= rez +". ";
        return rez;
    }
}
