# Security-jwt

### 快速使用

#####1. 导入jar包security-jwt可自定义版本
```
<dependency>
    <groupId>com.murphy</groupId>
	<artifactId>security-jwt</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
```
#####2. 在启动类加入注解@EnableWebSecurityJwt
```
@SpringBootApplication
@EnableWebSecurityJwt
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
```
#####3. 在application.yml新增不拦截url（登录的)
```
jwt:
  filter:
    exceptUrl: /auth/token
```
#####4. 编写本地服务实现org.springframework.security.core.userdetails.UserDetailsService；主要用于根据用户名查询UserDetails
```
@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据username查询用户信息
        if ("18888888888".equals(username)) {
            User user = new User("18888888888", PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"), "userid1111101111");
            user.setMobile("13333333333");
            return user;
        }else {
            return null;
        }
    }
}
```
User实现UserDetails,可自定义属性如mobile生成token时放入
```
@Data
public class User extends UserDTO {


    private String mobile;
    public User(String username, String password,String userId) {
        super.setUsername(username);
        setUserId(userId);
        setPassword(password);
    }
    public User(){}


}
```
#####5. 校验token时请求的Header加Authorization:Bearer token
#####6. 支持自定义用户民密码字段；登录地址
```
login:
  extend:
    username: username
    password: password
    loginUrl: /auth/token
```
#####7. 编写自己的controller，如果需要生成token时的User对象直接@RequestAttribute接收字符串自己转换即可，如果不需要可忽略
```
@RestController
@Log4j2
public class SecurityJwtController {

    @PostMapping("/jwt")
    public Object get(@RequestAttribute String userInfoDTO){
        log.info("=================userInfoDTO={}",userInfoDTO);
        User user= JSONObject.parseObject(userInfoDTO,User.class);

        return JSON.toJSON(user);
    }
}
```
### 源码分析

