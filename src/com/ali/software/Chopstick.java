package com.ali.software;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

    private final int id;
    private final Lock lock;

    public Chopstick(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean pickUp(Philosopher philosopher, State state) throws InterruptedException {

        //This is where we will simulate deadlock
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println(philosopher + " picked up " + state.toString() + " " + this);
            return true;
        }
        return false;
    }

    public void putDown(Philosopher philosopher) {

        lock.unlock();
        System.out.println(philosopher + " put down " + this);
    }

    @Override
    public String toString() {
        return "Chopstick{ id=" + id + "}";
    }
}
