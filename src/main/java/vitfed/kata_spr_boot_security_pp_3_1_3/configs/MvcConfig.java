package vitfed.kata_spr_boot_security_pp_3_1_3.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/","/login");
        registry.addViewController("/admin").setViewName("table");
        registry.addViewController("/user").setViewName("user");
    }
}
