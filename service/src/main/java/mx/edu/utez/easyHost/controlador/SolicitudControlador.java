package mx.edu.utez.easyHost.controlador;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import mx.edu.utez.easyHost.dto.SolicitudDTO;
import mx.edu.utez.easyHost.modelo.Solicitud;
import mx.edu.utez.easyHost.servicio.SolicitudServicio;
import mx.edu.utez.easyHost.utilidades.VariableGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/solicitud")
@CrossOrigin(origins = VariableGlobal.URL_ORIGENES_CRUZADOS)
public class SolicitudControlador {
    @Autowired
    SolicitudServicio solicitudServicio;

    @GetMapping
    public List<Solicitud> listarSolicitudes() {
        return solicitudServicio.listarSolicitudes();
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registrarSolicitud(@Valid @RequestBody SolicitudDTO solicitudDTO) {
        try {
            solicitudServicio.registrarSolicitud(solicitudDTO);
            return ResponseEntity.ok("Registro exitoso!");
        } catch (ConstraintViolationException e){
            throw new RuntimeException();
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
