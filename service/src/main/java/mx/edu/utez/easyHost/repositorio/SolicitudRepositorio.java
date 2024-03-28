package mx.edu.utez.easyHost.repositorio;

import mx.edu.utez.easyHost.modelo.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepositorio extends JpaRepository<Solicitud, Long> {
}
