package mx.edu.utez.easyHost.controlador;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import mx.edu.utez.easyHost.dto.AlojamientoDTO;
import mx.edu.utez.easyHost.utilidades.Utilidades;
import mx.edu.utez.easyHost.utilidades.VariableGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mx.edu.utez.easyHost.modelo.Alojamiento;
import mx.edu.utez.easyHost.servicio.AlojamientoServicio;

import java.util.List;


@RestController
@RequestMapping("/api/alojamiento")
@CrossOrigin(origins = VariableGlobal.URL_ORIGENES_CRUZADOS)

public class AlojamientoControlador {
    @Autowired
    AlojamientoServicio alojamientoServicio;

    @GetMapping
    public List <Alojamiento> listarAlojamientos(){return alojamientoServicio.listarAlojamientos();}

    @PostMapping("/registro")
    public ResponseEntity<String> registrarAlojamiento(@Valid @RequestBody AlojamientoDTO alojamientoDTO){
        try{
            alojamientoServicio.registrarAlojamiento(alojamientoDTO);
            return ResponseEntity.ok("Registro exitoso!");
        }catch (ConstraintViolationException e){
            List<String> mensajesDeError = Utilidades.obtenerErrores(e);
            return ResponseEntity.badRequest().body(mensajesDeError.toString());
        }catch (Exception e){
            throw new RuntimeException();
        }
    }


}
