package com.yy.bolg.controller;

import com.google.gson.Gson;
import com.yy.bolg.JsonEntity.MainJson;
import com.yy.bolg.entity.BolgAdmin;
import com.yy.bolg.entity.ResponseObj;
import com.yy.bolg.service.impl.BolgAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 控制器
 * @author enmaoFu
 * @date 2016-12-22
 *
 * Controller表示这个是控制器在 spring-web.xml的以下配置
 * 扫描web相关的bean
 <context:component-scan base-package="com.yy.bolg.controller">
 <制定扫包规则 ,只扫描使用@Controller注解的JAVA类
 <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
 </context:component-scan>

 *RequestMapping("/Login") 是说明这个类的访问地址是 /Login
 *
 * @RequestMapping(value = "/adminLogin",method = RequestMethod.POST) 是说明我这个方法的访问地址是 /Login/adminLogin ，请求方式是http请求的post方式。
 */
@Controller
@RequestMapping(value = "/Login")
public class MainController {

    @Autowired
    private BolgAdminServiceImpl bolgAdminService;    //自动载入Service对象
    private ResponseObj responseObj;//bean对象
    private String BaseUrl = "http://localhost:8080/bolg/";
    /**
     * 登陆页面
     * 这里我的方法是String方法，则是直接返回一个web页面的名字。
     * produces="text/html;charset=UTF-8" 为了解决get方式请求的时候返回中文不乱码，web.xml过滤器只是过滤post请求
     * @return
     */
    @RequestMapping(value = "/adminLogin",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public String login(HttpServletRequest req, HttpServletResponse resp, String key,int id) throws Exception {
        String result = null;
        BolgAdmin bolgAdmin = new BolgAdmin();
        bolgAdmin.setId(id);
        bolgAdmin.setMybolgAdminKey(key);
        BolgAdmin s = bolgAdminService.findUser(bolgAdmin);

        /*System.out.println(key + "------" + s.getMybolgAdminKey() + s.getId());*/
        System.out.println(key + "------" + id);
        if (null == s) {
            MainJson mj = new MainJson();
            mj.setCode(1);
            mj.setMesage("未找到该用户");
            Map map = new HashMap();
            map.put("key","");
            mj.setData(map);

            Gson gson = new Gson();
            String data = gson.toJson(mj);
            return data;
        } else {
            if (key.equals(s.getMybolgAdminKey())) {
                resp.sendRedirect(BaseUrl + "main.html");
            } else {
                MainJson mj = new MainJson();
                mj.setCode(2);
                mj.setMesage("key错误");
                Map map = new HashMap();
                map.put("key","");
                mj.setData(map);

                Gson gson = new Gson();
                String data = gson.toJson(mj);
                return data;
            }
        }
        /*if(key.equals("123")){
            *//*responseObj = new ResponseObj();
            responseObj.setCode(ResponseObj.OK);
            responseObj.setMsg("登陆成功");
            view.addObject("result", result);*//*

            resp.sendRedirect(BaseUrl + "main.html");
        }else{
            System.out.println("登陆失败");
            resp.sendRedirect(BaseUrl + "index.html");
        }*/
        return null;

    }

}
