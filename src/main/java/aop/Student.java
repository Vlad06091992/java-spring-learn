package aop;

public class Student {
    public Student(String nameSurname, int course, double avgScore) {
        this.nameSurname = nameSurname;
        this.course = course;
        this.avgScore = avgScore;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    private String nameSurname;
    private int course;
    private double avgScore;

    @Override
    public String toString() {
        return "Student{" +
                "nameSurname='" + nameSurname + '\'' +
                ", course=" + course +
                ", avgScore=" + avgScore +
                '}';
    }
}
