package IOStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputSt {
    public static void main(String[] args) {
        OutputStream os = null;
        try {
            File file = new File("D:/1JavaIo/one/two/three/Dun.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            os = new FileOutputStream(file);
            String s="dklfjdlf";
            byte[] b=s.getBytes();
            os.write(b);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
