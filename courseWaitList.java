package Assignment1;


/*
 * Romin Patel
 * 3164066
 * Assignment-1
 * ACS-2947
 */
import java.util.Random;
import java.util.Scanner;

public class courseWaitList {
    private CircularDoublyLinkedList<waitListedStudents> list;

    public courseWaitList() {
        list = new CircularDoublyLinkedList<>();
        initializeList();
    }

    private void initializeList() {
        waitListedStudents first = new waitListedStudents(1111111, "Jeremy");
        waitListedStudents second = new waitListedStudents(2222222, "Anne");
        waitListedStudents third = new waitListedStudents(3333333, "Jacob");
        waitListedStudents fourth = new waitListedStudents(4444444, "Melissa");
        list.addLast(first);
        list.addLast(second);
        list.addLast(third);
        list.addLast(fourth);
        if (!list.isEmpty()) {
            waitListedStudents std1 = list.first();
            std1.setStatus(Status.PERMITTEDTOREGISTER);
            std1.setDaysLeft(2);
        }
    }

    public void simulate() {

        int operations = 0;
        Random rand = new Random();
        Scanner kb = new Scanner(System.in);
        System.out.println("ACS-2947 Waitlist");
        System.out.println(list.toString());
        while (!list.isEmpty() && operations <= 20) {
            int n = rand.nextInt(4) + 1;
            System.out.println("System chose option " + n + " :");
            switch (n) {
                case 1:
                    System.out.println("No addition to waitlist (status/days left may change)");
                    if(!list.isEmpty()){
                        waitListedStudents studenToUpdate =list.first();
                        if(studenToUpdate.getStatus() == Status.PERMITTEDTOREGISTER){
                            studenToUpdate.setDaysLeft(studenToUpdate.getDaysLeft()-1);
                            System.out.println(studenToUpdate.getName() + " 's days left to register");
                        }else{
                            //studenToUpdate.setDaysLeft(Status.PERMITTEDTOREGISTER);
                            studenToUpdate.setDaysLeft(2);
                            System.out.println(studenToUpdate.getName()+ " got permission to register");
                            System.out.println("Updated waitlist");
                            System.out.println(list.toString());
                        }
                    }else{
                        System.out.println("Wailist is empty");
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("A new student joins the waitlist");
                    System.out.print("Enter student name and number: ");
                    int newStudentNumber = kb.nextInt();
                    String newStudentName = kb.next();
                    waitListedStudents newStudent = new waitListedStudents(newStudentNumber, newStudentName);
                    list.addLast(newStudent);
                    list.toString();
                    System.out.println();
                    break;
                case 3:
                    if(!list.isEmpty()){
                        waitListedStudents studentToRegister =list.first();
                        if(studentToRegister.getStatus() == Status.PERMITTEDTOREGISTER){
                            list.removeFirst();
                            System.out.println(studentToRegister.getName() + " has registered.");
                        }else{
                            studentToRegister.setStatus(Status.PERMITTEDTOREGISTER);
                        }
                        System.out.println("Updated Waitlist");
                        System.out.println(list.toString());
                    }else{
                        System.out.println("list is empty");
                    }

                    System.out.println();
                    break;
                case 4:
                    System.out.println("Checks if a student is waitlisted");
                    System.out.print("Enter student name and number: ");
                    int studentNumberToCheck = kb.nextInt();
                    String studentNameToCheck = kb.next();
                    waitListedStudents studentToCheck = new waitListedStudents(studentNumberToCheck,
                            studentNameToCheck);
                    if (list.contains(studentToCheck)) {
                        System.out.println("Student found in waitlist");
                    } else {
                        System.out.println("Student not found in waitlist");
                    }
                    list.toString();
                    System.out.println();
                    break;
            }
            operations++;
        }
        System.out.println("Termination condition: " + (list.isEmpty() ? "Waitlist is empty" : "20 operations reached"));
        System.out.println("Final ACS-2947 Waitlist");
        System.out.println(list.toString());
    }
}