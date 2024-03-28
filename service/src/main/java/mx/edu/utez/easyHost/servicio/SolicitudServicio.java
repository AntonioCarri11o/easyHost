package mx.edu.utez.easyHost.servicio;

import jakarta.validation.*;
import mx.edu.utez.easyHost.dto.SolicitudDTO;
import mx.edu.utez.easyHost.modelo.Estatus;
import mx.edu.utez.easyHost.modelo.Solicitud;
import mx.edu.utez.easyHost.modelo.Usuario;
import mx.edu.utez.easyHost.repositorio.EstatusRepositorio;
import mx.edu.utez.easyHost.repositorio.SolicitudRepositorio;
import mx.edu.utez.easyHost.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SolicitudServicio {
    @Autowired
    SolicitudRepositorio solicitudRepositorio;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    EstatusRepositorio estatusRepositorio;

    public List<Solicitud> listarSolicitudes() { return solicitudRepositorio.findAll(); }

    public Solicitud registrarSolicitud(SolicitudDTO solicitudDTO){
        ValidatorFactory fabrica = Validation.buildDefaultValidatorFactory();
        Validator validator = fabrica.getValidator();
        Set<ConstraintViolation<SolicitudDTO>> errores = validator.validate(solicitudDTO);
        if (!errores.isEmpty()){
            throw new ConstraintViolationException(errores);
        }
        Solicitud solicitud = new Solicitud();
        Usuario usuario = usuarioRepositorio.getUsuarioById(solicitud.getUsuario().getId());
        Estatus estatus = estatusRepositorio.getEstatusByClave("PENDIENTE");
        solicitud = solicitudDTO.crearSolicitud(usuario, estatus);

        return solicitudRepositorio.save(solicitud);
    }
}
