package services.login;

import browseractions.BrowserActions;

public class CreateCoursePageServices {
    private final BrowserActions browserActions = new BrowserActions();
    private final String COURSE_NAME_FIELD;
    private final String COURSE_GRADE_DROPDOWN;
    private final String COURSE_SUBJECT_DROPDOWN;
    private final String COURSE_TEACHER_DROPDOWN;
    private final String COURSE_TEACHER_SELECT_FIELD;
    private final String COURSE_CREATE_BUTTON_FIELD;
    private final String COURSE_NAME;
    private final String COURSE_GRADE;
    private final String COURSE_SUBJECT;

    public CreateCoursePageServices(){
        COURSE_NAME_FIELD = System.getProperty("course.name.field");
        COURSE_GRADE_DROPDOWN = System.getProperty("course.grade.dropdown");
        COURSE_SUBJECT_DROPDOWN = System.getProperty("course.subject.dropdown");
        COURSE_TEACHER_DROPDOWN = System.getProperty("course.teacher.dropdown");
        COURSE_CREATE_BUTTON_FIELD = System.getProperty("course.create.button");
        COURSE_TEACHER_SELECT_FIELD = System.getProperty("course.select.teacher");

        COURSE_NAME = System.getProperty("course.name");
        COURSE_GRADE = System.getProperty("course.grade");
        COURSE_SUBJECT = System.getProperty("course.subject");
    }

    public void addCourseName(){
        browserActions.fillData(COURSE_NAME_FIELD, BrowserActions.TypeOfElement.ID, COURSE_NAME);
    }
    public void addCourseSubject(){
        browserActions.selectOption(COURSE_SUBJECT_DROPDOWN, BrowserActions.TypeOfElement.ID, COURSE_SUBJECT);
    }
    public void addCourseGrade(){
        browserActions.selectOption(COURSE_GRADE_DROPDOWN, BrowserActions.TypeOfElement.ID, COURSE_GRADE);
    }
    public void addCourseTeacher(){
        browserActions.click(COURSE_TEACHER_DROPDOWN, BrowserActions.TypeOfElement.ID);
        browserActions.click(COURSE_TEACHER_SELECT_FIELD, BrowserActions.TypeOfElement.ID);
    }
    public void createCourse(){
        browserActions.click(COURSE_CREATE_BUTTON_FIELD, BrowserActions.TypeOfElement.ID);
    }
}
