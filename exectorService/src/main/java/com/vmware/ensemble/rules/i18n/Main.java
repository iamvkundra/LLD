package com.vmware.ensemble.rules.i18n;

import com.vmware.ensemble.rules.i18n.model.CustomThreadPool;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CustomThreadPool customThreadPool = new CustomThreadPool(20, 100);
        for (int i=1; i<=200; i++) {
            final int taskId = i;
            customThreadPool.submit(() -> {
                System.out.println("Executing Task: "+taskId +" on Thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        Thread.sleep(3000);
        customThreadPool.shutDown();

        boolean completed = customThreadPool.awaitTermination(5000);
        System.out.println("All tasks completed: "+completed);
    }
}