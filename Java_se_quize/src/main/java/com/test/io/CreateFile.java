package com.test.io;

import java.io.File;
import java.io.IOException;

/**
 * CreateFile
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/17 5:12
 **/
public class CreateFile {

    private static Long fileSize = 0l;

    public static void main(String[] args) throws IOException {
//        File file = new File("hello.txt");
//        if (!file.exists()) {
//            file.createNewFile();
//            System.out.println("文件創建成功");
//        }else {
//            file.delete();
//            System.out.println("文件刪除成功");
//        }

        File file1 = new File("hello.txt");
        file1.createNewFile();
        System.out.println(file1.getAbsolutePath());
        //CreateFile.deleteDir(file1);

    }

    public static void listForFile(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                listForFile(file1);
            }else {
                System.out.println(file1.getName());
            }
        }
    }

    public static long listForFileSize(File file){
        File[] files = file.listFiles();

        for (File file1 : files) {
            if (file1.isDirectory()) {
                listForFileSize(file1);
            }else {
                fileSize +=file1.length();
                System.out.println(file1.getName());
            }
        }
        //System.out.println("目錄大小為:"+fileSize);
        return fileSize;
    }

    public static void deleteDir(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                listForFileSize(file1);
            }else {
                file1.delete();
            }
        }
        file.delete();
    }

}
