import java.util.ArrayList;

public class Matching implements Question  {
    private ArrayList<Word> words;
    private Picture picture;

        // Constructor not in UML
    public Matching(ArrayList<Word> words, Picture picture)  {

    }

        // Getter not present in UML
    public ArrayList<Word> getWords() { return this.words; }

    public Picture getPicture() { return this.picture; }

    @Override
    public boolean isCorrect() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void getUserInput() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getAnswer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

        // Setter not present in UML
    public void setWords(ArrayList<Word> words)  {

    }

    public void setPicture(Picture picture)  {
        
    }
}