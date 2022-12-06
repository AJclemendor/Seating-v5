import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
/*

the array allnames contains all student names in order

friendarr contains all lists of friends with more than one person
allfriends contains all lists of friends
glasses is an arr containing if a student needs glasses

*/
public class Main {
    public static String SFN;
    public static String SLN;

    public static void main(String[] args) throws IOException {
        // un touched students as strings
        ArrayList<String> ogstudents = new ArrayList<String>();
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Student> friends = new ArrayList<Student>();

        //System.out.println(students);
        //arraylist create list of students and student friends and enemeys

        //CSV = Comma-Separated Values
        //   text file that uses a comma to separate values

        String file = "//Users//ajclemendor//Desktop//Keys//realtest.csv";
        String file2 = "//Users//ajclemendor//Desktop//Keys//realtest.csv";

        Path path = Paths.get("//Users//ajclemendor//Desktop//Keys//realtest.csv");
        Path path2 = Paths.get("//Users//ajclemendor//Desktop//Keys//realtest.csv");
        // int records = file.length();
        //int columns = 4;
        ArrayList<String> bad = new ArrayList<>();

        //System.out.println(records);
        //System.out.println(columns);

        List<String> arr = Files.readAllLines(path);
        List<String> arrtemp = Files.readAllLines(path);

        //System.out.println(arr.get(2).substring(arr.get(2).length() - 1));
        //String studentnums = arr.get(2).substring(arr.get(2).length() - 1);
        String stunum2 = arr.get(2).substring(arr.get(2).length() - 2);

        String firstnamestemp = arr.get(3).toString();

        //studentnums += stunum2;
        System.out.println(stunum2);
        int studentcounter = Integer.parseInt(stunum2);
        String[] arr2;
        int records = studentcounter;
        int columns = 4;
        //System.out.println(arr);
        String[] allnames = new String[studentcounter];
        String[] allfriends = new String[studentcounter];
        String[] glasses = new String[studentcounter];
        String temp10 = "";
        int indexg = 0;
        int glasctr = 0;
        //System.out.println(arr.size());
        for (int i=2; i<studentcounter+2; i++) {


            //System.out.println(arr.get(i).toString());
            temp10 = arr.get(i).toString();
            //System.out.println(temp10);
            //System.out.println(temp10);



            String blank = "";
            int counter = 0;
            int starts = 0;
            int ends = 0;
            //System.out.println(temp10.substring(20));
            if (temp10.substring(20).contains("Yes")) {
                glasses[glasctr] = "Yes";
                glasctr++;
            } else {
                glasses[glasctr] = "No";
                glasctr++;
            }

            // counter for comma if over x then look for " if quotes record name
            for (int a=0; a<arr.get(i).length(); a++) {
                if (temp10.charAt(a) == ',') {
                    counter++;
                }
                if (counter > 4) {
                    //System.out.println(temp10);
                    if (temp10.contains("Yes")) {
                        //System.out.println(temp10);
                    }
                    if (temp10.charAt(a) == '\"') {
                        if (starts == 0) {
                            starts = a;
                        } else {
                            ends = a;
                        }
                        if (starts >0 && ends >0) {
                            //System.out.println(starts);
                            //System.out.println(ends);


                            if (!(temp10.substring(starts, ends).equals("\",No,"))) {
                                //System.out.println(temp10);
                                System.out.println(indexg);
                                if (indexg != studentcounter) {

                                    //System.out.println(temp10.substring(starts, ends));
                                    allnames[indexg] = temp10.substring(starts, ends);
                                    //System.out.println(allnames[indexg]);
                                    indexg++;
                                    counter=0;
                                    //System.out.println(allnames[indexg]);
                                    //System.out.println(arr.get(i));

                                    //System.out.println(temp10.substring(starts, ends));
                                }
                            }
                            // System.out.println(temp10.substring(starts, ends));
                        }
                    }
                }
            }
        }

        for (int i=0; i<allnames.length; i++) {
            //System.out.println(allnames[i]);

            if (allnames[i].contains("No")) {
                allnames[i] = allnames[i].substring(5);
            }
            allnames[i] = allnames[i].substring(1);
            for (int h=0; h<allnames[i].length()-3; h++) {
                if (allnames[i].substring(h,h+3).equals("Yes")) {
                    allnames[i] = allnames[i].substring(0,h-1) + allnames[i].substring(h+4);
                }
                if (allnames[i].indexOf("\"") > 0) {
                    allnames[i] = allnames[i].substring(2);
                }
            }
            System.out.println(allnames[i]);
        }
        String[][] arr3 = new String[records][columns];

        for (int i = 0; i < records; i++) {
            arr2 = arr.get(i).split("\\,");
            for (int j = 0; j < columns; j++) {
                arr3[i][j] = arr2[j];
                //System.out.println(arr.get(i).toString().split("\\,"));
            }
        }

        //test case
        for (int i = 0; i < records; i++) {
            for (int j = 0; j < columns; j++)
                //  System.out.print(arr3[i][j]+"  ");
                System.out.println();
        }

        System.out.println(studentcounter + " is SC");
        int idx = 0;

        for (int i = 2; i < studentcounter + 2; i++) {
            ogstudents.add(arr.get(i));
            idx++;
        }
        String[][] arr4 = new String[studentcounter][4];
        ogstudents.toString();

        ogstudents.toString().split("\\,");
        ArrayList<String> arr6 = new ArrayList<>();
        String[][] arr5 = new String[studentcounter][4];

        for (int r = 0; r < studentcounter; r++) {
            for (int c = 0; c < 4; c++) {
                arr4[r] = ogstudents.get(r).toString().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                //System.out.println(ogstudents.get(r).toString().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"));
                if (c % 4 == 0) {
                    arr6.add(Arrays.toString(ogstudents.get(r).toString().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")));
                }


            }
            //System.out.println(arr4);
            //System.out.println(arr4[0][1]);

            int num = 0;

        }
        String[] studentnames = new String[studentcounter];

        for (int a = 0; a < studentcounter; a++) {
            // check from everyone to the start of their name and cut out middle making the friendlist
            //System.out.println((ogstudents.get(a).toString())); // Friend, Student Name,


        }
        //System.out.println(arr6);
        String[][] arr10 = new String[studentcounter][4];
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<String> singlefriend = new ArrayList<>();
        for (int r = 0; r < studentcounter; r++) {
            for (int c = 0; c < 7; c++) {
                if (c > 2 && c < 4) { // 1 and 2 = no I like everyone
                    //allfriends]
                    arr10[r] = arr6.get(r).toString().split("\\,");

                    if (arr10[r][c].substring(0, 2).equals(" \"")) {
                        index.add(r);
                    }

                    if (!index.contains(r)) {
                        //System.out.println(arr10[r][c]);
                        singlefriend.add(arr10[r][c]);
                    }
                    //System.out.println(arr10[r][c]);
                    //System.out.println(arr10[r][c]);
                    //System.out.println("\"");
                    //students.add()

                }
            }
        }

        //System.out.println(index);

        ArrayList<ArrayList<String>> friendslist = new ArrayList<>();
        ArrayList<String> friendslistadd = new ArrayList<>();
        String[] friendarr = new String[studentcounter];

        //System.out.println(friendslist);
        for (int r = 0; r < studentcounter; r++) {
            int count = 0;

            for (int c = 0; c < 9; c++) {

                ArrayList<String[]> enemy = new ArrayList<>();


                if (index.contains(r)) { //index.contains(r)
                    int ct = 0;
                    arr10[r] = arr6.get(r).toString().split("\\,");
                    String temp = "";
                    for (int i=0; i<arr10[r][c].length(); i++) {

                        if (arr10[r][c].charAt(i) == '\"') {
                            count++;
                        }

                        temp += (arr10[r][c].charAt(i));
                        //System.out.println(arr10[r][c].substring(0,3));
                    }
                    //System.out.print(temp);
                    if (count > 2) {
                        //System.out.println(temp);
                        friendarr[r] += temp;
                        //  System.out.println(friendarr[r]);
                    }

                    //System.out.println("");
                    //System.out.println(count);

                    //System.out.println(arr10[r][c]);
                }

                //System.out.print(arr10[r][c]);



            }
        }
        for (int i=0; i< index.size(); i++) {
            friendarr[index.get(i)] = friendarr[index.get(i)].substring(4);
            //System.out.println(friendarr[index.get(i)].substring(friendarr[index.get(i)].length()-3, friendarr[index.get(i)].length()-0));
            if (friendarr[index.get(i)].substring(friendarr[index.get(i)].length()-3, friendarr[index.get(i)].length()-0).contains("No")) {
                friendarr[index.get(i)] = friendarr[index.get(i)].substring(0, friendarr[index.get(i)].length() - 3);
            }
            String temp3 = "";
            for (int j=0; j<friendarr[index.get(i)].length(); j++) {
                temp3 += friendarr[index.get(i)].charAt(j);
                if (temp3.contains(" No")) {
                    friendarr[index.get(i)] = friendarr[index.get(i)].substring(0,j-2);
                }
            }
            //System.out.println(friendarr[index.get(i)]);
        }
        int l =0;
        int k =0;
        for (int i=0; i<studentcounter; i++) {
            if (index.contains(i)) {
                allfriends[i] = friendarr[index.get(l)];
                l++;
            } else {
                allfriends[i] = singlefriend.get(k);
                k++;
            }
        }
        for (int i=0; i<studentcounter; i++) {
            //System.out.print(i+1 +" is  the count");
            //System.out.println(glasses[i]);
            //System.out.println(allfriends[i]);
        }
        ArrayList<String[]> finalFriendList = new ArrayList<>();
        ArrayList<String[]> finalNamesList = new ArrayList<>();
        ArrayList<String[]> finalGlassesList = new ArrayList<>();
        int indexr = 0;

        for (int i=0; i<studentcounter; i++) {

            allfriends[i] = allfriends[i].substring(1);
            if (allfriends[i].contains("\"")) {
                allfriends[i] = allfriends[i].substring(1);
                allfriends[i] = allfriends[i].substring(0,allfriends[i].length()-1);
                //System.out.println(allfriends[i]);
            }
            for (int h=0; h<allfriends[i].length()-2; h++) {
                if (allfriends[i].substring(h, h+3).equals("Yes")) {
                    allfriends[i] = allfriends[i].substring(0,h) + allfriends[i].substring(h+3);

                }

            }
            //System.out.println(allfriends[i]);






            //System.out.println(allfriends[i].toLowerCase() + " : " +  allnames[i].toLowerCase() + " : " + glasses[i].toLowerCase());
            students.add(new Student(allfriends[i].toLowerCase(), allnames[i].toLowerCase(), glasses[i].toLowerCase()));

            //System.out.println(students.get(i).getStudentName());
        }
        int cols = 7;
        int rows = 4;

        seating(students, studentcounter, rows, cols);


    }


    public static void seating(ArrayList<Student> students, int studentcount, int rows, int cols) {

        String[][] classroom;
        classroom = createClassroom(rows, cols); // creates a fresh room with rowsxcols when called will return a new classroom
        classroom = seatStudents(classroom, students, studentcount);
        //displayRoom(classroom); // shows pre sorted state of classroom
        classroom = greedyBFS(classroom, students, studentcount, rows, cols);

    }
    public static String[][] createClassroom(int rows, int cols) {
        String[][] classroom = new String[rows][cols];

        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                classroom[r][c] = "* ";
            }
        }
        return classroom;


    }
    public static void displayRoom(String[][] classroom) {
        for (int i=0; i<classroom.length; i++) {
            System.out.println("");
            for (int j = 0; j<classroom[0].length; j++) {
                System.out.print(classroom[i][j]);
            }
        }
    } // for string name arr
    public static void displayStudentRoom(Student[][] classroom) {
        for (int i=0; i<classroom.length; i++) {
            System.out.println("");
            for (int j = 0; j<classroom[0].length; j++) {
                if (classroom[i][j] != null) {
                    System.out.print(classroom[i][j].getStudentName());

                }
            }
        }
    } // for student arr
    public static String[][] seatStudents(String[][] classroom, ArrayList<Student> students, int SC) {

        int index = 0;
        for (int row = 0; row<classroom.length; row++) {
            for (int col = 0; col<classroom[0].length; col++) {
                classroom[row][col] = students.get(index).getStudentName();
                index++;
                if (index > SC-1) {
                    return classroom;
                }
            }
        }
        return classroom;
    } // seats string arr
    public static Student[][] seatStudentClass(Student[][] classroom, ArrayList<Student> students, int SC) {

        int index = 0;
        for (int row = 0; row<classroom.length; row++) {
            for (int col = 0; col<classroom[0].length; col++) {
                classroom[row][col] = students.get(index);
                index++;
                if (index > SC-1) {
                    return classroom;
                }
            }
        }
        return classroom;
    } // seats student arr
    /*public static String[][] swapStudent(String[][] classroom, int oldrow, int oldcol, int newrow, int newcol) {
        String dummy = "";
        dummy = classroom[oldrow][oldcol];
        classroom[oldrow][oldcol] = classroom[newrow][newcol];
        classroom[newrow][newcol] = dummy;
        return classroom;
    } // swaps kid in string arr
    */

