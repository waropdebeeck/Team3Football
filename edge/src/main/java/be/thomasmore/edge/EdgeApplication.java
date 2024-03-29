package be.thomasmore.edge;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class EdgeApplication {
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){return new RestTemplate();}
	@Bean
	public ObjectMapper getObjectMapper(){return new ObjectMapper();}
	public static void main(String[] args) {
		SpringApplication.run(EdgeApplication.class, args);
	}

}
