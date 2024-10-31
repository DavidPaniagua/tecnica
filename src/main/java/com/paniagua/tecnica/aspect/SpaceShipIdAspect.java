package com.paniagua.tecnica.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpaceShipIdAspect {
    @Before("execution(* com.paniagua.tecnica.application.rest.*.*(..)) && args(id, ..)")
    public void logIfNegativeId(JoinPoint joinPoint, int id) {
        if (id < 0) {
            System.out.println("Warning: It was requested a spaceship with a negative ID: " + id);
        }
    }
}