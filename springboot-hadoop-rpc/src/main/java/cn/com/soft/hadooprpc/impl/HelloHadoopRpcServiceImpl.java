package cn.com.soft.hadooprpc.impl;

import cn.com.soft.hadooprpcinterface.service.HelloHadoopRpcService;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2022/1/7 16:02
 * @Version 1.0
 */

public class HelloHadoopRpcServiceImpl implements HelloHadoopRpcService {

    @Override
    public String sayHelloHadoop(String sayStr) {
        return  "Hi~~,我已经接到你传来的话术：" + sayStr;
    }
    
}
