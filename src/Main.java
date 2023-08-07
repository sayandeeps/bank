import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to My Bank");
        Scanner sc = new Scanner (System.in);
        while(true){
            System.out.println("-----------------------------------------------");
            System.out.println("1. Register Your Self");
            System.out.println("2. Login Your Self");
            System.out.println("3. Exit");
            int c = sc.nextInt();
            if(c==3){
                break;
            }
            else if(c==1){
                RegisterModule r= new RegisterModule();
                r.register();
            }
            else if (c==2){
                LoginModule l=new LoginModule();
                l.login();
            }
            else {
                System.out.println("Invalid options WHat else do you want ");
            }
        }

    }
}