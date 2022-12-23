package mx.com.gm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Value("${index.saludo}")
    private String saludo;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        var mensaje ="Mensaje con Thymeleaf";
        var persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEmail("jperez@mail.com");
        persona.setTelefono("12345");
        
        var persona2 = new Persona();
        persona2.setNombre("Maria");
        persona2.setApellido("Perez");
        persona2.setEmail("mperez@mail.com");
        persona2.setTelefono("54321");
        
//        List<Persona> personas = new ArrayList<Persona>();
//        personas.add(persona);
//        personas.add(persona2);
        
        var personas = Arrays.asList(persona, persona2);
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("personas",personas);
        return "index";
        
    }

}
