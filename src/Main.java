import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("STUDENT GRADE MANAGEMENT SYSTEM");
        System.out.println("============================================\n");

        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Grade> gradeList = new ArrayList<>();

        // === DATA STUDENT ===
        System.out.println("=== REGISTRASI MAHASISWA ===");
        students.add(new Student("STD001", "John Doe", "Teknik Informatika", 2021));
        students.add(new Student("STD002", "Jane Smith", "Sistem Informasi", 2022));
        students.add(new Student("STD003", "Bob Wilson", "Teknik Informatika", 2020));
        students.forEach(s -> System.out.println("✓ Mahasiswa berhasil ditambahkan: " + s.getId() + " - " + s.getName()));

        // === DATA MATA KULIAH ===
        System.out.println("\n=== REGISTRASI MATA KULIAH ===");
        courses.add(new Course("CS101", "Pemrograman Dasar", 3, "Pak Budi", false));
        courses.add(new Course("CS102", "Struktur Data", 4, "Bu Ani", true));
        courses.add(new Course("MTK201", "Kalkulus II", 3, "Pak Joko", false));
        courses.add(new Course("ENG101", "English for IT", 2, "Miss Linda", false));
        courses.forEach(c -> System.out.println("✓ Mata kuliah berhasil ditambahkan: " + c));

        // === INPUT NILAI ===
        System.out.println("\n=== INPUT NILAI ===");
        gradeList.add(addScore(students.get(0), courses.get(0), 85));
        gradeList.add(addScore(students.get(0), courses.get(1), 78));
        gradeList.add(addScore(students.get(1), courses.get(0), 92));
        gradeList.add(addScore(students.get(1), courses.get(3), 88));
        gradeList.add(addScore(students.get(2), courses.get(2), 65));
        gradeList.add(addScore(students.get(2), courses.get(0), 70));

        // === DATA STUDENT ===
        System.out.println("\n============================================");
        System.out.println("DAFTAR MAHASISWA");
        System.out.println("============================================");
        for (Student s : students) {
            System.out.println("[" + s.getId() + "] " + s.getName());
            System.out.println("Jurusan       : " + s.getMajor());
            System.out.println("Tahun Masuk   : " + s.getYearEntry());
            System.out.printf ("GPA           : %.2f\n", s.calculateGPA());
            System.out.println("Status        : " + s.getStatusByGPA());
            System.out.println("Lama Kuliah   : " + s.durationStudy(2025) + " tahun");
            System.out.println("--------------------------------------------");
        }
        System.out.println("Total Mahasiswa: " + students.size());

        // === COURSE LIST ===
        System.out.println("\n============================================");
        System.out.println("DAFTAR MATA KULIAH");
        System.out.println("============================================");
        courses.forEach(System.out::println);
        System.out.println("============================================");
        System.out.println("Total Mata Kuliah: " + courses.size());

        // === DAFTAR NILAI ===
        System.out.println("\n============================================");
        System.out.println("DAFTAR NILAI MAHASISWA");
        System.out.println("============================================");
        for (Grade g : gradeList) {
            System.out.println("Mahasiswa : " + g.getStudent().getName() + " (" + g.getStudent().getId() + ")");
            System.out.println("Mata Kuliah : " + g.getCourse().getName() + " (" + g.getCourse().getCode() + ")");
            System.out.println("Nilai : " + g.getScore() + " | Grade: " + g.getGradeText() + " | Point: " + g.getPoint() +
                    " | Status: " + (g.getScore() >= 60 ? "LULUS ✓" : "TIDAK LULUS ✗"));
            System.out.println("--------------------------------------------");
        }

        // === STATISTIK ===
        System.out.println("============================================");
        System.out.println("STATISTIK SISTEM");
        System.out.println("============================================");
        Student highestGPA = students.stream().max(Comparator.comparing(Student::calculateGPA)).get();
        System.out.println("Mahasiswa dengan GPA Tertinggi: " + highestGPA.getName() +
                " (" + String.format("%.2f", highestGPA.calculateGPA()) + ")");
        System.out.println("Total Mahasiswa Terdaftar: " + students.size());
        System.out.println("Total Mata Kuliah Tersedia: " + courses.size());
        System.out.println("============================================");
    }

    private static Grade addScore(Student s, Course c, int score) {
        Grade g = new Grade(s, c, score);
        s.addGrade(g);
        System.out.println("✓ Nilai berhasil diinput: " + s.getName() + " - " + c.getName() + ": " + score + " (" + g.getGradeText() + ")");
        return g;
    }
}
