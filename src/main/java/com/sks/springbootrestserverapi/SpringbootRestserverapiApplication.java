package com.sks.springbootrestserverapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Annotation @SpringBootApplication
 * équivalente à l'ensemble des annotations @Configuration, @EnableAutoConfiguration et @ComponentScan
 * La classe de démarrage de l'application SpringbootRestserverApplication doit être à la racine du package principal si on veut permettre à
 * Spring de scanner les sous-packages en utilisant l'annotation @SpringBootApplication
 */


@SpringBootApplication
public class SpringbootRestserverapiApplication {

	//Cette classe est le point d'entrée de l'application
	//La classe de démarrage de l'application SpringbootRestserverApplication doit être à la racine du package principal si on veut permettre à Spring de scanner les sous-packages en utilisant l'annotation @SpringBootApplication.
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestserverapiApplication.class, args);
	}

}
