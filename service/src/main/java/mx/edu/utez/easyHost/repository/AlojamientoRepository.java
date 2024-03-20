package mx.edu.utez.easyHost.repository;

import mx.edu.utez.easyHost.model.Alojamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlojamientoRepository extends JpaRepository<Alojamiento, Long> {
}
