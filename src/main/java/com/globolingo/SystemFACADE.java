package com.globolingo;
import java.util.ArrayList;

public class SystemFACADE  {
    private User user;
    private UserList userList;
    private ArrayList<Course> courseList;
    private User currentUser;
    private Course currentCourse;
    private Lesson currentLesson;
    private Question currentQuestion;

    private SystemFACADE() {
        this.userList = DataLoader.getUser();
        this.courseList = new ArrayList<>();
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
        for (Course course : currentUser.getCourses()) {
            if (course.getName().equals(courseTitle)) {
                this.currentCourse = course;
                break;
            }
        }
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentLesson(String lessonName) {
        for (Lesson lesson : currentCourse.getLessons()) {
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

    public void saveProgress() {
        // Implement new progress saving mechanism
    }

    public void createLesson(String subject, int difficulty) {
        currentCourse.createLesson(subject, difficulty);
    }

    public void completeLesson() {
        currentCourse.completeLesson(currentLesson);
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

    public void saveCourseList() {
        DataWriter.saveCourseList(courseList);
    }

    public User addUser(String username, String firstName, String lastName, String password) {
        return userList.addUser(username, firstName, lastName, password);
    }

    public void createCourse(String title, String subject, Language language) {
        Course newCourse = new Course(language, currentUser);
        currentUser.addCourse(newCourse);
    }

    public Avatar getUserAvatar() {
        return userList.getAvatar(currentUser.getUsername());
    }

    public Word translateWord(String englishWord, Language targetLanguage) {
        return new Word(targetLanguage, englishWord, "translation", "definition", "type", "prompt");
    }

    public void updateUserLevel() {
        int completedLessons = currentCourse.getCompletedLessons();
        int newLevel = completedLessons / 10 + 1;
        currentUser.setLevel(newLevel);
    }

    public Course getCourse() {
        return this.currentCourse;
    }

    public void addCompletedLesson() {
        currentCourse.incrementCompletedLessons();
        updateUserLevel();
    }
}