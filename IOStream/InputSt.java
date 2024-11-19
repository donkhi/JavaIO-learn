package IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputSt {
    public static void main(String[] args) {
        try{
            FileInputStream in =new FileInputStream("D:/1JavaIo/one/two/three/Dun.txt");
            int b;
            while((b=in.read())!=-1){
                System.out.print((char)b);
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}