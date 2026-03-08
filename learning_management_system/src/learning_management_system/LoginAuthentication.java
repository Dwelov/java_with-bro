import java.io.*;

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

}
