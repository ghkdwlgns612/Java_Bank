package com.example.SessionAndCache.controller;

import com.example.SessionAndCache.service.SessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;

@RestController
@Slf4j
public class SessionContoroller {
    SessionService sessionService = new SessionService();

    @GetMapping("/write")
    public String SessionWrite(HttpServletRequest request) {
        sessionService.SessionWrite(request);
        return "Write";
    }

    @GetMapping("/read")
    public String SessionRead(HttpServletRequest request) {
        sessionService.SessionRead(request);
        return "read";
    }
}
