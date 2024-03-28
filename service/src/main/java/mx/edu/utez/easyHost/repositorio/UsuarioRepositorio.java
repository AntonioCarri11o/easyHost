package mx.edu.utez.easyHost.repositorio;

import mx.edu.utez.easyHost.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Usuario getUsuarioByNombre(String nombre);
    Usuario getUsuarioByCorreo(String correo);
    List<Usuario> findAllByCorreoIn(List<String> correo);

}
