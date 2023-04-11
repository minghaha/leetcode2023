package com.tuling.spring;

import lombok.Data;

/**
 * Created on 2023/4/10.
 *
 * @author lichuanming
 */
@Data
public class BeanDefinition {
    Class type;
    String scpoe;
    boolean isLazy;
}
