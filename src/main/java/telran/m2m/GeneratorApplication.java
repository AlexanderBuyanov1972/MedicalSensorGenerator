package telran.m2m;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GeneratorApplication {
	
	public static void main(String[] args) {
		long timeout = 60000;
		ConfigurableApplicationContext ctx =
		SpringApplication.run(GeneratorApplication.class, args);
			
		try {
			Thread.sleep(timeout);
			ctx.close();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException e ---> Что-то пошло не так!!!");
			e.printStackTrace();
		}
	}
}
	