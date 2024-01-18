package com.example.springboot2sleuth.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * @author meow
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SleuthServiceImpl implements SleuthService {

    @Resource
    private Executor asyncServiceExecutor;

    public void hello() {
        log.info("service log ");

    }

    @SneakyThrows
    @Async("asyncServiceExecutor")
    public void asyncHello() {
        log.info("start async service log ");
        Thread.sleep(3000);
        log.info("end async service log ");
    }

    @Override
    public void runAsyncWithFuture() {
        log.info("start async service log ");
        CompletableFuture.runAsync(() -> {
            log.info("run async with CompletableFuture. ");
        });

        CompletableFuture.runAsync(() -> {
            log.info("run async with CompletableFuture and specified executor. ");
        }, asyncServiceExecutor);
    }
}
