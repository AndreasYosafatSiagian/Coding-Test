public class Grade {
    private Student student;
    private Course course;
    private int score;
    private String grade;
    private double point;

    public Grade(Student student, Course course, int score) {
        this.student = student;
        this.course = course;
        this.score = score;
        convertScore(score);
    }

    private void convertScore(int score) {
        if      (score >= 85) { grade = "A";  point = 3.85; }
        else if (score >= 80) { grade = "A-"; point = 3.65; }
        else if (score >= 75) { grade = "B+"; point = 3.3; }
        else if (score >= 70) { grade = "B";  point = 3.0; }
        else if (score >= 65) { grade = "B-"; point = 2.7; }
        else if (score >= 60) { grade = "C";  point = 2.0; }
        else                  { grade = "D";  point = 1.0; }
    }

    public double getPoint() { return point; }
    public String getGradeText() { return grade; }
    public int getScore() { return score; }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
}
