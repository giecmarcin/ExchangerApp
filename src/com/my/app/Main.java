package com.my.app;

import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {
        Bucket b1 = new Bucket(0, false);
        Bucket b2=new Bucket(1, false);
        Bucket b3 = new Bucket(2, false);
        Bucket b4 = new Bucket(3, false);
        Bucket b5 = new Bucket(4, true);

        Exchanger<Bucket> e1 = new Exchanger<Bucket>();
        Exchanger<Bucket> e2 = new Exchanger<Bucket>();
        Exchanger<Bucket> e3 = new Exchanger<Bucket>();
        Exchanger<Bucket> e4 = new Exchanger<Bucket>();

        Fireman f1 = new Fireman(0, null, e1, b1);
        Fireman f2 = new Fireman(1,   e1, e2, b2);
        Fireman f3= new Fireman(2,   e2, e3, b3);
        Fireman f4 = new Fireman(3,   e3, e4, b4);
        Fireman f5 = new Fireman(4, e4, null, b5);

        new Thread(f1).start();
        new Thread(f2).start();
        new Thread(f3).start();
        new Thread(f4).start();
        new Thread(f5).start();
    }
}
