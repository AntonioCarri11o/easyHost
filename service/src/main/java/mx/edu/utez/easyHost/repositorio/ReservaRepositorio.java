package mx.edu.utez.easyHost.repositorio;

import mx.edu.utez.easyHost.modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {
}
