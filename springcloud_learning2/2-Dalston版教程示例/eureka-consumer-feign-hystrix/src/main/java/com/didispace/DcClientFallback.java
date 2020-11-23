package com.didispace;

import org.springframework.stereotype.Component;

/**
 * @author Wujun
 * @create 2017/6/24.
 * @blog http://blog.didispace.com
 */
@Component
public class DcClientFallback implements DcClient {

    @Override
    public String consumer() {
        return "fallback";
    }
}
