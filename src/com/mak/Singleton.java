package com.mak;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

    static {
        System.out.println("Singleton init");
    }

    private Singleton() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    static private class SingletonHelper{
        static {
            System.out.println("SingletonHelper init");
        }
        private static final Singleton INSTANCE = new Singleton();
    }


    public static Singleton get() {
        return SingletonHelper.INSTANCE;
    }

    protected Object readResolve() {
        return get();
    }

}
