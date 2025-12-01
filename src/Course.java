public class Course {
    private String code, name, lecturer;
    private int sks;
    private boolean heavyCourse;

    public Course(String code, String name, int sks, String lecturer, boolean heavyCourse) {
        this.code = code;
        this.name = name;
        this.sks = sks;
        this.lecturer = lecturer;
        this.heavyCourse = heavyCourse;
    }

    @Override
    public String toString() {
        return "[" + code + "] " + name + " (" + sks + " SKS) - " + lecturer
                + (heavyCourse ? " **HEAVY COURSE**" : "");
    }

    public String getCode() { return code; }
    public String getName() { return name; }
}
