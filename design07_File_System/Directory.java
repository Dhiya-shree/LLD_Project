package src.design07_File_System;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystem {

    private final List<FileSystem> fileSystemList;


    public Directory(String name) {
        this.name = name;
        this.fileSystemList = new ArrayList<>();
    }

    public void ls(String space) {
        System.out.println(space+this.name);
        for(FileSystem f: fileSystemList){
            if(f.isDirectory()){
                Directory dir = (Directory) f;
                dir.ls("  "+space);
            }
            else{
                System.out.println("  "+space+f.getName());
            }
        }

    }

    public void rename(String[] path, String name, String old, int i) {

    //    System.out.println(" i "+i+ " curr "+this.name+" "+Arrays.toString(path));
        if (path.length -1== i) {

            for (FileSystem p : fileSystemList) {
                if ( p.getName().equals(old)) {

                    p.name=name;
                    System.out.println(" Renamed successfully !!!");
                    return;
                }
            }


        } else {
            for (FileSystem p : fileSystemList) {
                if (p.isDirectory() && p.getName().equalsIgnoreCase(path[i+1])) {

                    Directory dir = (Directory) p;
                    dir.rename(path, name, old, i + 1);
                    return;

                }
            }

            System.out.println(" Path doesn't exist");
        }
    }

    public void AddDirectory(String[] path, Directory d, int i) {
        if (path.length - 1 == i) {

            for (FileSystem p : fileSystemList) {
                if (p.isDirectory() && p.getName().equals(d.getName())) {
                    System.out.println(" Not able to add . Multiple files with same name");
                }
            }

            this.fileSystemList.add(d);
            System.out.println(" Added successfully !!!");
        } else {
            System.out.println(" i "+i+ " curr "+name);
            for (FileSystem p : fileSystemList) {
               // System.out.println(p.getName()+"--->"+p.isDirectory()+" "+p.getName().trim().equalsIgnoreCase(path[i+1].trim()));
                if (p.isDirectory() && p.getName().trim().equalsIgnoreCase(path[i+1].trim())) {

                    Directory dir = (Directory) p;
                    dir.AddDirectory(path, d, i + 1);
                    return;

                }
            }

            System.out.println(" Path doesn't exist");
        }

    }

    public void AddFile(String[] path, File d, int i) {
      //  System.out.println(" Path "+ Arrays.toString(path));
        if (path.length - 1 == i) {

            for (FileSystem p : fileSystemList) {
                // Must not be a directory
                if (!p.isDirectory() && p.getName()!=null &&p.getName().equals(d.getName())) {
                    System.out.println(" Not able to add . Multiple files with same name");
                }
            }

            this.fileSystemList.add(d);
            System.out.println(" Added successfully !!!");
        } else {
            for (FileSystem p : fileSystemList) {
                if (p.isDirectory() && p.getName().equalsIgnoreCase(path[i+1])) {

                    Directory dir = (Directory) p;
                    dir.AddFile(path, d, i + 1);
                    return;

                }
            }

            System.out.println(" Path doesn't exist");
        }
    }

    File getFile(String[] path, int i, String FileName) {

      //  System.out.println(" I "+i+" curr "+name+" "+FileName+" "+Arrays.toString(path)+" "+path.length);
        if (path.length-2 == i) {
            File copy = new File("New File");
            for (FileSystem p : fileSystemList) {
                // Must not be a directory
                if (!p.isDirectory() && p.getName().equalsIgnoreCase(FileName)) {
                    return (File) p;
                }
            }

            System.out.println(" No such file exists ");
            return copy;
        } else {

            for (FileSystem p : fileSystemList) {
        //        System.out.println(i+" "+p.getName()+" "+path[i+1]);
                if (p.isDirectory() && p.getName().equalsIgnoreCase(path[i+1])) {

                    Directory dir = (Directory) p;
                    return dir.getFile(path, i + 1, FileName);


                }
            }
            System.out.println(" No file exists");
            return new File("None");
        }

    }

    void deleteAnything(String[] path, int i, String toDelete){
        if (path.length -1 == i) {
            for (FileSystem p : fileSystemList) {
                // Must not be a directory
                if ( p.getName().equalsIgnoreCase(toDelete)) {
                   delete(p);
                   return;
                }
            }

            System.out.println(" No suc file exists ");
        } else {
            System.out.println(" Curr "+name+" I val "+path[i]+" "+path[i+1]);
            for (FileSystem p : fileSystemList) {
                if (p.isDirectory() && p.getName().equalsIgnoreCase(path[i+1])) {

                    Directory dir = (Directory) p;
                     dir.deleteAnything(path, i + 1, toDelete);
                    return;

                }
            }
            System.out.println(" No file exists");

        }
    }


    void delete(FileSystem f){
        this.fileSystemList.remove(f);
    }


    @Override
    public boolean isDirectory() {
        return true;
    }

    public Directory getDirectory(String[] path, int i, String FileName) {

        //  System.out.println(" I "+i+" curr "+name+" "+FileName+" "+Arrays.toString(path)+" "+path.length);
        if (path.length-2 == i) {
            Directory copy = new Directory("New Dir");
            for (FileSystem p : fileSystemList) {
                // Must not be a directory
                if (p.isDirectory() && p.getName().equalsIgnoreCase(FileName)) {
                    return (Directory) p;
                }
            }

            System.out.println(" No such directory exists ");
            return copy;
        } else {

            for (FileSystem p : fileSystemList) {
                //        System.out.println(i+" "+p.getName()+" "+path[i+1]);
                if (p.isDirectory() && p.getName().equalsIgnoreCase(path[i+1])) {

                    Directory dir = (Directory) p;
                    return dir.getDirectory(path, i + 1, FileName);


                }
            }
            System.out.println(" No file exists");
            return new Directory("None");
        }
    }
}
