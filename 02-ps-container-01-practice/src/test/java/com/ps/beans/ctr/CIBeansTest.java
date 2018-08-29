package com.ps.beans.ctr;

import com.ps.beans.SimpleBeanImpl;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by iuliana.cosmina on 3/26/16.
 */
public class CIBeansTest {
    private Logger logger = LoggerFactory.getLogger(CIBeansTest.class);

    @Test
    public void testConfig() {
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/ctr/sample-config-01.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/ctr/sample-config-02.xml");

        logger.info(" --- All beans in context --- ");
        for(String beanName :  ctx.getBeanDefinitionNames()) {
            logger.info("Bean " + beanName + " of type " + ctx.getBean(beanName).getClass().getSimpleName());
        }

        ComplexBeanImpl complexBean0 = (ComplexBeanImpl) ctx.getBean("complexBean0");
        ComplexBeanImpl complexBean1 = (ComplexBeanImpl) ctx.getBean("complexBean1");
        ComplexBean2Impl complexBean2 = (ComplexBean2Impl) ctx.getBean("complexBean2");

        SimpleBeanImpl simpleBean0 = (SimpleBeanImpl) ctx.getBean("simpleBean0");
        SimpleBeanImpl simpleBean1 = (SimpleBeanImpl) ctx.getBean("simpleBean1");

        Assert.assertEquals(complexBean0.getSimpleBean(), simpleBean0);

        Assert.assertEquals(complexBean1.getSimpleBean(), simpleBean0);
        Assert.assertEquals(complexBean1.isComplex(), true);

        Assert.assertEquals(complexBean2.getSimpleBean1(), simpleBean0);
        Assert.assertEquals(complexBean2.getSimpleBean2(), simpleBean1);
    }
}