    public static Student[][] swapStudent(Student[][] place, int oldrow, int oldcol, int newrow, int newcol) {
        Student dummy = new Student();
        dummy = place[oldrow][oldcol];
        place[oldrow][oldcol] = place[newrow][newcol];
        place[newrow][newcol] = dummy;
        return place;
    } // swaps kid in student arr

    public static double getHappy(Student[][] classroom, int currow, int curcol) {
        //System.out.println(classroom[curcol][currow].getFriends());
        if (classroom[currow][curcol] == null) {
            return 0.0;
        }
        //System.out.println(classroom[currow][curcol].getStudentName());
        String[] names = classroom[currow][curcol].getFriends().split(" ");
        double happy = 0.0;
        String friendname = "";
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();

        for (int r = 0; r<classroom.length; r++) {
            for (int c = 0; c<classroom[0].length; c++) {
                if (classroom[r][c] != null) {
                    friendname = classroom[r][c].getStudentName().replace(",", "");
                    //System.out.println(friendname);
                    for (int k = 0; k<names.length; k++) {
                        //System.out.println(names[k]);
                        if (friendname.contains(names[k])) {
                            rows.add(r);
                            cols.add(c);
                        }
                    }
                }
            }
        }
        //System.out.println(rows);
        //System.out.println(cols);
        for (int i=0; i<rows.size(); i++) {
            happy += Math.sqrt(Math.pow(currow - rows.get(i), 2) + Math.pow(curcol - cols.get(i), 6)); // trying 6

        }
         /*   if (currow == rows.get(i)) {
                happy -= 5;
            }

        if (classroom[currow][curcol].getGlasses()) {
            happy += 10;
        }
        */



        classroom[currow][curcol].setHappyLevel(happy);
        //System.out.println(happy);
        return happy*-1;
    }

