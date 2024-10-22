package com.globolingo;

import java.util.ArrayList;

public class SystemFACADE {
    private static SystemFACADE instance;
    private UserList userList;
    private ProgressList progressList;
    private User currentUser;
    private Progress currentprogress;
    private Course currentCourse;
    private Section currentSection;
    private Lesson currentLesson;
    private Question currentQuestion;

    private SystemFACADE() {
        this.userList = DataLoader.getUserList();
        this.progressList = DataLoader.getProgressList();
    }

    public static SystemFACADE getInstance() {
        if (instance == null) {
            instance = new SystemFACADE();
        }
        return instance;
    }

    public void setCurrentUser(String username) {
        this.currentUser = userList.getUser(username);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentCourse(String courseTitle) {
        ArrayList<Progress> userProgress = progressList.getUserProgress(currentUser.getUsername());
        for (Progress progress : userProgress) {
            if (progress.getCourse().getTitle().equals(courseTitle)) {
                this.currentCourse = progress.getCourse();
                this.currentprogress = progress;
                break;
            }
        }
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentSection(String sectionTitle) {
        for (Section section : currentCourse.getSections()) {
            if (section.getTitle().equals(sectionTitle)) {
                this.currentSection = section;
                break;
            }
        }
    }

    public Section getCurrentSection() {
        return currentSection;
    }

    public void setCurrentLesson(String lessonName) {
        for (Lesson lesson : currentSection.getLessons()) {
            if (lesson.getName().equals(lessonName)) {
                this.currentLesson = lesson;
                break;
            }
        }
    }

    public Lesson getCurrentLesson() {
        return currentLesson;
    }

    public void setCurrentQuestion(int questionIndex) {
        if (questionIndex >= 0 && questionIndex < currentLesson.getQuestions().size()) {
            this.currentQuestion = currentLesson.getQuestions().get(questionIndex);
        }
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public Progress getCurrentProgress() {
        return progressList.getCourseProgress(currentUser.getUsername(), currentCourse.getTitle());
    }

    public void saveProgress() {
        progressList.saveProgress();
    }

    public void createLesson(String subject, int difficulty) {
        currentCourse.createLesson(subject, difficulty);
    }

    public void completeSection() {
        currentCourse.completeSection(currentSection);
    }

    public void aceSection() {
        currentCourse.aceSection(currentSection);
    }

    public Section nextSection() {
        return currentCourse.nextSection();
    }

    public int viewResults() {
        return currentCourse.viewResults();
    }

    public void generateQuestions() {
        currentLesson.generateQuestions();
    }

    public void saveUserList() {
        DataWriter.saveUserList(userList.getUsers());
    }

    public void saveLanguageList(ArrayList<Course> courseList) {
        DataWriter.saveLanguageList(courseList);
    }

    public User addUser(String username, String firstName, String lastName, String password) {
        return userList.addUser(username, firstName, lastName, password);
    }

    public void createCourse(String title, String subject, Language language) {
        Course newCourse = new Course(title, subject, language, currentUser);
        currentUser.addCourse(newCourse);
    }

    public Avatar getUserAvatar() {
        return userList.getAvatar(currentUser.getUsername());
    }

    public Word translateWord(String englishWord, Language targetLanguage) {
        return new Word(targetLanguage, englishWord, "translation", "definition", "type", "prompt");
    }

    public void checkAndAwardLootCrate() {
        int nextLootCrateAt = currentprogress.getNextLootCrateAt();
        if (currentprogress.getCompletedLessons() >= nextLootCrateAt) {
            currentprogress.setNextLootCrateAt(nextLootCrateAt + 10);
        }
    }

    public void updateUserLevel() {
        int completedLessons = currentprogress.getCompletedLessons();
        int newLevel = completedLessons / 10 + 1;
        currentUser.setLevel(newLevel);
    }

    public Course getCourse() {
        return this.currentCourse;
    }

    public void addCompletedLesson() {
        currentprogress.setCompletedLessons(currentprogress.getCompletedLessons() + 1);
        checkAndAwardLootCrate();
        updateUserLevel();
    }

    public void addCompletedSection() {
        ArrayList<Section> completedSections = currentprogress.getCompletedSections();
        completedSections.add(new Section("title", "description", 1, new ArrayList<Lesson>(), 0, 0)); // Assuming default values for the constructor
        currentprogress.setCompletedSections(completedSections);
    }
}
