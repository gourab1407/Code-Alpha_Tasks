import java.util.ArrayList;
import java.util.Scanner;
class Student{
    String name;
    int grade;
    Student(String name,int grade){
        this.name=name;
        this.grade=grade;
    }
}
public class Grade_Tracker {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Student Grade Tracker");
            System.out.print("Enter the number of student :");
            int number=sc.nextInt();

        sc.nextLine();

        for(int i=0;i<number;i++){
            System.out.println("Name of the Student "+(i+1)+":");
            String name=sc.nextLine();

         System.out.println("Enter the " +name+"'s Grade :");
            int grade=sc.nextInt();
            sc.nextLine();
            students.add(new Student(name,grade));
        }
int total = 0, highest = -1, lowest = 101;
   String topStudent = "", lowStudent = "";
        for (Student s : students) {
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s.name;
            }

            if (s.grade < lowest) {
                lowest = s.grade;
                lowStudent = s.name;
            }
        }
        double average = total/students.size();
        System.out.println("Student Grade");
        for(Student s : students ){
            System.out.println(s.name+":"+s.grade);
        }

        System.out.printf("\nAverage Score: %.2f\n", average);
        System.out.println("Highest Score: " + highest + " (by " + topStudent + ")");
        System.out.println("Lowest Score: " + lowest + " (by " + lowStudent + ")");

        sc.close();
    }
}


