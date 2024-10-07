public interface Question {

    /*isCorrect is public in interface and private in implementation classes
    * which should it be?
    */
    public boolean isCorrect();
    public void getUserInput();
    public String getAnswer();
}