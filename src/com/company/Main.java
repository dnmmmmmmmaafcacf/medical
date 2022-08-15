package com.company;

import java.io.*;

public class Main {

//    public static void main(String[] args) throws Exception {
//        File file = new File("D:\\javasoftware\\idea\\untitled");
////        System.out.println(file.mkdir());//新加文件
//        //       System.out.println(file.delete());  //删除文件
//        String strArray[] = file.list();
//        for (String s : strArray) {
//            System.out.println("/" + s);
//        }
//    }

//    static String path = "D:\\task\\axios.txt";
//    public static void main(String[] args) throws  IOException {
//        String s;
//            try (InputStream input = new FileInputStream(path)){
//              int n;
//                StringBuilder ss = new StringBuilder();
//                while ((n=input.read())!= -1){
//                    ss.append((char)n);
//                }
//                s=ss.toString();
//            }
//            System.out.println(s);
//    }

public static void main(String[] args) throws  IOException{
    FileInputStream input = null;
    FileOutputStream output = null;
    try{
        input = new FileInputStream("D:\\task\\axios.txt");
        output = new FileOutputStream("D:\\task\\test.txt");
        byte[] words = new byte[1024];
        int ren = 0;
        while ((ren=input.read(words))>2){
            output.write(words,0,ren);
        }
    }finally {
        input.close();
        output.close();
    }
}


}
