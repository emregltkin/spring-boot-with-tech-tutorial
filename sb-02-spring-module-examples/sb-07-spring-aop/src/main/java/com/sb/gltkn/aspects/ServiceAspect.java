package com.sb.gltkn.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    //Bu paket altında bulunan tüm class'lardaki createMessage metodundan hemen önce çalışır.
    @Before("execution(* com.sb.gltkn.service.*.createMessage(..))")
    public void beforeCreateMessage(JoinPoint joinPoint){
        System.out.println("\n[createMessage metodundan önce]");
        System.out.println("Yakalanan ilk parametre: " + joinPoint.getArgs()[0]);
        System.out.println("Yakalanan signature: " + joinPoint.getSignature());
    }

    //Bu paket altında bulunan tüm class'lardaki createMessage metodundan hemen sonra çalışır.
    @After("execution(* com.sb.gltkn.service.*.createMessage(..))")
    public void afterCreateMessage(JoinPoint joinPoint){
        System.out.println("\n[createMessage metodundan sonra]");
        System.out.println("Yakalanan ilk parametre: " + joinPoint.getArgs()[0]);
        System.out.println("Yakalanan signature: " + joinPoint.getSignature());
    }
}
