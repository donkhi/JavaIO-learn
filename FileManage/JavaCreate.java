package FileManage;

import java.io.File;

public class JavaCreate {
    public static void main(String[] args) {
        File file= new File("D:/1JavaIo/one/two/three");
        if(!file.exists()){
            file.mkdirs();
            System.out.println("成功创建" +file.getPath());

        }else{
            System.out.println("文件已存在"+file.getAbsolutePath());
            File[] files = file.listFiles();
            for(File f:files){
                System.out.println(f.getName());
            }
            String[] s=file.list();
            for(int i=0;i<s.length;i++){
                System.out.println(s[i]);
            }
        }
    }
}
