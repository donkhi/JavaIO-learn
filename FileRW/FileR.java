package FileRW;

import java.io.FileReader;
import java.io.IOException;

public class FileR {
    public static void main(String[] args) {
        try{
            FileReader reader=new FileReader("D:/1JavaIO/one/two/three/Dun.txt");
            int content;
            while((content=reader.read())!=-1){
                System.out.print((char)content);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    }