package cn.tenfell.tools.nocontroller.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BodyReaderRequestWrapper extends HttpServletRequestWrapper {
    private final String body;

    /**
     *
     * @param request
     */
    public BodyReaderRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        byte[] bytes = ServletUtil.getBodyBytes(request);
        body = StrUtil.str(bytes,"UTF-8");
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayIns = new ByteArrayInputStream(body.getBytes());
        ServletInputStream servletIns = new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
            @Override
            public int read() throws IOException {
                return byteArrayIns.read();
            }
        };
        return  servletIns;
    }
}