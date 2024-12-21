import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Student{
  private int roll_no ;
  private String  name ;
  private String email;
  private static HashMap<Integer ,Student> students = new HashMap<>();
  private ArrayList<String> courses = new ArrayList<>();
  public  int getrollno(){
      return roll_no;
  }
  public void   setrollno(int roll_no){
    this.roll_no = roll_no;
  }
  public String getName() {
    return name;
  }
  public void   setFname(String name){
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void   setEmail(String email){
    this.email = email;
  }
  public ArrayList<String> getCourses() {
    return courses;
}
  public static void addStudent(int roll_no, Student student) {
    students.put(roll_no, student);
  }

  public static Student getStudent(int roll_no) {
    return students.get(roll_no);
  } 

  public static boolean studentExists(int roll_no) {
    return students.containsKey(roll_no);
  }
}

class Student_enroll{
  public  static void std_enroll(Scanner sc){
    Student obj = new Student();
    System.out.println("Welcome to eshwar tutorial center");
    System.out.println("please enter the below details to enroll into the coaching center");
    System.out.println("please enter name");
    String std_name = sc.nextLine();
    obj.setFname(std_name);
    System.out.println("please enter your email");
    String std_email = sc.nextLine();
    obj.setEmail(std_email);
    System.out.println("please enter your favourite number for id within 10");
    int std_id = sc.nextInt();
    sc.nextLine();
    obj.setrollno(std_id);
    Student.addStudent(std_id, obj);
  }
}

class StdCourses{
  public  static void courses(Scanner sc){
    System.out.println("please enter roll_no for course selection");
    int roll = sc.nextInt();
    sc.nextLine();
    if(Student.studentExists(roll)){
        Student student = Student.getStudent(roll);
        for(int i =0;i<5;i++){
          System.out.println("Please enter the course  name");
          String val = sc.nextLine();
          student.getCourses().add(val);
        }      
    }
    else{
      System.out.println("your id does not exist , please enroll");
    }
  }
}

class StudentDetailsView{
  public static void  std_view(Scanner sc){
    System.out.println("please enter your id for viewing the details");
    int val = sc.nextInt();
    sc.nextLine();
    if(Student.studentExists(val)){
      Student obj = Student.getStudent(val);
      System.out.println("The student name is : " +obj.getName());
      System.out.println("The student email is : "+obj.getEmail());
      System.out.println("The student id is : " +obj.getrollno());
      for(String course: obj.getCourses()){
         System.out.println(" - " +course);
      }
    }
    else{
        System.out.println("Invalid id");
    }
  }
}

class Main{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    Student_enroll.std_enroll(sc);
    StdCourses.courses(sc);
    StudentDetailsView.std_view(sc);
    sc.close();
  }
}