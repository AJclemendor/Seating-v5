import java.util.ArrayList;

public class Student {

    private ArrayList<String> enemies = new ArrayList<String>();
    private String friends;
    private String StudentName;
    private String glasses;
    private boolean close;


    public Student(String friends, String StudentName, String glasses) {
        this.friends = friends;
        this.StudentName = StudentName;
        this.glasses = glasses;

        if (this.glasses.contains("no")) {
            close = false;
        } else {
            close = true;
        }
    }

    public String getStudentName() {
        return StudentName;
    }

    public ArrayList<String> getEnemies() {
        return enemies;
    }
    public String getFriends() {
        return friends;
    }

}
