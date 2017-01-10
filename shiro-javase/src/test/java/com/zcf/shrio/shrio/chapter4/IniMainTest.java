package com.zcf.shrio.shrio.chapter4;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;



public class IniMainTest {

    @Test
    public void test() {

    	
/*    			#base64 byte[]
    			authenticator.bytes=aGVsbG8=
    			#hex byte[]
    			authenticator.bytes=0x68656c6c6f

    			authenticator.array=1,2,3
    			authenticator.set=$jdbcRealm,$jdbcRealm
    			authenticator.map=$jdbcRealm:$jdbcRealm,1:1,key:abc*/
    	//配置文件中的authenticator.bytes相当于调用authenticator 的setBytes方法
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:chapter4/shiro-config-main.ini");

        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();

        //将SecurityManager设置到SecurityUtils 方便全局使用
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        subject.login(token);

        Assert.assertTrue(subject.isAuthenticated());



    }
}
