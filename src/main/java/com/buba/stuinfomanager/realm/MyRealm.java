package com.buba.stuinfomanager.realm;


import com.buba.stuinfomanager.pojo.Student;
import com.buba.stuinfomanager.pojo.Teacher;
import com.buba.stuinfomanager.service.LoginService;
import com.buba.stuinfomanager.util.WebUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *  自定义realm数据源
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    LoginService loginService;
    /**
     *  授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    /**
     *  认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取基于用户名和密码的令牌
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String account = token.getUsername();
        if(token.getHost().equals("0")){
            Student stu = loginService.stuLogin(account);
            if(stu==null){throw new AuthenticationException("用户不存在");}

            //进行认证，将正确数据给shiro处理
            //密码不用自己比对，AuthenticationInfo认证信息对象，一个接口，new他的实现类对象SimpleAuthenticationInfo
            /*	第一个参数随便放，可以放user对象，程序可在任意位置获取 放入的对象
             * 第二个参数必须放密码，
             * 第三个参数放 当前realm的名字，因为可能有多个realm*/
            AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(stu, stu.getPassword(), this.getName());
            //AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user,user.getPassword(),new MySimpleByteSource(account), this.getName());

            //清之前的授权信息
            super.clearCachedAuthorizationInfo(authcInfo.getPrincipals());
            SecurityUtils.getSubject().getSession().setAttribute("login", stu);
            return authcInfo;
            //返回给安全管理器，securityManager，由securityManager比对数据库查询出的密码和页面提交的密码
            //如果有问题，向上抛异常，一直抛到控制器
        }else{
            Teacher tea = loginService.teaLogin(account);
            if(tea==null){throw new AuthenticationException("用户不存在");}

            //进行认证，将正确数据给shiro处理
            //密码不用自己比对，AuthenticationInfo认证信息对象，一个接口，new他的实现类对象SimpleAuthenticationInfo
            /*	第一个参数随便放，可以放user对象，程序可在任意位置获取 放入的对象
             * 第二个参数必须放密码，
             * 第三个参数放 当前realm的名字，因为可能有多个realm*/
            AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(tea, tea.getPassword(), this.getName());
            //AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user,user.getPassword(),new MySimpleByteSource(account), this.getName());

            //清之前的授权信息
            super.clearCachedAuthorizationInfo(authcInfo.getPrincipals());
            SecurityUtils.getSubject().getSession().setAttribute("login1", tea);
            return authcInfo;
            //返回给安全管理器，securityManager，由securityManager比对数据库查询出的密码和页面提交的密码
            //如果有问题，向上抛异常，一直抛到控制器
        }
    }
}
