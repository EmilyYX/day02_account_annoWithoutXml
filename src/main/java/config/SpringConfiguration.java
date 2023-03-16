package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 配置类，作用和bean.xml一样
 */
//@Configuration //AnnotationConfigApplicationContext(SpringConfiguration.class) 中有这个类作为参数时，此处的注解可以不写
//@ComponentScan(basePackages = {"com.yanxia.study","config"})//大括号可以拿走
@ComponentScan(basePackages = {"com.yanxia.study"})//使用import注解时，可以不扫描config包
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {
}
