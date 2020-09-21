package ai.micro.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by xingyu1 on 16/9/3.
 */
@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "addfailback")
    public String add(Integer a,Integer b){
        ResponseEntity<String> entity = null;
        try {
            entity = restTemplate.getForEntity(new URI("http://SERVICE-PROVIDER/add?a="+a+"&b="+b),String.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //ResponseEntity<String> entity = restTemplate.getForEntity(url,String.class,m);
        return entity.getBody();
    }

    public String addfailback(Integer a,Integer b){
        return "error: a: " + a + ", b: " + b;
    }


}
