package com.engine;

import com.engine.render.Window;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

       Window window = new Window(500,500,"My window");
       window.create();

    }
}