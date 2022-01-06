package cn.com.soft.hadoopsample.controller;

import cn.com.soft.hadoopstarter.template.HdfsTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author Mourning 16
 * @Date 2022/1/6 11:23
 * @Version 1.0
 */
@RestController
@Slf4j
public class HdfsDemoController {

    @Autowired
    HdfsTemplate hdfsTemplate;

    @RequestMapping("hdfsDemo")
    public void hdfsDemo(){
        //将一个本地的文件上传到搭建的hadoop集群上面
        hdfsTemplate.copyFileToHDFS(false,false,"H:\\123.txt","/demo/123.txt");
        boolean flag = hdfsTemplate.existDir("/demo",false);
        log.info("是否存在此路径：{}" ,flag);
    }

}
