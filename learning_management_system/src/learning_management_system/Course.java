package learning_management_system;

public class Course {
    private String courseId;
    private String courseName;
    private String teacherId;

    public Course(String courseId, String courseName, String teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String toCSV() {
        return courseId + "," + courseName + "," + teacherId;
    }
}
