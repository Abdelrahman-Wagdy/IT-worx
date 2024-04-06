package services.login;

import browseractions.BrowserActions;

public class CoursesPageServices {
    private final BrowserActions browserActions = new BrowserActions();
    private final String COURSES_PAGE_FIELD;
    private final String CREATE_COURSE_BUTTON;
    private final String FILTER_COURSE_FIELD;
    private final String FILTER_COURSE_BUTTON;
    private final String COURSE_NAME;

    public CoursesPageServices(){
        COURSES_PAGE_FIELD = System.getProperty("menu.courses");
        CREATE_COURSE_BUTTON = System.getProperty("courses.add.course");
        FILTER_COURSE_FIELD = System.getProperty("courses.search.list.field");
        FILTER_COURSE_BUTTON = System.getProperty("courses.search.list.button");
        COURSE_NAME = System.getProperty("course.name");
    }

    public void navigateToCoursesPage(){
        browserActions.click(COURSES_PAGE_FIELD, BrowserActions.TypeOfElement.ID);
    }
    public void createNewCourse(){
        browserActions.click(CREATE_COURSE_BUTTON, BrowserActions.TypeOfElement.ID);
    }
    public void filterCourse(){
        browserActions.click(FILTER_COURSE_FIELD, BrowserActions.TypeOfElement.ID);
        browserActions.fillData(FILTER_COURSE_FIELD, BrowserActions.TypeOfElement.ID, COURSE_NAME);
        browserActions.click(FILTER_COURSE_BUTTON, BrowserActions.TypeOfElement.ID);
    }
    public String getCourseName(){
        return browserActions.getElement(COURSE_NAME, BrowserActions.TypeOfElement.CSS_SELECTOR).getText();
    }
    public String getUserCourseNameInput(){
        return COURSE_NAME;
    }
}
