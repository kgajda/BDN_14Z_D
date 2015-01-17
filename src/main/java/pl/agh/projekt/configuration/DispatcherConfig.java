package pl.agh.projekt.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by karol on 01.11.14.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.agh.projekt.web")
public class DispatcherConfig {
}
