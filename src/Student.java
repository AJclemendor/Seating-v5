import java.util.ArrayList;

public class Student {

    private ArrayList<String> enemies = new ArrayList<String>();
    private String friends;
    private String StudentName;
    private String glasses;
    private boolean close;
    private double happyLevel;

    public Student(String friends, String StudentName, String glasses) {
        this.friends = friends;
        this.StudentName = StudentName;
        this.glasses = glasses;
        happyLevel = 0.0;
        if (this.glasses.contains("no")) {
            close = false;
        } else {
            close = true;
        }
    }
    public Student() {
        happyLevel = 0.0;
    }


    public void setStudentName(String name) {
        StudentName = name;
    }

    public String getStudentName() {
        return StudentName + " : ";
    }
    public double getHappyLevel() {
        return happyLevel;
    }
    public void setHappyLevel(double level) {
        happyLevel = level;
    }
    public ArrayList<String> getEnemies() {
        return enemies;
    }
    public String getFriends() {
        return friends;
    }

}
