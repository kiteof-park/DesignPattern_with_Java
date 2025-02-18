package StructuralPattern.FacadePattern.fileExample;

// 📌 클라이언트는 Facade만 생성해서 사용
// 📌 서브 시스템의 코드는 클라이언트에서 전혀 사용되지 않음
    // Facade 클래스가 내부적으로 서브 시스템의 객체들까지 직접 생성해서 다룸!
public class FileSystemClient {
    public static void main(String[] args) {
        FileSystemFacade fs = new FileSystemFacade();
        
        // 파일 쓰기
        boolean writeSuccess = fs.writeFile("test.txt", "Hello, Facade Pattern!");
        System.out.println("File write success : " + writeSuccess);

        // 파일 읽기
        String content = fs.readFile("test.txt");
        System.out.println("File content: " + content);
        
        // 파일 삭제
        boolean deleteSuccess = fs.deleteFile("test.txt");
        System.out.println("File delete success: " + deleteSuccess);
    }
}
