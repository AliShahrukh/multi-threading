package com.ali.software.student;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

    private final int id;
    private final Lock lock;

    public Book(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public void read(Student student) throws InterruptedException {

        /*if (lock.tryLock(10, TimeUnit.SECONDS)) {
            System.out.println(student + " starts reading " + this);
            Thread.sleep(2000);
            lock.unlock();
            System.out.println(student + " completes reading " + this);
        }*/

        lock.lock();
        System.out.println(student + " starts reading " + this);
        Thread.sleep(2000);
        lock.unlock();
        System.out.println(student + " completes reading " + this);
    }

    @Override
    public String toString() {
        return "Book { id=" + id + '}';
    }
}
