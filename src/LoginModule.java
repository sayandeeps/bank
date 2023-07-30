import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LoginModule {
    public boolean val(String user, String pin){
        String filepath="credentials.txt";
        try(BufferedReader auth = new BufferedReader(new FileReader(filepath))){
            String line;
            while((line = auth.readLine())!=null){
                String[] parts= line.split(",");
                if(parts[1].equals(user) && parts[2].equals(pin)){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println("Some Problem occured during login");
        }
        return false;
    }
    public void login() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println("Enter your phone number");
        String user= sc.next();
        System.out.println("Enter your pin");
        String pin=sc.next();
        if(val(user,pin)){
            System.out.println("Hello User !");
            customerdashboard cust = new customerdashboard(user);
            cust.dashboard();
        }
        else{
            System.out.println("No user found");
        }
    }
}
