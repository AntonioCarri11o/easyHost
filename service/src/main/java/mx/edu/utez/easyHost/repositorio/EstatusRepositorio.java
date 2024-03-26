package mx.edu.utez.easyHost.repositorio;

import mx.edu.utez.easyHost.modelo.Estatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstatusRepositorio extends JpaRepository<Estatus, Long> {
}
