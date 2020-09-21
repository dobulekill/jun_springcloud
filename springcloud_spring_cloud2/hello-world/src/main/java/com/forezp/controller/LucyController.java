package com.forezp.controller;

import com.forezp.config.ConfigBean;
import com.forezp.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class,User.class})
public class LucyController {

    @Autowired
    private  ConfigBean configBean;

    @Autowired
    private User user;
    @RequestMapping("/lucy")
    public String miya(){
        return configBean.getGreeting()+"-"+configBean.getName()+"-"+configBean.getUuid()+"-"+configBean.getMax();
    }

    @RequestMapping("/user")
    public String user(){
        return user.getName()+"-"+user.getAge()+"dddddd111";
    }

}
