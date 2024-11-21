package CreatenewFile;

import java.io.File;
import java.io.IOException;
//省略了try catch
public class CreateNewFile {
    // 定义一个方法，用于判断文件是否存在并在需要时创建文件
    public static void createFileIfNotExists(String filePath) {
        File file = new File(filePath);
        try {
            // 检查文件是否存在
            if (!file.exists()) {
                // 创建文件
                if (file.createNewFile()) {
                    System.out.println("文件创建成功: " + filePath);
                } else {
                    System.out.println("文件创建失败: " + filePath);
                }
            } else {
                System.out.println("文件已存在: " + filePath);
            }
        } catch (IOException e) {
            System.out.println("发生异常: " + e.getMessage());
        }
    }
}

