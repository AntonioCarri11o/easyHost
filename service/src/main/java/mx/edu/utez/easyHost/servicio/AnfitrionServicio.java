package mx.edu.utez.easyHost.servicio;

import jakarta.validation.*;
import mx.edu.utez.easyHost.dto.AnfitrionDTO;
import mx.edu.utez.easyHost.modelo.Anfitrion;
import mx.edu.utez.easyHost.modelo.Usuario;
import mx.edu.utez.easyHost.repositorio.AnfitrionRepositorio;
import mx.edu.utez.easyHost.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AnfitrionServicio {
    @Autowired
    AnfitrionRepositorio anfitrionRepositorio;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public List<Anfitrion> listarAnfitriones() { return anfitrionRepositorio.findAll();}

    public Anfitrion registrarAnfitrion(AnfitrionDTO anfitrionDTO) throws Exception{
        ValidatorFactory fabrica = Validation.buildDefaultValidatorFactory();
        Validator validator = fabrica.getValidator();
        Set<ConstraintViolation<AnfitrionDTO>> errores = validator.validate(anfitrionDTO);
        if (!errores.isEmpty()){
            throw new ConstraintViolationException(errores);
        }

        Anfitrion anfitrion = new Anfitrion();
        Usuario usuario = usuarioRepositorio.getUsuarioById(anfitrion.getUsuario().getId());
        anfitrion = anfitrionDTO.crearAnfitrion(usuario);

        return anfitrionRepositorio.save(anfitrion);
    }
}
