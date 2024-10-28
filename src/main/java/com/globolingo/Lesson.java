package com.globolingo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The Lesson class represents a learning session that contains a series of
 * questions. It tracks the user's score and whether the lesson is complete.
 */
public class Lesson {

    private String name;
    private boolean isComplete;
    private ArrayList<Question> questions;
    private int userScore;
    private int maxScore;
    private int difficulty;
    private Scanner k = new Scanner(System.in);

    /**
     * Constructs a new Lesson with the specified lesson number, initializing the
     * score and generating questions.
     * 
     * @param lessonNumber the number of the lesson to initialize
     */
    public Lesson(int lessonNumber) {
        this.userScore = 0;
        this.maxScore = 10;
        this.isComplete = false;
        this.generateQuestions(lessonNumber);
    }

    /**
     * Retrieves the name of the lesson.
     * 
     * @return the name of the lesson
     */
    public String getName() {
        return this.name;
    }

    /**
     * Checks if the lesson is complete.
     * 
     * @return true if the lesson is complete, false otherwise
     */
    public boolean getIsComplete() {
        return this.isComplete;
    }

    /**
     * Retrieves the list of questions in the lesson.
     * 
     * @return an ArrayList containing the questions
     */
    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    /**
     * Retrieves the user's score for the lesson.
     * 
     * @return the user's score
     */
    public int getUserScore() {
        return this.userScore;
    }

    /**
     * Retrieves the maximum score for the lesson.
     * 
     * @return the maximum score
     */
    public int getMaxScore() {
        return this.maxScore;
    }

    /**
     * Generates a set of questions based on the lesson number.
     * 
     * @param lessonNumber the number of the lesson for which to generate questions
     */
    public void generateQuestions(int lessonNumber) {
        ArrayList<Question> tq = new ArrayList<>();
        Random rng = new Random();
        ArrayList<Word> subjectWords = new ArrayList<>();
        ArrayList<Phrase> subjectPhrases = new ArrayList<>();

        switch (lessonNumber) {
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

        for (int i = 0; i < 9; i++) {
            Question tempQ = null;

            switch (i) {
                case 0, 1 -> { // Multiple choice for words
                    ArrayList<String> options = new ArrayList<>();
                    ArrayList<String> output = new ArrayList<>();
                    ArrayList<Integer> selectedNums = new ArrayList<>();
                    selectedNums.add(rng.nextInt(subjectWords.size()));
                    Word answer = subjectWords.get(selectedNums.get(0));
                    options.add(answer.getTranslation());

                    for (int j = 1; j < 4; j++) {
                        int tracker = selectedNums.get(0);
                        while (selectedNums.contains(tracker))
                            tracker = rng.nextInt(subjectWords.size());
                        options.add(subjectWords.get(tracker).getTranslation());
                        selectedNums.add(tracker);
                    }

                    for (int j = 0; j < 4; j++) {
                        output.add(options.get(rng.nextInt(options.size())));
                    }

                    tempQ = new MultipleChoice(output, answer);
                }

                case 2, 3 -> { // Multiple choices for phrases
                    ArrayList<String> optionsPhrase = new ArrayList<>();
                    ArrayList<String> outputPhrase = new ArrayList<>();
                    ArrayList<Integer> selectedNumsPhrase = new ArrayList<>();
                    selectedNumsPhrase.add(rng.nextInt(subjectPhrases.size()));
                    Phrase answerPhrase = subjectPhrases.get(selectedNumsPhrase.get(0));
                    optionsPhrase.add(answerPhrase.getTranslationString());

                    for (int j = 1; j < 4; j++) {
                        int tracker = selectedNumsPhrase.get(0);
                        while (selectedNumsPhrase.contains(tracker))
                            tracker = rng.nextInt(subjectPhrases.size());
                        optionsPhrase.add(subjectPhrases.get(tracker).getTranslationString());
                        selectedNumsPhrase.add(tracker);
                    }

                    for (int j = 0; j < 4; j++) {
                        outputPhrase.add(optionsPhrase.get(rng.nextInt(optionsPhrase.size())));
                    }

                    tempQ = new MultipleChoice(outputPhrase, answerPhrase);
                }

                case 4 -> tempQ = new SentenceBuild(subjectPhrases.get(rng.nextInt(subjectPhrases.size())));

                case 5 -> {
                    NarratedQ q = new NarratedQ(subjectWords.get(rng.nextInt(subjectWords.size())));
                    tempQ = q;
                }

                case 6 -> {
                    NarratedQ q = new NarratedQ(subjectPhrases.get(rng.nextInt(subjectPhrases.size())));
                    tempQ = q;
                }

                case 7, 8 -> tempQ = new Flashcard(subjectWords.get(rng.nextInt(subjectWords.size())));

                case 9 -> tempQ = new Flashcard(subjectPhrases.get(rng.nextInt(subjectPhrases.size())));
                default -> System.out.println("Something went wrong in generating questions.");
            }
            tq.add(tempQ);
        }
        this.setQuestions(tq);
    }

    /**
     * Sets the name of the lesson.
     * 
     * @param name the name to set for the lesson
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the completion status of the lesson.
     * 
     * @param completion the completion status to set
     */
    public void setCompletion(boolean completion) {
        this.isComplete = completion;
    }

    /**
     * Sets the list of questions for the lesson.
     * 
     * @param questions the ArrayList of questions to set
     */
    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    /**
     * Sets the user's score for the lesson.
     * 
     * @param userScore the score to set for the user
     */
    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    /**
     * Sets the maximum score for the lesson.
     * 
     * @param maxScore the maximum score to set
     */
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    /**
     * Increments the user's score by one.
     */
    public void addUserScore() {
        this.userScore++;
    }

    /**
     * Retrieves the difficulty level of the lesson.
     * 
     * @return the difficulty level
     */
    public int getDifficulty() {
        return this.difficulty;
    }

    /**
     * Sets the difficulty level for the lesson.
     * 
     * @param difficulty the difficulty level to set
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Initiates the question-answer session for the lesson.
     */
    public void doQuestions() {
        System.out.println("BEGINNING LESSON");
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println(q);
            if (q instanceof NarratedQ) {
                ((NarratedQ) q).playSound();
            }
            System.out.println("Enter Answer");
            q.getUserInput(k.nextLine());
            if (q.isCorrect()) {
                System.out.println("CORRECT");
                userScore++;
            } else {
                System.out.println("WRONG");
            }
        }
        System.out.println("SCORE: " + userScore + " out of " + maxScore);
    }
}
