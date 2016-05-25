package com.swacorp.crew.microservices.css.test.config;

import com.gemstone.gemfire.cache.GemFireCache;
import com.swacorp.crew.microservices.css.domain.ChangeLog;
import java.io.IOException;
import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

//allows srping to configure runtime project
@EnableAutoConfiguration
@SpringBootApplication
//gemfire source package
@EnableGemfireRepositories(basePackages = "com.swacorp.crew.microservices.css.repository")
@ComponentScan(basePackages = {"com.swacorp.crew.microservices.css.service","com.swacorp.crew.microservices.css.api"})
public class ChangeLogTestConfig {
    
    /**
     * 
     * @return GemFire Properties
     */
    @Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "DataGemFireApplication");
        gemfireProperties.setProperty("mcast-port", "0");
        gemfireProperties.setProperty("log-level", "config");
        return gemfireProperties;
    }

    /**
     * 
     * @return CacheFactoryBean
     */
    @Bean
    CacheFactoryBean gemfireCache() {
        CacheFactoryBean gemfireCache = new CacheFactoryBean();
        gemfireCache.setClose(true);
        gemfireCache.setProperties(gemfireProperties());
        gemfireCache.setPdxPersistent(true);
        return gemfireCache;
    }

    /**
     * Configure Local region
     * @param cache
     * @return 
     */
    @Bean
    LocalRegionFactoryBean<Long, ChangeLog> changeLogRegion(final GemFireCache cache) {
        LocalRegionFactoryBean<Long, ChangeLog> region = new LocalRegionFactoryBean<>();
        region.setCache(cache);
        region.setClose(false);
        region.setName("ChangeLog");
        region.setPersistent(false);
        return region;
    }

    public static void main(String[] args) throws IOException {
        SpringApplication application = new SpringApplication(ChangeLogTestConfig.class);
        application.setWebEnvironment(true);
        application.run(args);
    }
}
