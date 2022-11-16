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

        System.out.println(arr.get(2).substring(arr.get(2).length() - 1));
        String studentnums = arr.get(2).substring(arr.get(2).length() - 1);
        String stunum2 = arr.get(2).substring(arr.get(2).length() - 2);

        String firstnamestemp = arr.get(3).toString();

        studentnums += stunum2;
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

        for (int i=2; i<studentcounter+2; i++) {

            //System.out.println(arr.get(i).toString());
            temp10 = arr.get(i).toString();
            //System.out.println(temp10);



            String blank = "";
            int counter = 0;
            int starts = 0;
            int ends = 0;
            System.out.println(temp10.substring(20));
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

                                allnames[indexg] = temp10.substring(starts, ends);
                                indexg++;
                                //System.out.println(temp10.substring(starts, ends));

                            }
                           // System.out.println(temp10.substring(starts, ends));
                        }
                    }
                }
            }
        }

        for (int i=0; i<allnames.length; i++) {
            if (allnames[i].contains("No")) {
                allnames[i] = allnames[i].substring(5);
            }
            allnames[i] = allnames[i].substring(1);

            //System.out.println(allnames[i]);
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


        for (int i=0; i<studentcounter; i++) {

            allfriends[i] = allfriends[i].substring(1);
            if (allfriends[i].contains("\"")) {
                allfriends[i] = allfriends[i].substring(1);
                allfriends[i] = allfriends[i].substring(0,allfriends[i].length()-1);
            }
            //System.out.println(allfriends[i].toLowerCase()+ " : " +  allnames[i].toLowerCase() + " : "+ glasses[i].toLowerCase());
            students.add(new Student(allfriends[i].toLowerCase(), allnames[i].toLowerCase(), glasses[i].toLowerCase()));

        }
        int cols = 8;
        int rows = 4;

        seating(students, studentcounter, rows, cols);


    }



    public static void seating(ArrayList<Student> students, int studentcount, int rows, int cols) {

        String[][] classroom;
        classroom = createClassroom(rows, cols); // creates a fresh room with rowsxcols when called will return a new classroom
        displayRoom(classroom); // shows pre sorted state of classroom
        /*
        for each row in the seating chart, starting with row 0, do:
        for each column in the seating chart, starting with column 0, do:

         Swap the student at the current location with the student
         sitting behind her if that swap would reduce the total
         unhappiness.

         Swap the student at the current location with the student
         sitting in front of her if that swap would reduce the total
         unhappiness.

         Swap the student at the current location with the student to
         her left if that swap would reduce the total unhappiness.

         Swap the student at the current location with the student to
         her right if that swap would reduce the total unhappiness.


         */

        displayRoom(classroom); // intended to display a post sorted classroom

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
    public static void displayRoom(String[][] classroomn) {
        for (int i=0; i<classroomn.length; i++) {
            System.out.println("");
            for (int j = 0; j<classroomn[0].length; j++) {
                System.out.print(classroomn[i][j]);
            }
        }
    }

}







