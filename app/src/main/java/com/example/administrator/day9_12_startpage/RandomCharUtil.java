package com.example.administrator.day9_12_startpage;

import java.util.Random;

/**
 * Created by Administrator on 2017/9/12 0012.
 */

public class RandomCharUtil {
    public static final String numberChar = "0123456789";
    public static String getRandomNumberChar(int n) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            sb.append( numberChar.charAt( random.nextInt( numberChar.length() ) ) );
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int k = 3;
        int p = 6;
        System.out.println("------------------------------------------------数字字符---------");
        for(int i = 0; i < k; i++) {
            System.out.println("getRandomNumberChar(): " + i + " -------");
            System.out.println(getRandomNumberChar(p));
        }
    }
}
