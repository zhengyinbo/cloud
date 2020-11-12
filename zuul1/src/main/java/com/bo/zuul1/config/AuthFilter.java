//package com.bo.zuul1.config;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Component
//public class AuthFilter extends ZuulFilter {
//
//    //过滤器类型  pre在路由之前执行过滤器，
//    //post，error，route，static，或自定义
//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    //过滤器执行顺序
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    //是否开启过滤器
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    //过滤器的逻辑
//    @Override
//    public Object run() throws ZuulException {
//        //例子，过滤请求中不太token的
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        String token = request.getParameter("token");
//        if (token == null) {
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            ctx.addZuulRequestHeader("content-type", "text/html;charset=utf-8");
//            ctx.setResponseBody("非法访问");
//        }
//        return null;
//    }
//}
