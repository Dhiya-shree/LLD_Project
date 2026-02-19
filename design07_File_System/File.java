package src.design07_File_System;


public class File extends FileSystem{

    private String content;

    public File(String name) {
        this.name=name;
        this.content = "";
    }

    public void getContent(){
        System.out.println(this.content);
    }


    public void addContent(String c){
        content=c;
    }

    public void updateContent(String c){
        this.content=content+c;
    }


    @Override
    public boolean isDirectory() {
        return false;
    }
}
