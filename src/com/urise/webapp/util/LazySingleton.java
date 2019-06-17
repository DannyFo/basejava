package com.urise.webapp.util;

public class LazySingleton {


    private LazySingleton() {
    }

    private static class LazySingletonHolder{
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
    public static LazySingleton getInstance() {
        return LazySingletonHolder.INSTANCE;
//        if(INSTANCE==null){
//            synchronized (LazySingleton.class) {
//                if(INSTANCE==null) {
//                    INSTANCE = new LazySingleton();
//                }
//            }
//        }
//        return INSTANCE;
    }
}
