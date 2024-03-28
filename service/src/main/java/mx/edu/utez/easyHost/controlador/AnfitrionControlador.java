package mx.edu.utez.easyHost.controlador;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import mx.edu.utez.easyHost.dto.AnfitrionDTO;
import mx.edu.utez.easyHost.modelo.Anfitrion;
import mx.edu.utez.easyHost.servicio.AnfitrionServicio;
import mx.edu.utez.easyHost.utilidades.VariableGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anfitrion")
@CrossOrigin(origins = VariableGlobal.URL_ORIGENES_CRUZADOS)
public class AnfitrionControlador {

    @Autowired
    AnfitrionServicio anfitrionServicio;

    @GetMapping
    public List<Anfitrion> listarAnfitriones() {
        return anfitrionServicio.listarAnfitriones();
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registrarAnfitrion(@Valid @RequestBody AnfitrionDTO  anfitrionDTO){
        try {
            anfitrionServicio.registrarAnfitrion(anfitrionDTO);
            return ResponseEntity.ok("Registro exitoso!");
        }catch (ConstraintViolationException e){
            throw new RuntimeException();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
