package com.tic.tac.toe.exceptions;

public class BoadException extends Exception {

    public BoadException(String message) {
        System.out.println("BoardException: " + message);
    }

    public BoadException(String message, Throwable throwable) {
        System.out.println("[BoadException][ " + throwable.getMessage() + " ]");
    }
}
