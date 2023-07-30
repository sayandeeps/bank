import java.io.*;
import java.util.Scanner;

public class RegisterModule {
    String filepath="credentials.txt";
    public boolean validregister(String name, String phone, String pin){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath,true))){
            String line = name+","+phone+","+pin;
            writer.write(line);
            writer.newLine();
            String[] parts = line.split(",");//parts[0]= name parts[1]=phone
            String folderpath = "./data/";
            new File(folderpath).mkdirs();
            String filename=parts[1];
            String filepath=folderpath+filename+".txt";
            BufferedWriter newuser=new BufferedWriter(new FileWriter(filepath,true));
            String bal= "0";
            newuser.write("Account Balance:\n");
            newuser.write(bal+"\n");
            newuser.close();
            writer.close();
            return true;
        }
        catch (Exception e){
            System.out.println("Some Problem occurred while registration");
        }
        return false;
    }
    public void register(){
        System.out.println("---------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Enter your phone number");
        String phone= sc.next();
        System.out.println("Enter your pin");
        String pin=sc.next();
        if(validregister(name,phone,pin)){
            System.out.println("Registration Successful");
        }
        else{
            System.out.println("try again later!!");
        }

    }
}
