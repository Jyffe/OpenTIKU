package org.opentiku.targetservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://websystique.com/spring-boot/spring-boot-rest-api-example/
//https://spring.io/guides/tutorials/bookmarks/

@RestController
public class TargetRestController {

	@RequestMapping("/target")
    public Target target() {
        return new Target("123", "paikka");
    }
}
