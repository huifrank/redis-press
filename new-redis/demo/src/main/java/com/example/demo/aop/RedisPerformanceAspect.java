package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Slf4j
@Service
public class RedisPerformanceAspect {


    @Pointcut(value =" execution(* com.example.demo.service.impl.RedisServiceImpl.* (..) )" )
    public void methodPointCut(){}

    @Around(value = "methodPointCut()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        String name = proceedingJoinPoint.getSignature().getName();
        StopWatch watch = new StopWatch();
        watch.start();

        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
            watch.stop();
            log.info("method:{} spend : {}",name,watch.getTime());
        } catch (Throwable throwable) {
            //这个地方会把方法执行的异常吃掉，不过无所谓了
            throwable.printStackTrace();
        }
        return proceed;
    }
}
