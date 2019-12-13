package com.buba.stuinfomanager.controller;

import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Teacher;
import com.buba.stuinfomanager.service.LoginService;
import com.buba.stuinfomanager.util.RandomValidateCodeUtil;
import com.buba.stuinfomanager.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2019/12/12
 * @author hzp
 */

@Controller
public class UserController {

    //注入service层对象
    @Autowired
    LoginService loginService;

    /**
     * 进入登录页面
     */
    @RequestMapping(value = "/fhdl")
    public String fhdl(){
        return "/login.html";
    }
    /**
     * 登录
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public String login(Model model,String usernum, String password, String pdtj, HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(usernum,password,pdtj);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if(pdtj.equals("0")){
                Student student = loginService.stuLogin(usernum);
                session.setAttribute("id",student.getStu_id());
                session.setAttribute("name",student.getName());
                session.setAttribute("password",student.getPassword());
                session.setAttribute("type",0);
            }else{
                Teacher teacher = loginService.teaLogin(usernum);
                session.setAttribute("id",teacher.getT_id());
                session.setAttribute("name",teacher.getName());
                session.setAttribute("password",teacher.getPassword());
                session.setAttribute("type",1);
            }
            //此步将 调用realm的认证方法
        } catch(IncorrectCredentialsException e){
            //这最好把 所有的 异常类型都背会
            model.addAttribute("message", "密码错误");
            return "";
        } catch(AuthenticationException e){
            model.addAttribute("message", "登录失败");
            return "";
        }
        return "hh";
    }
    /**
     * 跳转密码页面
     */
    @RequestMapping(value = "/toPwd")
    public String toPwd(){
        return "/passwordManager/passwordManager.html";
    }
    /**
     * 修改学生密码
     */
    @RequestMapping(value = "/stu/editPwd")
    @ResponseBody
    public ResultUtil editStuPwd(String id,String pwd){
        int i = loginService.editStuPwd(id,pwd);
        if(i > 0){
            return ResultUtil.ok();
        }
        return ResultUtil.error();
    }
    /**
     * 修改教师密码
     */
    @RequestMapping(value = "/tea/editPwd")
    @ResponseBody
    public ResultUtil editTeaPwd(String id,String pwd){
        int i = loginService.editTeaPwd(id,pwd);
        if(i > 0){
            return ResultUtil.ok();
        }
        return ResultUtil.error();
    }
    /**
     * 登出
     */
    /**
     * 退出
     * @return
     */
    @RequestMapping(value="/logout")
    public String logout(HttpServletRequest request){

        //subject的实现类DelegatingSubject的logout方法，将本subject对象的session清空了
        //即使session托管给了redis ，redis有很多个浏览器的session
        //只要调用退出方法，此subject的、此浏览器的session就没了
        try {
            //退出
            SecurityUtils.getSubject().logout();
            request.getSession().removeAttribute("id");
            request.getSession().removeAttribute("name");
            request.getSession().removeAttribute("password");
            request.getSession().removeAttribute("type");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return "redirect:/fhdl";
    }
    /**
     * 跳转首页
     */
    @RequestMapping("/index")
    public String index(){
        return "/index.html";
    }
    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify")
    public void getstuVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            System.out.println("获取验证码失败"+e);
        }
    }
    /**
     * 校验验证码
     */
    @RequestMapping(value = "/checkVerify", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public boolean checkVerify(String code, HttpSession session) {
        System.out.println(code);
        try{
            //从session中获取随机数
            String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
            if (random == null) {
                return false;
            }
            if (random.equals(code)) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            System.out.println("验证码校验失败"+e);
            return false;
        }
    }
}
