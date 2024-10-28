package com.globolingo;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Lesson  {

    private String name;
    private boolean isComplete;
    private ArrayList<Question> questions;
    private int userScore;
    private int maxScore;
    private int difficulty;

    private Scanner k = new Scanner(System.in);
        
    public Lesson(int lessonNumber)  {
        this.userScore = 0;
        this.maxScore = 10;
        this.isComplete = false;
        this.generateQuestions(lessonNumber);
    }

    // public Lesson(String name, ArrayList<Question> questions, int userScore, int maxScore)  {
    //     this.name = name;
    //     this.questions = questions;
    //     this.userScore = userScore;
    //     this.maxScore = maxScore;
    // }

    public String getName()  { return this.name; }

    public boolean getIsComplete()  { return this.isComplete; }

    public ArrayList<Question> getQuestions() { return this.questions; }

    public int getUserScore()  { return this.userScore; }

    public int getMaxScore()  { return this.maxScore; }

    public void generateQuestions(int lessonNumber)  {
        ArrayList<Question> tq = new ArrayList<>();
        Random rng = new Random();
        ArrayList<Word> subjectWords = new ArrayList<>();
        ArrayList<Phrase> subjectPhrases = new ArrayList<>();
        switch(lessonNumber)  {
            case 1 -> {
                subjectWords = DataLoader.loadWords("basics");
                subjectPhrases = DataLoader.loadPhrases("basics");
            }
            case 2 -> {
                subjectWords = DataLoader.loadWords("greetings");
                subjectPhrases = DataLoader.loadPhrases("greetings");
            }
            case 3 -> {
                subjectWords = DataLoader.loadWords("travel");
                subjectPhrases = DataLoader.loadPhrases("travel");
            }
            case 4 -> {
                subjectWords = DataLoader.loadWords("food");
                subjectPhrases = DataLoader.loadPhrases("food");
            }
            case 5 -> {
                subjectWords = DataLoader.loadWords("familyAndRelationships");
                subjectPhrases = DataLoader.loadPhrases("familyAndRelationships");
            }
            case 6 -> {
                subjectWords = DataLoader.loadWords("householdItems");
                subjectPhrases = DataLoader.loadPhrases("householdItems");
            }
            case 7 -> {
                subjectWords = DataLoader.loadWords("occupationsAndProfessions");
                subjectPhrases = DataLoader.loadPhrases("occupationsAndProfessions");
            }
            case 8 -> {
                subjectWords = DataLoader.loadWords("educationAndSchool");
                subjectPhrases = DataLoader.loadPhrases("educationAndSchool");
            }
            case 9 -> {
                subjectWords = DataLoader.loadWords("shoppingAndConsumerGoods");
                subjectPhrases = DataLoader.loadPhrases("shoppingAndConsumerGoods");
            }
            case 10 -> {
                subjectWords = DataLoader.loadWords("sportsAndHobbies");  
                subjectPhrases = DataLoader.loadPhrases("sportsAndHobbies");
            }
            default -> {
                subjectWords = DataLoader.loadWords("basics");
                subjectPhrases = DataLoader.loadPhrases("basics");
            }
        }

        for(int i = 0; i < 9; i++)  {
            Question tempQ = null;
  
            switch(i)  {
                case 0,1 -> { // Mulitple choice for words
                    ArrayList<String> options = new ArrayList<>();
                    ArrayList<String> output = new ArrayList<>();
                    ArrayList<Integer> selectedNums = new ArrayList<>();
                    selectedNums.add(rng.nextInt(subjectWords.size()));
                    Word answer = subjectWords.get(selectedNums.get(0));
                    options.add(answer.getTranslation());

                    for(int j = 1; j < 4; j++) {
                        int tracker = selectedNums.get(0);
                        while(selectedNums.contains(tracker))
                            tracker = rng.nextInt(subjectWords.size());
                        options.add(subjectWords.get(tracker).getTranslation());
                        selectedNums.add(tracker);
                    }

                    for(int j = 0; j < 4; j++)  {
                        output.add(options.get(rng.nextInt(options.size())));
                    }
                    
                    tempQ = new MultipleChoice(output, answer);
                }

                case 2,3 -> { // Multiple choices for Phrases
                    ArrayList<String> optionsPhrase = new ArrayList<>();
                    ArrayList<String> outputPhrase = new ArrayList<>();
                    ArrayList<Integer> selectedNumsPhrase = new ArrayList<>();
                    selectedNumsPhrase.add(rng.nextInt(subjectPhrases.size()));
                    Phrase answerPhrase = subjectPhrases.get(selectedNumsPhrase.get(0));
                    optionsPhrase.add(answerPhrase.getTranslationString());

                    for(int j = 1; j < 4; j++) {
                        int tracker = selectedNumsPhrase.get(0);
                        while(selectedNumsPhrase.contains(tracker))
                            tracker = rng.nextInt(subjectPhrases.size());
                        optionsPhrase.add(subjectPhrases.get(tracker).getTranslationString());
                        selectedNumsPhrase.add(tracker);
                    }

                    for(int j = 0; j < 4; j++)  {
                        outputPhrase.add(optionsPhrase.get(rng.nextInt(optionsPhrase.size())));
                    }
                    
                    tempQ = new MultipleChoice(outputPhrase, answerPhrase);
                }

                case 4 -> tempQ = new SentenceBuild(subjectPhrases.get(rng.nextInt(subjectPhrases.size())));

                case 5 -> tempQ = new NarratedQ(subjectWords.get(rng.nextInt(subjectWords.size())));
                
                case 6 -> tempQ = new NarratedQ(subjectPhrases.get(rng.nextInt(subjectPhrases.size())));
                
                case 7,8 -> tempQ = new Flashcard(subjectWords.get(rng.nextInt(subjectWords.size())));

                case 9 -> tempQ = new Flashcard(subjectPhrases.get(rng.nextInt(subjectPhrases.size())));
                default -> System.out.println("Something went wrong in generating questions.");
            }
            tq.add(tempQ);
        }
        this.setQuestions(tq);
    }

        // No setters present in UML
    public void setName(String name)  {
        this.name = name;
    }

    public void setCompletion(boolean completion)  {
        this.isComplete = completion;
    }

    public void setQuestions(ArrayList<Question> questions)  {
        this.questions = questions;
    }

    public void setUserScore(int userScore)  {
        this.userScore = userScore;
    }

    public void setMaxScore(int maxScore)  {
        this.maxScore = maxScore;
    }
    public void addUserScore()  {
        this.userScore++;
    }

    public int getDifficulty() {
        return this.difficulty;
    }
    
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void doQuestions() {
        System.out.println("BEGINNING LESSON");
        for(int i=0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println(q);
            q.getUserInput(k.nextLine());
            if(q.isCorrect()) {
                System.out.println("CORRECT");
                userScore++;
            }
            else {
                System.out.println("WRONG");
            }
        }
        System.out.println("SCORE: " + userScore + " out of" + maxScore);
    }
}
