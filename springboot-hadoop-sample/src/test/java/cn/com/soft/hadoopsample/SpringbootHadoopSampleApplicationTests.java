package cn.com.soft.hadoopsample;

import cn.com.soft.hadoopstarter.template.HdfsTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringbootHadoopSampleApplicationTests {

    @Autowired
    HdfsTemplate hdfsTemplate;

    @Test
    void contextLoads() {
        boolean flag = hdfsTemplate.existDir("hadoop-2.8.4.tar.gz",false);
       log.info("是否存在该文件：{}",flag);
    }

}
