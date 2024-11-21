package FileRW;

import CreatenewFile.CreateNewFile;
import java.io.*;

public class FileW {
    public static void main(String[] args) {
        File file1 = new File("D:/1JavaIo/one/two/three/Dun.txt");
        File file2 = new File("D:/1JavaIo/one/two/three/DunD.txt");

        // 检查文件并创建文件
        CreateNewFile.createFileIfNotExists(file1.getPath());
        CreateNewFile.createFileIfNotExists(file2.getPath());

        // 使用 try-with-resources 自动管理资源
        try (
                FileReader reader = new FileReader(file1);
                FileWriter writer = new FileWriter(file2)
        ) {
            char[] buf = new char[1024];
            int len;

            // 将文件内容从 file1 复制到 file2
            while ((len = reader.read(buf)) != -1) {
                writer.write(buf, 0, len);
            }
            // 确保写入完成
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
