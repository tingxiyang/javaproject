package com.zhl.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

/**
 * Created by zhl on 18/5/4 下午4:27.
 * 切面类
 *
 * @Aspect： 告诉Spring当前类是一个切面类，而不是其它普通类
 */
@Aspect
public class LogAspects {

    //抽取公共的切入点
    //1. 本类引用
    //2. 其它的切面引用
    @Pointcut("execution(* com.zhl.aop.MathCalculator.*(..))")
    public void pointCut(){}

    //JointPoint 一定要出现在参数表的第一位
    //@Before 在目标方法之前切入； 切入点表达式(指定在哪个方法切入)
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("方法名"+joinPoint.getSignature().getName()+"除法运行。。。参数列表是：{"+ Arrays.asList(args)+"}");
    }

    @After("com.zhl.aop.LogAspects.pointCut()")//如果外面的切面类的化
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() +"除法结束。。。");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result){

        System.out.println("除法正常返回。。。@AfterReturning运行结果：{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception){
        System.out.println("触发异常。。。异常信息：{"+exception+"}");
    }
}
