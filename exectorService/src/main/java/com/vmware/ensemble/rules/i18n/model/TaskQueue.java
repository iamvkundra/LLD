package com.vmware.ensemble.rules.i18n.model;

import com.vmware.ensemble.rules.i18n.service.Task;

public class TaskQueue {

    private Task[] tasks;
    private int capacity;
    private int size;
    private int head;
    private int tail;

    public TaskQueue(int capacity) {
        this.tasks = new Task[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.tail = 0;
        this.head = 0;
    }

    public synchronized void put(Task task) throws InterruptedException {
        while (capacity == size) {
            wait();
        }
        tasks[tail] = task;
        tail = (tail + 1)%capacity;
        size++;
        notifyAll();
    }

    public synchronized Task take() throws InterruptedException {
        while (size == 0) {
            wait();
        }

        Task task = tasks[head];
        tasks[head] = null;
        head = (head + 1)%capacity;
        size--;

        notifyAll();
        return task;
    }

    public synchronized int getSize() {
        return this.size;
    }

}
