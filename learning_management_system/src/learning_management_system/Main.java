import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        int choice = -1;
        String userName=null, Password;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Welcome To Learning Management System");
            System.out.println("1. Sign in");
            System.out.println("2. Forgot Password");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    do{
                        System.out.println("Enter Your Credentials to Login");
                        System.out.print("Enter your user name: ");
                        userName = scanner.nextLine();
                        System.out.print("Enter your password: ");
                        Password = scanner.nextLine();
                        LoginAuthentication verifyUser = new LoginAuthentication(userName, Password);

                        if (verifyUser.verifyStudent()) {
                            break;
                        } else if (verifyUser.verifyTeacher()) {
                            break;
                        } else if (verifyUser.verifyAdmin()) {
                            break;
                        } else {
                            System.out.println("Invalid Username or Password");
                            count++;
                        }
                        if (count == 4) {
                            System.out.println("*You have tried for 4 times*");
                            System.out.println("*Wait 30 seconds to try again*");
                            Timer timer = new Timer();
                            TimerTask timerTask = new TimerTask() {
                                int counter = 31;

                                @Override
                                public void run() {
                                    counter--;
                                    System.out.printf("\r*Timer: %d*", counter);
                                    if (counter == 0) {
                                        System.out.println("\nPress Enter to Continue...");
                                        timer.cancel();
                                    }
                                }
                            };
                            timer.scheduleAtFixedRate(timerTask, 0, 1000);
                            scanner.nextLine();
                        }
                    }while (userName!=null);

                    break;
                }
                case 2: {
                        LoginAuthentication.forgotPassword();
                    break;
                }
                case 3: {
                    System.out.println("Exiting...");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println("Error Encountered");
                    }
                    System.out.println("See You Soon...");
                    break;
                }
                default:
                    break;
            }
        } while (choice != 3);
        scanner.close();
    }
}
