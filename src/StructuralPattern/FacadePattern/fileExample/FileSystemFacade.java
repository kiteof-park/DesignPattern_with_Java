package StructuralPattern.FacadePattern.fileExample;

import java.io.IOException;

// 📌 파사드 패턴 -> 드라이브 스루
public class FileSystemFacade {
    // 📌 각 클래스를 필드로 가지는 Facade 클래스(Facade 역할)
    private FileReader fileReader;
    private FileWriter fileWriter;
    private FileDeleter fileDeleter;

    // 📌 서브 시스템의 생성까지 Facade가 알아서 함
    public FileSystemFacade(){
        this.fileReader = new FileReader();
        this.fileWriter = new FileWriter();
        this.fileDeleter = new FileDeleter();
    }

    // 📌 서브 시스템의 기능을 Facade에서 정의하되, 서브 시스템의 메서드로 동작하도록 함
    public String readFile(String filePath){
        try{
            return fileReader.readFile(filePath);
        } catch(IOException ie){
            System.err.println("Error reading file : " + ie.getMessage());
            return null;
        }
    }

    public boolean writeFile(String filePath, String content){
        try{
            fileWriter.writeFile(filePath, content);
            return true;
        } catch(IOException ie){
            System.err.println("Error writing file: " + ie.getMessage());
            return false;
        }
    }

    public boolean deleteFile(String filePath) {
        try {
            fileDeleter.deleteFile(filePath);
            return true;
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
            return false;
        }
    }
}
