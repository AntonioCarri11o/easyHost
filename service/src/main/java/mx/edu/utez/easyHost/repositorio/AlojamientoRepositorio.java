package mx.edu.utez.easyHost.repositorio;

import mx.edu.utez.easyHost.modelo.Alojamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlojamientoRepositorio extends JpaRepository<Alojamiento, Long> {
}
