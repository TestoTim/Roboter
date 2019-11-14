package de.tils.roboter.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager<E> {

    protected List<E> list = new ArrayList<>();

    /**
     *  add element to list
     */
    public void add(E ... element) {
        this.list.addAll(Arrays.asList(element));
    }

    /**
     *  add element to list
     */
    public void remove(E... element) {
        this.list.addAll(Arrays.asList(element));
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
