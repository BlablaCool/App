package info.fges.blablacool.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import java.util.Properties;

/**
 * Created by Valentin on 15/03/15.
 */

@EnableWebMvc
@Configuration
@ComponentScan({"info.fges.blablacool"})
@EnableTransactionManagement
@Import({ SecurityConfig.class })
public class AppConfig extends WebMvcConfigurerAdapter
{
    @Bean
    public SessionFactory sessionFactory()
    {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("info.fges.blablacool").addProperties(getHibernateProperties());

        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties()
    {
        Properties prop = new Properties();
        prop.put("hibernate.format_sql", "false"); // TRUE DEV
        prop.put("hibernate.show_sql", "false"); // TRUE DEV
        prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");

        prop.put("hibernate.enable_lazy_load_no_trans", "true");

        // prop.put("hibernate.cache.use_second_level_cache", "false"); // FALSE DEV
        // prop.put("hibernate.cache.use_query_cache", "false"); // FALSE DEV
        prop.put("hibernate.c3p0.max_statements", "0");
        prop.put("hibernate.connection.isolation", "2");

        prop.put("javax.persistence.validation.mode", "none");

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

    @Bean
    public HibernateTransactionManager txManager()
    {
        return new HibernateTransactionManager(sessionFactory());
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver()
    {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(2);

        return resolver;
    }

    @Bean
    public UrlBasedViewResolver viewResolver()
    {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(TilesView.class);
        viewResolver.setOrder(1);

        return viewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer()
    {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{
                "/WEB-INF/tiles/tiles-definitions.xml",
                "/WEB-INF/views/**/tiles.xml"
        });
        tilesConfigurer.setCheckRefresh(true);

        return tilesConfigurer;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/assets/**").addResourceLocations("/WEB-INF/assets/");
    }
}
