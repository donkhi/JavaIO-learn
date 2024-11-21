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
            //指定写入模式true为追加 false为覆盖
            os = new FileOutputStream(file,true);
            String s="dklfjdlf";
            byte[] b=s.getBytes();
            os.write(b);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
