package src.design07_File_System;

import java.util.Arrays;

public class FileManager {
    private final Directory root;

    public FileManager() {
        this.root = new Directory("root");// Root always Directory
    }



    public void CreateDirectory(String path,String name){
        String[] pathArray =path.split("/");
        System.out.println(Arrays.toString(pathArray)+" l "+pathArray.length);
        root.AddDirectory(pathArray,new Directory(name),1);
    }

    public void CreateFile(String path,String name){
        String[] pathArray =path.split("/");
        System.out.println(Arrays.toString(pathArray)+" l "+pathArray.length);
        root.AddFile(pathArray,new File(name),1);
    }

    public void ls(){// Ls for list of files
          this.root.ls("--> ");
    }

    public void ls(String path,String Name){// Ls for list of files
        Directory d=root.getDirectory(path.split("/"),1,Name);
        d.ls("--> ");
    }

    public void deleteAny(String path,String name){
        String[] pathArray =path.split("/");
        root.deleteAnything(pathArray,1,name);
    }


    public void AddContent(String path,String Name,String content){
            File f=root.getFile(path.split("/"),1,Name);
            f.addContent(content);
       //     f.getContent();
    }

    public void updateContent(String path,String Name,String content){
        File f=root.getFile(path.split("/"),1,Name);
        f.updateContent(content);
     //   f.getContent();
    }

    public void deleteContent(String path,String Name){
        AddContent( path, Name," - ");//with ""
    }

    public void rename(String path,String oldName,String newName){
        String[] pathArray =path.split("/");
        root.rename(pathArray,newName,oldName,1);
    }

    public void readFile(String path,String Name){
        File f=root.getFile(path.split("/"),1,Name);
        f.getContent();
    }
}
