package mx.edu.utez.easyHost.controlador;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import mx.edu.utez.easyHost.dto.UsuarioDTO;
import mx.edu.utez.easyHost.servicio.UsuarioServicio;
import mx.edu.utez.easyHost.utilidades.VariableGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/usuario/")
@CrossOrigin(origins = VariableGlobal.URL_ORIGENES_CRUZADOS)
public class UsuarioControlador {
    @Autowired
    UsuarioServicio usuarioServicio;

    @PostMapping("registro/")
    public ResponseEntity<String> registrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        try {
            usuarioServicio.registrarUsuario(usuarioDTO);
            return ResponseEntity.ok("Usuario creado papu :D");
        }catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            List<String> errorMessages = new ArrayList<>();
            for (ConstraintViolation<?> violation : violations) {
                errorMessages.add(violation.getMessage());
            }
            return ResponseEntity.badRequest().body(errorMessages.toString());
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
