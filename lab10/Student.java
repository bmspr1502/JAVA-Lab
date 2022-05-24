import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class StudentDriver{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = args[0];
        StudentRecordReader reader = new StudentRecordReader(filename);
      
        do{
            System.out.println("Choose: \n1.Read details from " + filename +"\n2.Write Details to " + filename + "\n0.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if(ch==0){
                reader.closef();
               
                break;
            }else if(ch==1){
                try {
                    Student obj = reader.read();
                    System.out.println("Object is read. Details are:- \n" + obj.toString());
                    System.out.println("===========================");
                } catch (Exception e) {
                    System.out.println("Error: "+e);
                }
            }else if(ch==2){
                StudentRecordWriter writer = new StudentRecordWriter(filename);
                System.out.println("\nEnter Name: ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.println("Enter gender: ");
                String gender  = sc.nextLine();

                System.out.println("Enter age: ");
                int age = sc.nextInt();

                System.out.println("Enter grade: ");
                int grade = sc.nextInt();


                Student stu = new Student(name, age, gender, grade);

                   try {
                    writer.write(stu);
                    System.out.println("Object has been written");
                    System.out.println("===========================");
                } catch (Exception e) {
                    System.out.println("Error: "+e);
                }

                writer.closef();
            }

        }while(true);
    }
}

class StudentRecordReader{
    FileInputStream infile = null;

    StudentRecordReader(String filename){
        try{
            infile = new FileInputStream(filename);
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    }

    public Student read(){
        Student obj = null;
        try{
            ObjectInputStream stream = new ObjectInputStream(infile);

 
            obj = (Student) stream.readObject();
    

            stream.close();
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
        return obj;
    }

    public void closef(){
        try {
            infile.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error: " + e);
        } 
       
    }
}

class StudentRecordWriter{
    FileOutputStream output = null;

    StudentRecordWriter(String filename){
        try{
            output = new FileOutputStream(filename);
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    }

    public void write(Student stu){
        try{
           ObjectOutputStream stream = new ObjectOutputStream(output);

        
            stream.writeObject(stu);
      

            stream.close();
        }catch(Exception e){
            System.out.println("Error: "+e);
        }
    }

    public void closef(){
        try {
            output.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error: " + e);
        } 
       
    }
}

class Student implements Serializable{
    private String name;
    private int age;
    private String gender;
    private int grade;


    Student(String name, int age, String gender, int grade){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
    }

    public String toString(){
        return "Name: " + this.name +"\nAge = "+ this.age + "\nGender = " + this.gender + "\nGrade = " + this.grade ;
    }

    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public String getGender(){
        return this.gender;
    }
    
    public int getGrade(){
        return this.grade;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }
}
