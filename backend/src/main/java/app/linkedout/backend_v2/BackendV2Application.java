package app.linkedout.backend_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackendV2Application {

    public static void main(String[] args) {
        SpringApplication.run(BackendV2Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/auth/authenticate").allowedOrigins("https://www.linkedout.app",
                        "http://localhost:3000", "https://pr-118.d3b8scy54uw0vm.amplifyapp.com");
            }
        };
    }

}
