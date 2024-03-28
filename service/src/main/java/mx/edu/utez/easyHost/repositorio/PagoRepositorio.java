package mx.edu.utez.easyHost.repositorio;

import mx.edu.utez.easyHost.modelo.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepositorio extends JpaRepository<Pago, Long> {
}
