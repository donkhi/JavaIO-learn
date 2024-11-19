package FileManage;

import java.io.File;

public class JavaDel {
    public static void main(String[] args) {
        File file=new File("D:/1JavaIo");
        boolean result=FileRemove(file);
        System.out.println(result);
    }
    public static boolean FileRemove(File file){
        //当文件是一个目录的时候
        if(file.exists()&&file.isDirectory()){
            File[] files=file.listFiles();
            if(files!=null){
                for(File f:files){
                    FileRemove(f);
                }
            }
        }
        boolean deleted = file.delete();
        if (deleted) {
            System.out.println("成功删除: " + file.getAbsolutePath());
        } else {
            System.out.println("删除失败: " + file.getAbsolutePath());
        }
        return deleted;
    }
}
