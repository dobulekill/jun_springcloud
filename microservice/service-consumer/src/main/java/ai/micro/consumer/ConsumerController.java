package ai.micro.consumer;

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

//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    ComputeService computeService;


    @RequestMapping("add")
    public String add() {

        return computeService.add(2,5);
        /*
        String url = "http://SERVICE-PROVIDER/add?";
        Map<String,Integer> m = new HashMap<>();
        m.put("a",1);
        m.put("b",2);
        ResponseEntity<String> entity = restTemplate.getForEntity(new URI("http://SERVICE-PROVIDER/add?a=2&b=3"),String.class);
        //ResponseEntity<String> entity = restTemplate.getForEntity(url,String.class,m);
        return entity.getBody();
        */

    }
}
