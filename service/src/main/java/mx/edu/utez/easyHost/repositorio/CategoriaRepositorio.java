package mx.edu.utez.easyHost.repositorio;

import mx.edu.utez.easyHost.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
    Categoria getCategoriaByNombre(String nombre);
}
