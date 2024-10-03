package globolingo;

public class MultipleChoice implements Question  {
        // Likely will need ot be updated to arraylist in class and UML
    private Phrase options;
    private int answer;

    public MultipleChoice(Phrase options, int answer)  {

    }

        // Getters not present in UML
    public Phrase getOptions()  { return this.options; }

        // interface is String, class is int. Maybe make returntype generic for interface?
    @Override
    public int getAnswer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isCorrect() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void getUserInput() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

        // Setters nnot present in UML
    public void setOptions(Phrase options)  {

    }

    public void setAnswer(int answer)  {
        
    }
}