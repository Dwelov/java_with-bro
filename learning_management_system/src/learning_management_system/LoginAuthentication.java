import java.io.*;
import java.util.Scanner;

public class LoginAuthentication {
    private String userName;
    private String password;
    LoginAuthentication(String userName, String password){
        this.userName= userName;
        this.password= password;
    }
    //-----------------------------------------
    //Getters
    String getUserName(){
        return this.userName;
    }
    String getPassword(){
        return this.password;
    }
    //Setters
    void setUserName(String userName){
        this.userName= userName;
    }
    void setPassword(String password){
        this.password= password;
    }
    //-------------------------------------------
    boolean verifyStudent(){
        String line;
        boolean access= false;
        try(BufferedReader studentReader= new BufferedReader(new FileReader("Students.csv"))){
            while((line=studentReader.readLine())!=null){
                String[] lineArray= line.split(",");
                if(lineArray[0].equals(this.userName) && lineArray[1].equals(this.password)){
                    access= true;
                    System.out.println("Welcome! Successful Login as Student -- "+ lineArray[2]);
                    return access;
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Given File couldn't be found");
        }
        catch(IOException e){
            System.out.println("Error opening file!");
        }
        return access;
    }
    //-----------------------------------------
    boolean verifyTeacher(){
        String line;
        boolean access= false;
        try(BufferedReader TeacherReader= new BufferedReader(new FileReader("Teacher.csv"))){
            while((line=TeacherReader.readLine())!=null){
                String[] lineArray= line.split(",");
                if(lineArray[0].equals(this.userName) && lineArray[1].equals(this.password)){
                    access= true;
                    System.out.println("Welcome! Successful Login as teacher -- "+lineArray[2]);
                    return access;
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Given File couldn't be found");
        }
        catch(IOException e){
            System.out.println("Error opening file!");
        }
        return access;
    }
    //-----------------------------------------
    boolean verifyAdmin(){
        String line;
        boolean access= false;
        try(BufferedReader AdminReader= new BufferedReader(new FileReader("Admin.csv"))){
            while((line=AdminReader.readLine())!=null){
                String[] lineArray= line.split(",");
                if(lineArray[0].equals(this.userName) && lineArray[1].equals(this.password)){
                    access= true;
                    System.out.println("Welcome! Successful Login as Admin -- "+lineArray[2]);
                    return access;
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Given File couldn't be found");
        }
        catch(IOException e){
            System.out.println("Error opening file!");
        }
        return access;
    }
    //-----------------------------------------
    static void forgotPassword(){
        String emailAddress, userName;
        String Line;
        String newPassword;
        boolean access= false;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Password Reset...");
        System.out.print("Enter your student id: ");
        userName= scanner.nextLine();
        System.out.print("Enter your Email address: ");
        emailAddress= scanner.nextLine();
        try(BufferedReader reader= new BufferedReader(new FileReader("Students.csv"))){
            FileWriter writer= new FileWriter("Students_temp.csv");
            while((Line=reader.readLine())!=null){
                String[] lineArray= Line.split(",");
                if(lineArray[0].equals(userName) && lineArray[3].equals(emailAddress)){
                    System.out.println("Email Id confirmed");
                    System.out.print("Enter your new Password: ");
                    newPassword= scanner.nextLine();
                    writer.write(lineArray[0]+","+newPassword+","+lineArray[2]+","+lineArray[3]+","+lineArray[4]+","+lineArray[5]+"\n");
                    access= true;
                }
                else{
                    writer.write(Line+"\n");
                }
            }
            reader.close();
            writer.close();
            File oldfile= new File("Students.csv");
            File newFile= new File("Students_temp.csv");

            if(access){
                if(oldfile.delete()){
                    if(!newFile.renameTo(oldfile)){
                        System.out.println("File couldn't Renamed");
                    }
                }
                else{
                    System.out.println("File couldn't be deleted");
                }
            }
            else{
                if(newFile.delete()){
                    System.out.println("Password couldn't be deleted");
                }
                else{
                    System.out.println("File couldn't be deleted");
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
        catch(IOException e){
            System.out.println("Something Error Happened");
        }
    }
}
