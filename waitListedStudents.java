package Assignment1;



/*
 * Romin Patel
 * 3164066
 * Assignment-1
 * ACS-2947
 */

public class waitListedStudents extends Student {

    private Status status;
    private int daysLeft;
    //initializes the regitration status to waitlist and days left 0
    public waitListedStudents(int studentNumber, String name) {
        super(studentNumber, name);
        this.status = status.WAITLISTED;
        this.daysLeft = 0;
    }

    // number of days left to register
    public waitListedStudents(int studentNumber, String name, int daysLeft) {
        super(studentNumber, name);
        this.status = status.WAITLISTED;
        this.daysLeft = daysLeft;
    }
    //getters and setters
    public Status getStatus(){return status;}
    public void setStatus(Status status){this.status=status;}
    public int getDaysLeft(){return daysLeft;}
    public void setDaysLeft(int permittedtoregister){this.daysLeft=permittedtoregister;}
    public String toString(){
        if(status != Status.WAITLISTED){
            System.out.println();
            return studentNumber + " :" + name + " ," + "Status: " + status + daysLeft ;
        }else{
            return studentNumber + " :" + name + " ," + "Status: " + status ;
        }
    }
}
