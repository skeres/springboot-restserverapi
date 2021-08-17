package com.sks.springbootrestserverapi;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	//L'application est initialisée par la classe ServletInitializer
	//Cette classe remplace ainsi l'ancien fichier web.xml.
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootRestserverapiApplication.class);
	}

}
