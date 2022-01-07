package cn.com.soft.hadoopsample.controller;

import cn.com.soft.hadooprpcinterface.service.HelloHadoopRpcService;
import cn.com.soft.hadoopstarter.template.HdfsTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2022/1/6 11:23
 * @Version 1.0
 */
@RestController
@Slf4j
public class HdfsDemoController {

    @Autowired(required = false)
    HdfsTemplate hdfsTemplate;

    @RequestMapping("hdfsDemo")
    public void hdfsDemo(){
        //将一个本地的文件上传到搭建的hadoop集群上面
        hdfsTemplate.copyFileToHDFS(false,false,"H:\\123.txt","/demo/123.txt");
        boolean flag = hdfsTemplate.existDir("/demo",false);
        log.info("是否存在此路径：{}" ,flag);
    }

    @RequestMapping("rpcDemo")
    public void rpcDemo(){

        HelloHadoopRpcService proxy = null;
        try {
            proxy = RPC.getProxy(HelloHadoopRpcService.class, 1L,
                    new InetSocketAddress("localhost", 8848), new Configuration());

            String result = proxy.sayHelloHadoop("尝试一下通过Hadoop的RPC是否调用到远程服务~~");
            log.info("通过远程服务调用的结果：" + result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
