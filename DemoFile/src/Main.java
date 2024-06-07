import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        File myfile = new File("./src/data.txt");
        if(myfile.exists()){
            if(myfile.canWrite()){
                System.out.println("File can write");
                try {
                    FileWriter fw = new FileWriter("./src/data.txt");
                    String content = "Day la noi dung ghi vao file";
                    fw.write(content);
                    
                    fw.close();
                }
                catch(IOException e){
                    throw new IOException(e);
                }
            }
            else {
                System.out.println("File can't write");
            }
        }
        else {
            System.out.println("File does not exist");
        }
    }
}