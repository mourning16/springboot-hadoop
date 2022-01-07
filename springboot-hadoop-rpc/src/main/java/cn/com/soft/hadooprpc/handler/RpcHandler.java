package cn.com.soft.hadooprpc.handler;

import cn.com.soft.hadooprpc.impl.HelloHadoopRpcServiceImpl;
import cn.com.soft.hadooprpcinterface.service.HelloHadoopRpcService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;
import org.apache.hadoop.ipc.RPC.Builder;
import java.io.IOException;

/**
 * @Description TODO 基于Hadoop的Rpc提供远程服务
 * @Author Mourning 16
 * @Date 2022/1/7 16:11
 * @Version 1.0
 */

public class RpcHandler {

    public static void main(String[] args) {

        Builder builder = new RPC.Builder(new Configuration());
        builder.setBindAddress("localhost").setPort(8848).setProtocol(HelloHadoopRpcService.class)
                .setInstance(new HelloHadoopRpcServiceImpl());

        Server server = null;
        try {
            server = builder.build();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
