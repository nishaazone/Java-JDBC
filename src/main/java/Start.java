import manage.Student;
import manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Student Management App");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean var = true;
        while (var) {
            System.out.println("PRESS 1 to ADD student");
            System.out.println("PRESS 2 to DELETE student");
            System.out.println("PRESS 3 to DISPLAY student");
            System.out.println("PRESS 4 to UPDATE student");
            System.out.println("PRESS 5 to EXIT app");

            int c = Integer.parseInt(br.readLine());

            switch (c) {
                case 1:
                    System.out.println("Enter user name :");
                    String name = br.readLine();
                    System.out.println("Enter user phone :");
                    String phone = br.readLine();
                    System.out.println("Enter user city :");
                    String city = br.readLine();
                    Student student = new Student(name, phone, city);
                    boolean resultIn = StudentDao.insertStudentToDb(student);
                    if (resultIn) {
                        System.out.println("Success.");
                    } else {
                        System.out.println("Cannot add student");
                    }
                    break;

                case 2:
                    System.out.println("Enter student Id to delete");
                    int userId = Integer.parseInt(br.readLine());
                    boolean resultDl = StudentDao.deleteStudent(userId);
                    if (resultDl) {
                        System.out.println("Deleted.");
                    } else {
                        System.out.println("Unable to delete");
                    }
                    break;

                case 3:
                    StudentDao.showAllStudents();
                    break;

                case 4:
                    System.out.println("Enter student Id to update");
                    int userIdUp = Integer.parseInt(br.readLine());
                    System.out.println("Enter user name :");
                    String nameUp = br.readLine();
                    System.out.println("Enter user phone :");
                    String phoneUp = br.readLine();
                    System.out.println("Enter user city :");
                    String cityUp = br.readLine();
                    Student studentUp = new Student(nameUp, phoneUp, cityUp);
                    boolean resultUp = StudentDao.updateStudent(studentUp, userIdUp);
                    if (resultUp) {
                        System.out.println("Updated.");
                    } else {
                        System.out.println("Unable to update");
                    }
                    break;

                case 5:
                    var = false;
                    break;

                default:
                    break;

            }

        }
        System.out.println("Exiting the Application...Thank-you");
    }

}
