package com.example.springboot2sleuth.service;

/**
 * @author meow
 */
public interface SleuthService {

    void hello();
    void asyncHello();

    void runAsyncWithFuture();
}
