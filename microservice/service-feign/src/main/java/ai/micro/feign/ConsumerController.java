package ai.micro.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xingyu1 on 16/8/27.
 */
@RestController
public class ConsumerController {

    @Autowired
    ComputeClient client;


    @RequestMapping("add")
    public String add() throws URISyntaxException {
        return client.add(1,5).toString();
    }
}
