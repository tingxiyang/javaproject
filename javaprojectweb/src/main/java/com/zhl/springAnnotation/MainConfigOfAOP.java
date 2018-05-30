package com.zhl.springAnnotation;

import com.zhl.aop.LogAspects;
import com.zhl.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by zhl on 18/5/4 上午10:29.
 * AOP: 【动态代理】
 *     指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 *  1、导入aop模块； spring aop:  spring-aspects
 *  2、定义一个业务逻辑类(MathCalculator);在业务逻辑运行时将日志进行打印(方法前，方法运行前后)
 *  3、定义一个日志切面类(LogAspects): 切面类里面的方法需要动态感知MathCalculator.div运行到
 *      通知方法：
 *          前置通知(@Before)：logStart:在目标方法(div)运行之前运行
 *          后置通知(@After)：logEnd：在目标方法(div)运行结束之后运行(无论方法正常结束，异常结束都会调入)
 *          返回通知(@AfterReturning)：logReturn: 在目标方法(div)正常返回之后运行
 *          异常通知(@AfterThrowing)：logException: 在目标方法(div)运行出现异常之后运行
 *          环绕通知(@Around)：动态代理，手动推进目标方法运行(joinPoint.proceed())
 *  4、给切面类的目标方法标注何时何地运行(通知注解)
 *  5、将切面类和业务逻辑类(目标方法所在类)都加入到容器中
 *  6、必须告诉Spring哪个类是切面类(给切面类上加个注解@Aspect )
 *  【7】、给配置类中加@EnableAspectJAutoProxy [开启基于注解的aop模式]
 *         在spring中很多的@EnableXXX;
 *  三步：
 *      1）：将业务逻辑组件和切面类都加入到容器中；告诉Spring哪个是切面类(@Aspect)
 *      2) ：在切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行(切入点表达式)
 *      3）：开启基于注解的aop模式；@EnableAspectJAutoProxy
 *
 *
 * AOP原理：【看给容器中注册了什么组件，这个组件什么时候工作，工作时的功能是什么】
 *  @EnableAspectJAutoProxy
 *  1、@EnableAspectJAutoProxy是什么？
 *      @Import({AspectJAutoProxyRegistrar.class})：给容器中导入AspectJAutoProxyRegistrar
 *      利用AspectJAutoProxyRegistrar自定义给容器中注册bean;
 *      internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 *      给容器中注册一个AnnotationAwareAspectJAutoProxyCreator；(自动代理创建器)
 *  2、AnnotationAwareAspectJAutoProxyCreator：
 *      AnnotationAwareAspectJAutoProxyCreator
 *          -> AspectJAwareAdvisorAutoProxyCreator
 *              ->AbstractAdvisorAutoProxyCreator
 *                  ->AbstractAutoProxyCreator
 *                          implements SmartInstantiationAwareBeanPostProcessor(BeanPostProcessor后置处理器), BeanFactoryAware
 *                      ->ProxyProcessorSupport
 *                  关注后置处理器(在bean初始化前后做事情)、自动装配BeanFactory
 *
 *  AbstractAutoProxyCreator.setBeanFactory()
 *  AbstractAutoProxyCreator.有后置处理器的逻辑
 *
 *  AbstractAdvisorAutoProxyCreator.setBeanFactory() ->> initBeanFactory()
 *  AspectJAwareAdvisorAutoProxyCreator
 *  AnnotationAwareAspectJAutoProxyCreator.initBeanFactory()
 *
 *
 *  流程：
 *      1）、传入配置类，创建IOC容器
 *      2）、注册配置类，调用AbstractApplicationContext.refresh();刷新容器
 *      3）、this.registerBeanPostProcessors(beanFactory);注册bean的后置处理器来方便拦截bean的创建
 *          1.先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor {String[] postProcessorNames =
 *                                                      beanFactory.getBeanNamesForType(BeanPostProcessor.class, true, false);}
 *          2.给容器中加别的BeanPostProcessor
 *          3.优先注册实现了PriorityOrdered接口的BeanPostProcessor;->First register the BeanPostProcessors that implement     PriorityOrdered
 *          4.再给容器中注册实现了Ordered接口的BeanPostProcessor;->
 *          5.注册没实现优先级接口的BeanPostProcessor
 *          6.注册BeanPostProcessor, 实际上就是创建BeanPostProcessor对象，保存在容器中；
 *              创建internalAutoProxyCreator的BeanPostProcessor[AnnotationAwareAspectJAutoProxyCreator]
 *              在（AbstractAutowireCapableBeanFactory）里实现以下：
 *              1)、创建Bean的实例
 *              2)、populateBean: 给bean的各种属性赋值
 *              3)、initializeBean: 初始化bean;
 *                  1)、invokeAwareMethods(): 处理Aware接口的方法回调 -> AbstractAutoProxyCreator.setBeanFactory()
 *                  2)、applyBeanPostProcessorsBeforeInitialization():应用后置处理器的postProcessBeforeInitialization()
 *                  3)、invokeInitMethods();执行自定义的初始化方法
 *                  4)、applyBeanPostProcessorsAfterInitialization():执行应用后置处理器的postProcessAfterInitialization()
 *
 *              4)、BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator)创建成功 -> AspectJAdvisorBuilder
 *          7. 把BeanPostProcessor注册到BeanFactory中；
 *              AbstractBeanFactory类中的addBeanPostProcessor方法:
 *              beanFactory.addBeanPostProcessor(postProcessor)
 *
 *   注：
 *      关于优先级：
 *          for(int var10 = 0; var10 < var9; ++var10) {
                ppName = var8[var10];
                if (beanFactory.isTypeMatch(ppName, PriorityOrdered.class)) {//PriorityOrdered extends Order
                    pp = (BeanPostProcessor)beanFactory.getBean(ppName, BeanPostProcessor.class);
                    priorityOrderedPostProcessors.add(pp);
                    if (pp instanceof MergedBeanDefinitionPostProcessor) {
                        internalPostProcessors.add(pp);
                    }
                    } else if (beanFactory.isTypeMatch(ppName, Ordered.class)) {
                        orderedPostProcessorNames.add(ppName);
                    } else {
                        nonOrderedPostProcessorNames.add(ppName);
                }
            }
 *
 *
 *  ==========以上是创建和注册AnnotationAwareAspectJAutoProxyCreator的过程=========
 *              AnnotationAwareAspectJAutoProxyCreator =》 InstantiationAwareBeanPostProcessor类型的后置处理器
 *      4)、finishBeanFactoryInitialization(beanFactory)；完成beanFactory的初始化工作；创建剩下的单实例bean
 *          1.遍历获取容器中的所有bean, 依次创建对象getBean(beanName)；
 *              getBean -> doGetBean() -> getSingleton()
 *          2.创建bean
 *              【AnnotationAwareAspectJAutoProxyCreator在所有bean创建之前会有一个拦截，InstantiationAwareBeanPostProcessor，
 *                 会调用postProcessBeforeInstantiation()方法】
 *              1). 先从缓存中获取当前bean,如果能获取到，说明当前bean是之前被创建过的，直接使用；否则再创建；（spring利用这个机制保证单实例被创建一次）
 *                  只要创建好的bean就会被缓存起来
 *              2). createBean();创建bean； #AnnotationAwareAspectJAutoProxyCreator会在任何bean创建之前尝试返回bean
 *                      【BeanPostProcessor实在Bean对象创建完成初始化前后调用的】
 *                      【InstantiationAwareBeanPostProcessor是在创建Bean实例之前先尝试用后置处理器返回对象】
 *
 *                      （Give BeanPostProcessor a chance to return a proxy instead of the target bean instance）
 *                  1). this.resolveBeforeInstantiation(beanName, mbdToUse); 解析BeforeInstantiation
 *                      希望后置处理器在此能返回一个代理对象;如果能使用代理对象就使用，如果不能就继续...
 *                      1). 后置处理器先尝试返回对象
 *                          if (targetType != null) {
                                bean = this.applyBeanPostProcessorsBeforeInstantiation(targetType, beanName);
                                    拿到所有后续处理器，如果是InstantiationAwareBeanPostProcessor；
                                        就执行postProcessBeforeInstantiation()
 *
                                if (bean != null) {
                                    bean = this.applyBeanPostProcessorsAfterInitialization(bean, beanName);
                                }
 *
 *                  2). this.doCreateBean(beanName, mbdToUse, args);真正的去创建一个bean实例；和上面的3.6流程一样
 *
 *
 *      AnnotationAwareAspectJAutoProxyCreator[InstantiationAwareBeanPostProcessor] 的作用：
 *      1). 每一个bean创建之前，调用postProcessBeforeInstantiation
 *           以MathCalculator 和LogAspects的创建为列：
 *           1). 判断当前bean是否在if(this.advisedBeans.containsKey(cacheKey))中(保存了所有需要增强的bean)
 *           2). 判断当前bean是否基础类型的Advice, Pointcut, Advisor,AopInfrastructureBean接口下的，
 *           或者是this.aspectJAdvisorFactory.isAspect(beanClass)是否为切面(@Aspect)；如何判断是否为切面:
 *              public boolean isAspect(Class<?> clazz) {
                    return this.hasAspectAnnotation(clazz) && !this.compiledByAjc(clazz);
                }
 *
 *              private boolean hasAspectAnnotation(Class<?> clazz) {
 *                  return AnnotationUtils.findAnnotation(clazz, Aspect.class) != null;
 *              }
 *            3). 是否需要跳过
 *                  1). 获取候选的增强器(切面里面的通知方法)[List<Advisor> candidateAdvisors = this.findCandidateAdvisors();]
 *                      每一个封装的通知方法的增强器是InstantiationModelAwarePointcutAdvisor类型；
 *                      判断每一个增强器是否是AspectJPointcutAdvisor类型的，返回true
 *                  2). 永远返回false,跳过。
 *       2). 创建对象
 *          postProcessAfterInstantiation();
 *              return this.wrapIfNecessary(bean, beanName, cacheKey); 包装，如果需要的情况下；
 *             1). 获取当前bean的所有增强器(通知方法) Object[] specificInterceptors
 *                  1、找到候选的所有的增强器(找哪些通知方法是需要切入当前bean方法的)
 *                  2、获取到能在bean使用的增强器
 *                  3、给增强器排序
 *             2). 保存当前bean在adviseBeans中
 *             3). 如果当前bean需要增强，创建当前bean的代理对象；
 *                  1、获取所有增强器(通知方法)
 *                  2、保存到proxyFactory
 *                  3、创建代理对象： Spring自动决定
 *                      JdkDynamicAopProxy(config);jdk动态代理；
 *                      ObjenesisCglibAopProxy(config);cglib的动态代理
 *
 *            4). 给容器中返回当前组件使用cglib增强了的代理对象
 *            5). 以后容器中获取到的就是这个组件的代理对象，执行目标方法，代理对象就会执行通知方法的流程；
 *
 *       3). 目标方法执行
 *             容器中保存了组件的代理对象(cglib增强后的对象)， 这个对象里面保存了详细信息(比如增强器，目标对象，xxx);
 *             1)、 CglibAopProxy.intercept();拦截目标方法的执行
 *
 *
 *
 *
 *
 */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    //业务逻辑类加入到容器中
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }

    //切面类加入到容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}


















