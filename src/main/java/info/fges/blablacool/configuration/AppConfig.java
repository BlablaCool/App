package info.fges.blablacool.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

/**
 * Created by Valentin on 15/03/15.
 */

@EnableWebMvc
@Configuration
@ComponentScan({"info.fges.blablacool"})
@EnableTransactionManagement
@Import({ SecurityConfig.class })
public class AppConfig
{
    @Bean
    public SessionFactory sessionFactory()
    {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("info.fges.blablacool.models")
                .addProperties(getHibernateProperties());

        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties()
    {
        Properties prop = new Properties();
        prop.put("hibernate.format_sql", "true");
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        return prop;
    }

    @Bean(name = "dataSource")
    public BasicDataSource dataSource()
    {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/blablacool");
        ds.setUsername("blablacool");
        ds.setPassword("blablacool");

        return ds;
    }

    //Create a transaction manager
    @Bean
    public HibernateTransactionManager txManager()
    {
        return new HibernateTransactionManager(sessionFactory());
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");

        return resolver;
    }
}
