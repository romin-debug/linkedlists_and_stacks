package Assignment1;



/*
 * Romin Patel
 * 3164066
 * Assignment-1
 * ACS-2947
 */
public class Student {
    public int studentNumber;
    public String name;
    //full-arg constructor
    public Student(int studentNumber, String name){
        this.studentNumber=studentNumber;
        this.name = name;
    }
    //getters and setters
    public int getStudentNumber(){return studentNumber;}
    public String getName(){return name;}
    public void setStudentNumber(int studentNumber){this.studentNumber=studentNumber;}
    public void setName(String name){this.name = name;}
    //equals method-to check if an object is the same as an instance of student
     //public boolean equals(Student s){
     // return (this.getStudentNumber() == s.getStudentNumber()) && (this.getName().equals(s.getName()));
    // }
  @Override
  public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      Student student = (Student) obj;
      return studentNumber == student.studentNumber && name.equals(student.name);
  }
}
