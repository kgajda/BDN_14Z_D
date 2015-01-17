package pl.agh.projekt.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.management.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.jmx.support.MBeanServerFactoryBean;

import javax.management.MBeanServer;

/**
 * Created by karol on 27.10.14.
 */
@Configuration
@ComponentScan(basePackages = {
        "pl.agh.projekt.db.dao",
        "pl.agh.projekt.service",
        "pl.agh.projekt.untils"
})
@Import(DbConfiguration.class)
@EnableMBeanExport
public class AppConfigurationSpring {
    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public ManagementService managementService() {
        ManagementService managementService = new ManagementService(cacheManager(), mbeanServer(), true, true, true, true);
        managementService.init();
        return managementService;
    }

    @Bean
    public MBeanServer mbeanServer() {
        MBeanServerFactoryBean mBeanServerFactoryBean = new MBeanServerFactoryBean();
        mBeanServerFactoryBean.setLocateExistingServerIfPossible(true);
        mBeanServerFactoryBean.afterPropertiesSet();
        return mBeanServerFactoryBean.getObject();
    }

    @Bean
    public CacheManager cacheManager() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        Resource r = applicationContext.getResource("classpath:ehcache.xml");
        ehCacheManagerFactoryBean.setConfigLocation(r);
        ehCacheManagerFactoryBean.setShared(true);
        ehCacheManagerFactoryBean.setCacheManagerName("testy");
        ehCacheManagerFactoryBean.afterPropertiesSet();
        return ehCacheManagerFactoryBean.getObject();
    }
}
