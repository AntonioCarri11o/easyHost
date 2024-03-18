package mx.edu.utez.easyHost.servicio;

import jakarta.validation.*;
import mx.edu.utez.easyHost.dto.UsuarioDTO;
import mx.edu.utez.easyHost.modelo.Rol;
import mx.edu.utez.easyHost.modelo.Usuario;
import mx.edu.utez.easyHost.repositorio.RolRepositorio;
import mx.edu.utez.easyHost.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServicio {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Autowired
    RolRepositorio rolRepositorio;
    public Usuario registrarUsuario(UsuarioDTO usuarioDto) throws Exception {
        ValidatorFactory fabrica = Validation.buildDefaultValidatorFactory();
        Validator validador = fabrica.getValidator();
        Set<ConstraintViolation<UsuarioDTO>> errores = validador.validate(usuarioDto);
        if (!errores.isEmpty()) {
            throw new ConstraintViolationException(errores);
        }
        Rol rol = rolRepositorio.getRolByNombre("huesped");
        Usuario usuario = usuarioDto.crearUsuario(rol);
        return usuarioRepositorio.save(usuario);
    }
}
