import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id, name, major;
    private int yearEntry;
    private List<Grade> grades = new ArrayList<>();

    public Student(String id, String name, String major, int yearEntry) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.yearEntry = yearEntry;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public double calculateGPA() {
        double totalPoint = 0;
        int totalCourse = grades.size();

        for (Grade g : grades) totalPoint += g.getPoint();

        return totalCourse == 0 ? 0 : totalPoint / totalCourse;
    }

    public String getStatusByGPA() {
        double gpa = calculateGPA();

        if (gpa >= 3.85) return "Cumlaude";
        if (gpa >= 3.65) return "Sangat Memuaskan";
        if (gpa >= 2.85) return "Memuaskan";
        return "Cukup";
    }

    public int durationStudy(int currentYear) {
        return currentYear - yearEntry;
    }

    public List<Grade> getGrades() { return grades; }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getYearEntry() { return yearEntry; }
}
