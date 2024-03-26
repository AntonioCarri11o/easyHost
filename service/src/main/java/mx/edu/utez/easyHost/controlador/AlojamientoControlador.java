package mx.edu.utez.easyHost.controlador;

import mx.edu.utez.easyHost.utilidades.VariableGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


}
