package mx.edu.utez.easyHost.controller;

import mx.edu.utez.easyHost.model.Alojamiento;
import mx.edu.utez.easyHost.service.AlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlojamientoController {
    @Autowired
    private AlojamientoService alojamientoService;

    @PostMapping("/alojamientos")
    public ResponseEntity<Alojamiento> crearAlojamiento(@RequestBody Alojamiento alojamiento) {
        Alojamiento nuevoAlojamiento = alojamientoService.guardarAlojamiento(alojamiento);
        return new ResponseEntity<>(nuevoAlojamiento, HttpStatus.CREATED);
    }
}
