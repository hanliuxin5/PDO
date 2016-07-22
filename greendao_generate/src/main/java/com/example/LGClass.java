package com.example;

/**
 * Created by lychee on 2016/7/22.
 */
public class LGClass {
    public static void main(String[] args) throws Exception {

        LGList list = new LGList();
        list.add(new LG("1", 4));
        list.add(new LG("2", 3));
        list.add(new LG("3", 2));
        list.add(new LG("4", 1));
        System.out.print(list.toString());
    }


}
