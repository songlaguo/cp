package org.bc.saas.common.vo;

/**
 * AUTHOR: warner von
 * DATE: 2018-04-27
 */
public interface Param<T> {

    T getTrueShape();

    /**
     * 目的是对提供对param到entity转换过程的封装。
     * @return
     */
    boolean transTrueShape();
}
