package mx.edu.utez.easyHost.repositorio;

import mx.edu.utez.easyHost.modelo.Cancelacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancelacionRepositorio extends JpaRepository<Cancelacion, Long> {
}
