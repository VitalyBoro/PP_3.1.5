package vitfed.kata_spr_boot_security_pp_3_1_3;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
    }

        @Bean
        public ModelMapper beanModelMapper () {
              ModelMapper modelMapper = new ModelMapper();
              return modelMapper;
        }
}
