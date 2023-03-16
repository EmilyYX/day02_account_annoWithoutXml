package com.yanxia.study.test;


import com.yanxia.study.domain.Account;
import com.yanxia.study.service.IAccountService;
import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * 使用Junit单元测试配置
 * Spring整合JUnit
 *  1.导入Spring-test的jar包
 *  2.使用Junit提供的注解替换原有的main方法，替换成RunWith
 *  3.告知spring的运行器，说明其位置。location=xml的位置。class=注解类的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    IAccountService as;
    @Test
    public void testFindAll() {
        //1.ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.IAccountService as = ac.getBean("accountService", IAccountService.class);
        List<Account> accountList = as.findAllAccount();
        for(Account account: accountList){
            System.out.println(account);
        }
    }
    @Test
    public void testFindAcById() throws SQLException {
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //IAccountService as = ac.getBean("accountService",IAccountService.class);
        Account account = as.findAccountById("1");
        System.out.println(account);
    }
    @Test
    public void testUpdateAc() throws SQLException {
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //IAccountService as = ac.getBean("accountService",IAccountService.class);
        Account account = new Account();
        account.setId(1);
        account.setMoney(Float.valueOf(2000));
        as.updateAccount(account);
    }

    /**
     * 测试Runner是否为单例
     */
    @Test
    public void testRunnerType(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        QueryRunner runner = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner1 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner == runner1);
    }
}
