package com.globolingo;

import java.util.ArrayList;

public class Course {
    private ArrayList<Lesson> lessons;
    private Lesson currentLesson;
    private Language language;
    private User user;
    private int completedLessons;
    private int MAX_LESSONS = 10;

    /**
     * Constructor for course
     * 
     * @param language
     * @param user
     *                 =======
     * 
     *                 /**
     *                 Constructs a new Course with the specified language and user.
     *                 Initializes an empty list of lessons.
     * 
     * @param language the Language object representing the language of the course
     * @param user     the User object representing the user enrolled in the course
     *                 >>>>>>> 3a85250 (javadoc and formatting)
     */
    public Course(Language language, User user) {
        this.language = language;
        this.lessons = new ArrayList<>();
        this.language = language;
        this.user = user;
        this.completedLessons = 0;
    }

    /**
     * <<<<<<< HEAD
     * Course Constructor
     * 
     * @param language
     * @param user
     * @param currentLessonNum
     *                         Constructs a new Course with the specified language,
     *                         user, and
     *                         sets the current lesson based on the provided lesson
     *                         number.
     * 
     * @param language         the Language object representing the language of the
     *                         course
     * @param user             the User object representing the user enrolled in the
     *                         course
     * @param currentLessonNum the index of the current lesson to be set
     *                         >>>>>>> 3a85250 (javadoc and formatting)
     */
    public Course(Language language, User user, int currentLessonNum) {
        this.language = language;
        this.lessons = new ArrayList<>();
        generateLessons();
        this.currentLesson = lessons.get(currentLessonNum);
        this.language = language;
        this.user = user;
    }

    /**
     * <<<<<<< HEAD
     * Loads the lessons
     * =======
     * Retrieves the current lesson in the course.
     * 
     * @return the Lesson object representing the current lesson
     */
    public Lesson getCurrentLesson() {
        return currentLesson;
    }

    /**
     * Sets the current lesson to the specified lesson.
     * 
     * @param lesson the Lesson object to set as the current lesson
     */
    public void setCurrentLesson(Lesson lesson) {
        this.currentLesson = lesson;
    }

    /**
     * Generates and adds lessons to the course, up to the maximum limit.
     */
    public void generateLessons() {
        for (int i = 1; i <= MAX_LESSONS; i++) {
            this.lessons.add(new Lesson(i));
            System.out.println("Loaded Lesson " + i);
        }
    }

    /**
     * Runs the lesson sequence
     * Initiates the current lesson's questions for the user to complete.
     */
    public void doLesson() {
        this.currentLesson.doQuestions();
    }

    /**
     * Calculates the total score of all completed lessons.
     * 
     * @return the total score from all lessons
     */
    public int viewResults() {
        int totalScore = 0;
        for (Lesson lesson : lessons) {
            totalScore += lesson.getUserScore();
        }
        return totalScore;
    }

    // Getters

    /**
     * Retrieves the language of the course.
     * 
     * @return the Language object representing the course language
     */
    public Language getLanguage() {
        return this.language;
    }

    /**
     * Retrieves the user enrolled in the course.
     * 
     * @return the User object representing the enrolled user
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Sets the language of the course.
     * 
     * @param language the Language object to set as the course language
     */
    public void setLanguage(Language language) {
        this.language = language;
    }

    /**
     * Sets the user enrolled in the course.
     * 
     * @param user the User object to set as the enrolled user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Retrieves the number of lessons completed by the user.
     * 
     * @return the count of completed lessons
     */
    public int getCompletedLessons() {
        return completedLessons;
    }

    /**
     * Increments the count of completed lessons by one.
     */
    public void incrementCompletedLessons() {
        this.completedLessons++;
    }

    /**
     * Retrieves the list of lessons in the course.
     * 
     * @return an ArrayList containing all Lesson objects
     */
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }
}
