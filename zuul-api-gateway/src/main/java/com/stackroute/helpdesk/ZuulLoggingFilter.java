package com.stackroute.helpdesk;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class ZuulLoggingFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("run");
        HttpServletRequest httpServletRequest =
                RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {} request uri -> {}",
                httpServletRequest, httpServletRequest.getRequestURI());
        System.out.println("request -> "+httpServletRequest+" request uri -> "+httpServletRequest.getRequestURI());

        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}
