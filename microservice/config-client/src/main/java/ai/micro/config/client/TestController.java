package ai.micro.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xingyu1 on 16/8/27.
 */
@RefreshScope
@RestController
public class TestController {


    @Value("${application.name}")
    private String name;

    @RequestMapping("test")
    public String test(){
        //http://localhost:9091/test
        return name;
    }
}
