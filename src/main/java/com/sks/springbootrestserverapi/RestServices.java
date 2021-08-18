package com.sks.springbootrestserverapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * - a classe est annotée @Controller afin de permettre à Spring d'enregistrer cette classe comme un contrôleur, et
 * surtout de mémoriser les requêtes que cette classe est capable de gérer.
 * - L'annotation @GetMapping(value = "/") est une nouvelle annotation introduite par Spring qui
 * remplace l'annotation classique @RequestMapping et correspond exactement à RequestMapping(method=RequestMethod.GET, value = "/").
 */
@Controller
public class RestServices {

    private static final Logger logger = LoggerFactory.getLogger(RestServices.class);

    @GetMapping(value = "/")
    public ResponseEntity<String> pong()
    {
        logger.info("Démarrage des services OK .....");
        return new ResponseEntity<String>("Réponse du serveur: "+ HttpStatus.OK.name(), HttpStatus.OK);
    }


}
