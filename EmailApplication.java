package emailApplication;
import java.util.Scanner;

public class EmailApplication {
    public static void main(String []args){
        Scanner s = new Scanner(System.in);

        //User Info
        System.out.println("Enter First Name: ");
        String firstName = s.next();
        System.out.println("Enter Last Name: ");
        String lastName = s.next();

        //creating object for email address
        Email email1 = new Email(firstName,lastName);
        int choice = -1;
        do{
            System.out.println("\n*********\nEnter your choice\n1.Show Info\n" +
                                "2.Change Password\n3.Change Mailbox Capacity\n"+
                                "4.Set Alternate mail\n5.Store data in file\n"+
                                "6.Display data from file\n7.Exit");
            choice =s.nextInt();
            switch (choice){
                case 1: email1.getInfo();
                        break;
                case 2: email1.set_password();
                        break;
                case 3: email1.set_mailCap();
                        break;
                case 4: email1.Alternate_email();
                        break;
                case 5:
                    email1.storefile();
                        break;
                case 6:
                    email1.read_file();
                    break;
                case 7:
                    System.out.println("Thank you for using our application");
                    break;
                default:
                    System.out.println("Invalid Choice!! \n Enter Proper choice again");
            }
        }while(choice!=7);
    }

}
