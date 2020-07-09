package com.test.spring.core.shape;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

@Data
@Slf4j
public class Triangle extends Shape implements InitializingBean, DisposableBean {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private String type;

    private List<Integer> sideLengths;


    @Override
    // InitializingBean interface method
    public void afterPropertiesSet() {
      log.info(this.getClass().getCanonicalName() + " has been initialized..");
    }

    @Override
    // DisposableBean interface method
    public void destroy() throws Exception {
        log.info(this.getClass().getCanonicalName() + " has been destroyed..");
    }
}
