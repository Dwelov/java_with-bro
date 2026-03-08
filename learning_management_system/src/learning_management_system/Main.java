import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        int count=0;
        System.out.println("Welcome To Learning Management System");
        do{
            String userName, Password;
            Scanner scanner= new Scanner(System.in);
            System.out.print("Enter your user name: ");
            userName= scanner.nextLine();
            System.out.print("Enter your password: ");
            Password= scanner.nextLine();
            LoginAuthentication verifyUser= new LoginAuthentication(userName, Password);

            if(verifyUser.verifyStudent()){
                break;
            }
            else if(verifyUser.verifyTeacher()){
                break;
            }
            else if(verifyUser.verifyAdmin()){
                break;
            }
            else{
                System.out.println("Invalid Username or Password");
                count++;
            }
            if(count==4){
                System.out.println("*You have tried for 4 times*");
                System.out.println("*Wait 30 seconds to try again*");
                Timer timer = new Timer();
                TimerTask timerTask= new TimerTask() {
                    int counter= 31;
                    @Override
                    public void run() {
                        counter--;
                        System.out.printf("\r*Timer: %d*", counter);
                        if(counter ==  0){
                            System.out.println("\nPress Enter to Continue...");
                            timer.cancel();
                        }
                    }
                };
                timer.scheduleAtFixedRate(timerTask, 0, 1000);
                scanner.nextLine();
            }
        }while(true);
    }
}