    public static double getTotalHappy(Student[][] classroom) {
        ArrayList<Double> happylist = new ArrayList<>();
        double happytotal = 0.0;
        for (int i=0; i<classroom.length; i++) {
            for (int j=0; j<classroom[0].length; j++) {
                if (classroom[i][j] != null) {

                    happylist.add(getHappy(classroom, i, j));
                }
            }
        }
        //System.out.println(happylist);
        for (int i=0; i<happylist.size(); i++) {
            happytotal += happylist.get(i);
        }
        //System.out.println(happytotal);
        return happytotal;


    }

    public static String[][] greedyBFS(String[][] classroom, ArrayList<Student> students, int stucount, int rows, int cols) {    //greedy Best-first search
        Student[][] greedyboard = new Student[rows][cols];
        greedyboard = seatStudentClass(greedyboard, students, stucount);
        displayStudentRoom(greedyboard);
        // all before is initialization

        //getHappy(greedyboard, 0,0);
        double totalhappy = getTotalHappy(greedyboard);
        System.out.println(totalhappy);

        int index = 0;
        int index2 =0;
        for (int i=0; i<100000; i++) { // placeholder 1

            if (index == rows) {
                index = 0;
                index2++;
            }
            if (index2 == cols) {
                index2 = 0;
            }

            greedyboard = BFSSTEP(greedyboard,getTotalHappy(greedyboard), index, index2);
            index++;
            if (i%10000 == 0 ) {
                System.out.println("10k Run ");
            }

        }
        //greedyboard = BFSSTEP(greedyboard,getTotalHappy(greedyboard));

        //shows board after sorting 1x
        displayStudentRoom(greedyboard);
        System.out.println(getTotalHappy(greedyboard));
        System.out.println("done");

        return classroom;
    }

