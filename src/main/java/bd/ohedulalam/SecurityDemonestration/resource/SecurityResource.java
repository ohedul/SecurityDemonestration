package bd.ohedulalam.SecurityDemonestration.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class SecurityResource {

    @GetMapping(value = "/all")
    public String hello(){
        return "hello world all!";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/secured/all")
    public String SecuredHello(){
        return "hello admin!";
    }
}
