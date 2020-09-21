package ai.micro.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xingyu1 on 16/9/3.
 */
@Component
public class ComputeClientHystrix implements ComputeClient{

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -1111;
    }
}
