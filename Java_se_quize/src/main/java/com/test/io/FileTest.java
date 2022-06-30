package com.test.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * FileTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/17 3:48
 **/
public class FileTest {

    public static void main(String[] args) throws IOException {
//        File file = new File("D:\\00\\Java\\" +
//                "Java_se_quize\\src\\main\\java\\com\\test\\io\\FileTest.java");
//        System.out.println("file.getPath() = " + file.getPath());
//        System.out.println("file.getParent() = " + file.getParent());

        //修改文件名
        File file1 = new File("D:\\Program Files\\JiJiDown\\Download\\Java尚硅谷");
        File file2 = new File("D:\\tmp\\test");

        FileTest.renameFileForEveryFileInDir(file1);

    }

    //更改目录下所有文件的文件名
    public static void renameFileForEveryFileInDir(File file1) {

        File[] files = file1.listFiles();
        try {
            for (File file : files) {
                if (file.isDirectory()) {
                    FileTest.renameFileForEveryFileInDir(file);
                } else {
                    String name = file.getName();
                    //System.out.println("name = " + name + ":" + file.isHidden() + "::" + file.isDirectory());

                    //用. 分割,需要转义, \.
                    String name1 = name.replace("尚硅谷Java零基础入门教程（含百道Java真题，2万多行Java代码实战） - ", "");
                    String name2 = name1.replace("尚硅谷", "");
                    //String[] split = name.split(".");
                    //文件名未更改
                    if (name2.equals(name)) {
                        continue;
                    }
                    //name = split[0];
                    String parent = file.getParent();
                    boolean b = file.renameTo(new File(parent + "\\" + name2));
                    if (b)
                        System.out.println(name + "::" + "修改文件名成功");

                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
