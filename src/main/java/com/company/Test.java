package com.company;

import java.util.Arrays;

/**
 * @author : farid
 * @date : 2023/5/8 20:49
 */
public class Test {
    public static void main(String[] args) {
        int[] ids1 = {8, 9, 22, 3};
        int[] ids2 = {2, 22, 6,3,9};

        Arrays.sort(ids1);
        Arrays.sort(ids2);

        if(ids1.length==ids2.length){
            if (Arrays.equals(ids1,ids2)){
                System.out.println("yes");
            }else {
                System.out.println("no1");
            }
        }else {
            System.out.println("no2");
        }
    }
}
