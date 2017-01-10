package com.zcf.shrio.shrio.chapter6.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import com.zcf.shrio.shrio.chapter6.BaseTest;


/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class UserRealmTest extends BaseTest {
    

  /*  @Test
      public void testLoginSuccess() {
        login("classpath:chapter6/chapter6/shiro.ini", u1.getUsername(), password);
        Assert.assertTrue(subject().isAuthenticated());
        
    }
    	 @Test(expected = UnknownAccountException.class)
	    public void testLoginFailWithUnknownUsername() {
	        login("classpath:chapter6/shiro.ini", u1.getUsername() + "1", password);
	    }
	    
	      @Test(expected = IncorrectCredentialsException.class)
    public void testLoginFailWithErrorPassowrd() {
        login("classpath:chapter6/shiro.ini", u1.getUsername(), password + "1");
    }
    
   	  @Test(expected = LockedAccountException.class)
	    public void testLoginFailWithLocked() {
	        login("classpath:chapter6/shiro.ini", u4.getUsername(), password + "1");
	    } 
    
    
    */

/*    @Test(expected = ExcessiveAttemptsException.class)
    public void testLoginFailWithLimitRetryCount() {
    	  //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:chapter6/shiro.ini");

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(u3.getUsername(), password + "1");
        for(int i = 1; i <= 5; i++) {
            try {         	

                subject.login(token);
            } catch (Exception e) {//ignore
            	
            }
        }
        subject.login(token);
        //需要清空缓存，否则后续的执行就会遇到问题(或者使用一个全新账户测试)
    }
    
        @Test
    public void testHasRole() {
        login("classpath:chapter6/shiro.ini", u1.getUsername(), password );
        Assert.assertTrue(subject().hasRole("admin"));
    }
    */
    

    @Test
    public void testNoRole() {
        login("classpath:chapter6/shiro.ini", u2.getUsername(), password);
        Assert.assertFalse(subject().hasRole("admin"));
    }

    @Test
    public void testHasPermission() {
        login("classpath:chapter6/shiro.ini", u1.getUsername(), password);
        Assert.assertTrue(subject().isPermittedAll("user:create", "menu:create"));
    }

    @Test
    public void testNoPermission() {
        login("classpath:chapter6/shiro.ini", u2.getUsername(), password);
        Assert.assertFalse(subject().isPermitted("user:create"));
    }
}
