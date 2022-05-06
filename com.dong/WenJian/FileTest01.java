package WenJian;

import ThreadPool.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest01 {
    public static void main(String[] args) {
        File file = new File("F:\\File\\Test\\a.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
    }
}

class Test02 {
    public static void main(String[] args) throws IOException {
        // File file=new File("F:\\File\\Test\\a.txt");
        File file = new File("F:\\File\\Test\\C");
        if (!file.exists()) {
            file.mkdirs();
        }
        String[] list = file.list();
        File[] files = file.listFiles();
        System.out.println(file.delete());
    }
}

class Test04 {
    public static void main(String[] args) {
        // 1. 目录搜索，无法判断多少级目录，所以使用递归，遍历所有目录。
        // 2. 遍历目录时，获取的子文件，通过文件名称，判断是否符合条件。
        File file = new File("F:\\File\\Test\\C");
        findFiles(file);
    }

    public static void findFiles(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    if (files[i].getName().endsWith(".txt")) {
                        System.out.println(files[i].getAbsolutePath());
                    }
                } else {
                    findFiles(files[i]);
                }

            }
        }
    }
}

class Test05 {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\File\\Test\\C.txt");
        FileOutputStream fileOutputStream=new FileOutputStream(file,true);
         // 写出单个字节数据
        fileOutputStream.write(97);
        fileOutputStream.write(98);
        fileOutputStream.write(99);
        // 关闭流,释放资源
        fileOutputStream.close();
    }
}
