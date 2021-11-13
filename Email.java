package emailApplication;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {
    public Scanner s = new Scanner(System.in);
    private String firstName, lastName, department, email, password, alternate_email;
    private int mailCapacity =500;

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName =lastName;
        System.out.println("New Employee: "+ this.firstName + " "+ this.lastName);
        this.department= this.setDept();
        this.password=this.generate_password(8);
        this.email= this.generateEmail();
    }

    //Generate Mail Method
    private String generateEmail(){
        return this.firstName.toLowerCase()+"."+this.lastName.toLowerCase()+"@"+this.department.toLowerCase()+".com";

    }

    //Ask for department
    private String setDept(){
        System.out.println("Department codes\n1 for sales \n2 for Development \n3 for Accounting \n0 for None");
        boolean flag = false;

        do{
            System.out.println("Enter Department Code ");
            int choice  = s.nextInt();
            switch(choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose it again ");
            }
        }while(!flag);
        return null;
    }

    //generate random password
    private String generate_password(int length){
        Random r = new Random();
        String Capital_char="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars="abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols="!@#$%^&*?";
        String values =Capital_char+Small_chars+numbers+symbols;
        String password="";
        for(int i=0;i<length;i++){
            password = password+values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    //Change Password Method
    public void set_password() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password?(Yes/No)");
            char choice = s.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter Current Password: ");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password: ");
                    this.password = s.next();
                    System.out.println("Password Changed Successfully");
                } else {
                    System.out.println("Incorrect Password");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password changed option cancelled");
            } else {
                System.out.println("Enter valid choice");
            }

        } while (!flag);
    }
    //Set Mailbox Capacity
    public void set_mailCap(){
        System.out.println("Current Capacity = "+ this.mailCapacity+"mb");
        System.out.println("Enter New Mailbox Capacity: " );
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox Capacity is successfully changed ");
    }
    //set Alternate Email
    public void Alternate_email(){
        System.out.println("Enter new alternate email: ");
        this.alternate_email=s.next();
        System.out.println("Alternate email is set ");
    }

    //Display user information method
    public void getInfo(){
        System.out.println("New Employee: "+ this.firstName+" "+this.lastName);
        System.out.println("Department: "+ this.department);
        System.out.println("Email: "+ this.email);
        System.out.println("Password: "+ this.password);
        System.out.println("Mailbox Capacity: "+ this.mailCapacity+"mb");
        System.out.println("Alternate Email: "+ this.alternate_email);
    }

    //Store in File
    public void storefile(){
        try{
            FileWriter in = new FileWriter("/Users/alamishere/Documents/EmailApplication/info.rtf");
            in.write("First name: "+ this.firstName);
            in.append("\nLast Name: "+ this.lastName);
            in.append("\nEmail: " + this.email);
            in.append("\nPassoword: " + this.password);
            in.append("\nCapacity: " + this.mailCapacity);
            in.append("\nAlternate Email: " + this.alternate_email);
            in.close();
            System.out.println("Data Stored..");
        }catch(Exception e){
            System.out.println(e);
        }
    }
        public void read_file(){
            try {
                FileReader f1 = new FileReader("/Users/alamishere/Documents/EmailApplication/info.rtf");
                int i;
                while((i=f1.read())!= -1){
                    System.out.print((char)i);
                }

                f1.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }

}


