package com.test.io;

import java.io.*;

/**
 * IOTest
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/5/17 6:26
 **/
public class IOTest {

    public static void main1(String[] args)  {
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);
            int read = fileReader.read();
            while (read != -1) {
                System.out.print((char)read);
                System.out.print(read);
                read=fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main2(String[] args)  {
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);
            char[] cbuff=new char[5];
            int len;
            while ((len=fileReader.read(cbuff))!=-1) {

                for (int i = 0; i < len; i++) {
                    System.out.print(cbuff[i]);
                }

//                String s = new String(cbuff, 0, len);
//                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main3(String[] args)  {
        FileReader fileReader = null;
        FileWriter fileWriter =null;
        try {
            File file = new File("hello.txt");
            File file1 = new File("D:\\00\\Java\\Java_se_quize\\src\\main\\java" +
                    "\\com\\test\\io\\FileTest.txt");
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file1,true);
            char[] cbuff=new char[5];
            int len;
            while ((len=fileReader.read(cbuff))!=-1) {

                fileWriter.write(cbuff,0,len);
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuff[i]);
//                }

//                String s = new String(cbuff, 0, len);
//                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader!=null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileWriter!=null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main4(String[] args)  {
        FileInputStream fileInputStream =null;
        FileOutputStream fileOutputStream =null;
        try {
            File file = new File("hello.txt");
            File file1 = new File("D:\\00\\Java\\Java_se_quize\\src\\main\\java" +
                    "\\com\\test\\io\\FileTest.txt");

            fileInputStream = new FileInputStream(file);

            byte[] cbuff= new byte[5];
            int len;
            while ((len=fileInputStream.read(cbuff))!=-1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuff[i]);
                }
                System.out.println("");
//                System.out.print(new String(cbuff, 0, len));
//                System.out.println("----");
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuff[i]);
//                }

//                String s = new String(cbuff, 0, len);
//                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream!=null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileOutputStream!=null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

    }

}
