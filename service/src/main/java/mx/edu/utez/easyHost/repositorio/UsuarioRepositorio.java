package mx.edu.utez.easyHost.repositorio;

import mx.edu.utez.easyHost.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
