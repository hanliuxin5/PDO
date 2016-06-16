package com.pdc.lychee.planetdefenseoffice.module;

/**
 * Created by lychee on 2016/6/16.
 */
public enum MainFragments {
    EARTH(0, "EARTH"), MARS(1, "MARS"), DEEPSPACE(2, "DEEPSPACE");
    private int index;
    private String tag;

    MainFragments(int index, String tag) {
        this.index = index;
        this.tag = tag;
    }

    public int getPosition() {
        return index;
    }

    public String getTag() {
        return tag;
    }

}
