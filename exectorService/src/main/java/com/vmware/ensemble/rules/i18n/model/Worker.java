package com.vmware.ensemble.rules.i18n.model;

import com.vmware.ensemble.rules.i18n.service.Task;

public class Worker extends Thread {

    private TaskQueue taskQueue;
    private boolean isRunning;

    public Worker(TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
        this.isRunning = true;
    }
    @Override
    public void run() {
        while (isRunning) {
            try {
                Task task = taskQueue.take();
                task.execute();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stopWorker() {
        this.isRunning = false;
        interrupt();
    }
}
