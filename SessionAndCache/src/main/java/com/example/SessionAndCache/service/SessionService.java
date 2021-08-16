package com.example.SessionAndCache.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

@Service
@Slf4j
public class SessionService {
    public void SessionWrite(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("name","jihuhwan");

    }

    public void SessionRead(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        Object name = httpSession.getAttribute("name");
        log.info("name = {}", name.toString());
    }
}
