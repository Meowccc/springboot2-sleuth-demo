package com.example.springboot2sleuth.controller;

import com.example.springboot2sleuth.service.SleuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meow
 */
@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class SleuthController {

    private final SleuthService sleuthService;

    @GetMapping("sleuth")
    public String hello() {
        log.info("controller log ");
        sleuthService.asyncHello();
        sleuthService.hello();
        sleuthService.runAsyncWithFuture();
        return "sleuth";
    }
}
