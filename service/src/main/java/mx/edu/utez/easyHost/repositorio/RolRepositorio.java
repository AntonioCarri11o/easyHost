package mx.edu.utez.easyHost.repositorio;

import mx.edu.utez.easyHost.modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Long> {
    Rol getRolByNombre(String nombre);
}
