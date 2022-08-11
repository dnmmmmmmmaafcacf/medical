package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class shuzu {
    public static void main(String[] args) {
        String c = "c";
        String[] a = new String[]{
                "a",
                "b",
                "c",
                "d",
        };

        for (String b : a){
            if (b==c){
                System.out.println("有");
                //跳过循环
            }else {
                System.out.println("无");
            }
        }
        String ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSSS").format(new Date());
        System.out.println(ft);

        int num = 0;
        int mone = 0;
        for(int i = 0 ;i<=10; i++){
            if (mone==0)
                mone = 1;
            else
                mone *=2;
            num +=mone;
            System.out.println("第"+i+"天"+mone);
        }
        System.out.println(num);
    }


}
