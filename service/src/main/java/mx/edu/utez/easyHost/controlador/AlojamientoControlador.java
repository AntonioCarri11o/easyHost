package mx.edu.utez.easyHost.controlador;

import mx.edu.utez.easyHost.utilidades.VariableGlobal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alojamiento/")
@CrossOrigin(origins = VariableGlobal.URL_ORIGENES_CRUZADOS)

public class AlojamientoControlador {

}
