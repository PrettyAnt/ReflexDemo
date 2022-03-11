package com.part2;

import com.part2.imp.Subject;

/**
 * 反射应用-动态代理
 */
public class ProxyHand {

    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        DynamicProxy dynamicProxy = new DynamicProxy();
        Subject proxyInstance = (Subject) dynamicProxy.newProxyInstance(buyer);
        proxyInstance.buy(666);
    }


}
