package StructuralPattern.FacadePattern;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystem {
    public void hello(){
        System.out.println("hello");
    }
}

// 파일 읽기
class FileReader{
    public String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}

// 파일 쓰기
class FileWriter{
    public void writeFile(String filePath, String content) throws IOException{
        Files.write(Paths.get(filePath), content.getBytes());
    }
}

// 파일 삭제
class FileDeleter{
    public void deleteFile(String filePath) throws IOException{
        Files.delete(Paths.get(filePath));
    }
}