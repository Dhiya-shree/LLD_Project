package src.design07_File_System;

public class FileSystem_RUN {

    public static void main(String[] args) {
        FileManager fileManager=new FileManager();
       fileManager.CreateDirectory("/SystemDesign","HLD");
        fileManager.CreateDirectory("/SystemDesign/HLD/","Design1");
        fileManager.CreateFile("/SystemDesign/HLD/Design1","D1");
        fileManager.CreateDirectory("/SystemDesign/HLD/","Design2");
        fileManager.CreateFile("/SystemDesign/HLD/Design2","D2");
        fileManager.CreateFile("/SystemDesign/HLD/Design2","D3");
        fileManager.CreateDirectory("/SystemDesign/HLD/","Design3");
        fileManager.ls("/SystemDesign/HLD/","HLD");

       fileManager.CreateDirectory("/SystemDesign","LLD");
        fileManager.CreateDirectory("/SystemDesign/LLD/","Day1");
        fileManager.CreateDirectory("/SystemDesign/LLD/","Day2");
        fileManager.CreateDirectory("/SystemDesign/LLD/","Day3");
        fileManager.ls();

        fileManager.rename("/SystemDesign/HLD/Design2/","D3","D3Delete");
        fileManager.ls();


        fileManager.deleteAny("/SystemDesign/HLD/Design2/","D3Delete");
        fileManager.ls();

        fileManager.AddContent("/SystemDesign/HLD/Design1/D1/","D1","D1 adding ");
        fileManager.readFile("/SystemDesign/HLD/Design1/D1/","D1");

        fileManager.updateContent("/SystemDesign/HLD/Design1/D1/","D1","D1 content adding 2 .....");
        fileManager.readFile("/SystemDesign/HLD/Design1/D1/","D1");

        fileManager.deleteContent("/SystemDesign/HLD/Design1/D1/","D1");
        fileManager.readFile("/SystemDesign/HLD/Design1/D1/","D1");

        fileManager.deleteAny("/SystemDesign/LLD/","Day1");
        fileManager.ls("/SystemDesign/LLD/","LLD");
        fileManager.ls();
    }
}