    public static Student[][] BFSSTEP(Student[][] room, double happy, int i, int j) {
        Student[][] greedyboard = room;
        Student[][] backup = room;
        //System.out.println("THIS IS BACKUPROOM");
        //displayStudentRoom(backup);

        double left = 3988;
        double right = 3988;
        double up = 3988;
        double down = 3988;

        double pre = getTotalHappy(greedyboard);
        //System.out.println(happy + " is starting value");


        //System.out.println("PRE\n");
        //System.out.println(happy);
        ArrayList<Student[][]> stulist = new ArrayList<>();
        stulist.add(greedyboard);

        for (int row = i; row < greedyboard.length; row++) {
            for (int col = j; col < greedyboard[0].length; col++) {
                if (greedyboard[row][col] != null) {

                    if (col + 1 < greedyboard[0].length) {
                        greedyboard = swapStudent(greedyboard, row, col, row, col + 1);
                        right = getTotalHappy(greedyboard);
                        greedyboard = swapStudent(greedyboard, row, col+1, row, col);
                        //displayStudentRoom(greedyboard);
                      //  System.out.println("RIGHT SCORE " + right);
                    }


                    if (col - 1 > -1) {
                        greedyboard = swapStudent(greedyboard, row, col, row, col-1);
                        left = getTotalHappy(greedyboard);
                        greedyboard = room;
                        greedyboard = swapStudent(greedyboard, row, col-1, row, col);

                  //      System.out.println(" LEFT SCORE " + left);
                    }

                    if (row + 1 < greedyboard.length) {
                        greedyboard = swapStudent(greedyboard, row, col, row+1, col);
                        down = getTotalHappy(greedyboard);
                        greedyboard = room;
                        greedyboard = swapStudent(greedyboard, row+1, col, row, col);

                     //   System.out.println( " down SCORE " + down);
                    }

                    if (row-1 > -1) {
                        greedyboard = swapStudent(greedyboard, row, col, row-1, col);
                        up = getTotalHappy(greedyboard);
                        greedyboard = room;
                        greedyboard = swapStudent(greedyboard, row-1, col, row, col);

                     //   System.out.println(" up SCORE " + up);

                    }
                    if (happy > Math.max(Math.max(up,down),Math.max(left,right))) {
                        System.out.println("CANCEL");
                        return backup;
                    }



                    if (down != 3988 && down>happy && down > right && down > left && down > up) {
                         /*System.out.println("test");
                        System.out.println(happy);
                        System.out.println(down); */

                        System.out.println("DOWN SWAP IS GOOD");
                        System.out.print(down);

                        greedyboard = swapStudent(greedyboard, row+1, col, row, col);
                        System.out.println();
                        //displayStudentRoom(greedyboard);
                        return greedyboard;
                    }
                    if (up != 3988 && up>happy && up > down && up > left && up > right) {
                        greedyboard = swapStudent(greedyboard, row, col, row-1, col);
                        System.out.println("UP SWAP IS GOOD");
                        System.out.print(up);

                        return greedyboard;
                    }
                    if (left != 3988 && left > happy && left > right && left > up && left > down) {
                        System.out.println("LEFT SWAP IS GOOD");
                        System.out.print(left);
                        greedyboard = swapStudent(greedyboard, row, col, row, col-1);
                        return greedyboard;
                    }
                    if (right != 3988 && right > happy && right > up && right > down && right > left) {
                        System.out.println("RIGHT SWAP IS GOOD");
                        System.out.print(right);
                        greedyboard = swapStudent(greedyboard, row, col, row, col + 1);
                        return greedyboard;
                    }
                    //System.out.println("BACKUP NOT WORKING");
                    //displayStudentRoom(backup);
                    return backup;


                }
            }
        }
        System.out.println("FINAL RETURN");
        return backup;
    }
}






