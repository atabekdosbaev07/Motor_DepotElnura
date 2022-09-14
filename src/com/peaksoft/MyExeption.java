package com.peaksoft;

public class MyExeption extends Exception {

    public MyExeption() {
    }

    public MyExeption(String massage){
        super(massage);
    }

    public MyExeption(Throwable cause){
        super(cause);
    }
}
