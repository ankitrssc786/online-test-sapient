package com.sapient.test.football_game_league.log.aspect;

import com.sapient.test.football_game_league.log.annotation.Trace;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/***
 * This class is a spring aspect, which defines a point cut All public methods which are annotated
 */
@Slf4j
@Component
@Aspect
public class LoggingAspect {

  /***
   * @param joinPoint
   * @param trace
   * @return
   * @throws Throwable This method wraps all methods that are annotated.
   */
  @Around("@annotation(trace)")
  public Object log(ProceedingJoinPoint joinPoint, Trace trace) throws Throwable {
    long startTime = 0;
    try {
      log.info(
          "[" + trace.type() + "] Execution started : " + joinPoint.getSignature().toShortString());
      startTime = System.currentTimeMillis();
      return joinPoint.proceed();
    } catch (Exception e) {
      log.info("[" + trace.type() + "] Exception occurred while executing "
          + joinPoint.getSignature().toShortString() + ".Rethrowing exception " + e.getMessage());
      throw e;
    } finally {
      log.info(
          "[" + trace.type() + "] Execution completed : " + joinPoint.getSignature().toShortString()
              + " , ExecutionTime(in millis) :" + (System.currentTimeMillis() - startTime));
    }
  }


}
