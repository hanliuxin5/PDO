package com.example;

import java.util.ArrayList;

/**
 * Created by lychee on 2016/7/22.
 */
public class LGList extends ArrayList {
    @Override
    public String toString() {
        StringBuilder json = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            LG lg = (LG) get(i);
            json.append(lg.getAge() + lg.getScore());
        }
        return json.toString();
    }
}
