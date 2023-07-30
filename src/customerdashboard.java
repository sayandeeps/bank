import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class customerdashboard {
    String customer;
    customerdashboard(String user){
        customer=user;
    }
    public void update(int bal , String filepath){
        try{
            String bale =String.valueOf(bal);
            RandomAccessFile file =new RandomAccessFile(filepath,"rw");
            long filepointer=0;
            for(int i =1;i<2;i++){
                String line = file.readLine();
                filepointer=file.getFilePointer();
            }
            file.seek(filepointer);
            file.writeBytes(bale+"\n");
            file.close();
        }catch (Exception e){
            System.out.println("There was some problem while transfer!!");
        }
    }
    public void dashboard() throws IOException {
        String folderpath="./data/";
        String filepath=folderpath+customer+".txt";
        String l2= Files.readAllLines(Paths.get(filepath)).get(1);
        int cbal=Integer.parseInt(l2);
        while(true) {
            System.out.println("--------------------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transaction Histroy");
            System.out.println("5. Exit");
            int c = sc.nextInt();
            if (c == 5) {
                break;
            }
            else if(c==1){
                System.out.println("------------------------------");
                System.out.println("The available balance is "+cbal);
            }
            else if (c==2) {
                System.out.println("----------------------------------");
                System.out.println("Enter the amount you want to withdraw: ");
                int drawamt = sc.nextInt();
                if (drawamt > cbal) {
                    System.out.println("insufficiant fund !!");
                } else {
                    cbal = cbal - drawamt;
                    update(cbal, filepath);
                    System.out.println("Amount withdrawn succesfully");
                    System.out.println("Available Balance: "+cbal);
                    try(BufferedWriter br = new BufferedWriter(new FileWriter(filepath,true))){
                        Date currentdate = new Date();
                        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String formattedDateTime =dateformat.format(currentdate);
                        br.write(drawamt+" Debited at "+formattedDateTime+": Available Balance: "+cbal+"\n");
                    }catch(Exception e){
                        System.out.println("Problem while updating !!");
                    }
                }
            }
            else if(c==4){
                System.out.println("-------------------------------");{
                    try(BufferedReader r = new BufferedReader(new FileReader(filepath))){
                        String line;
                        while((line =r.readLine())!=null){
                            System.out.println(line);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
                else if (c==3){
                    System.out.println("----------------------------------");
                    System.out.println("Enter the amount you want to deposit: ");
                    int depamt= sc.nextInt();


                        cbal =cbal+depamt;
                        update(cbal,filepath);
                System.out.println("Amount withdrawn succesfully");
                System.out.println("Available Balance: "+cbal);
                try(BufferedWriter br = new BufferedWriter(new FileWriter(filepath,true))){
                    Date currentdate = new Date();
                    SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formattedDateTime =dateformat.format(currentdate);
                    br.write(depamt+" Credited at "+formattedDateTime+": Available Balance: "+cbal+"\n");
                }catch(Exception e){
                    System.out.println("Problem while updating !!");
                }


            }
            else {
                System.out.println("invalid option");
            }
        }

    }
}
