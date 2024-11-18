package com.vmware.ensemble.rules.i18n.model;

import com.vmware.ensemble.rules.i18n.service.Task;

public class CustomThreadPool {

    private Worker[] workers;
    private TaskQueue taskQueue;
    private volatile boolean isShutDown;

    public CustomThreadPool(int numOfThread, int capacityOfQueue) {
        this.workers = new Worker[numOfThread];
        this.taskQueue = new TaskQueue(capacityOfQueue);
        this.isShutDown = false;

        for (int i=0; i<numOfThread; i++) {
            workers[i] = new Worker(taskQueue);
            workers[i].start();
        }
    }

    public void submit(Task task) throws InterruptedException {
        if (isShutDown) {
            throw new IllegalArgumentException("ThreadPool is ShutDown");
        }
        taskQueue.put(task);
    }

    public void shutDown() {
        this.isShutDown = true;
        for (Worker worker : workers) {
            worker.stopWorker();
        }
    }

    public boolean awaitTermination(long timeoutMillis) throws InterruptedException {
        long deadLine = System.currentTimeMillis() + timeoutMillis;
        for (Worker worker : workers) {
            long remainingTime = deadLine - System.currentTimeMillis();
            if (remainingTime <= 0) {
                return false;
            }
            worker.join(remainingTime);
        }

        return true;
    }

    public int getActiveTaskCount() {
        return taskQueue.getSize();
    }
}
