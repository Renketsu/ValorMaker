package br.com.ganguegangrena.valorMaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ganguegangrena.valorMaker.services.Application;

@SpringBootApplication
public class ValorMakerApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(ValorMakerApplication.class, args);
		Application app = new Application();
		app.run();
		
	}
	

}
