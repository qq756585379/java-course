package com.yang.base.m013;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class UseCopyOnWrite {

    //适合读多写少的情况
    public static void main(String[] args) {

        CopyOnWriteArrayList<String> cwal = new CopyOnWriteArrayList<String>();
        CopyOnWriteArraySet<String> cwas = new CopyOnWriteArraySet<String>();

        cwal.add("a");
    }
}
