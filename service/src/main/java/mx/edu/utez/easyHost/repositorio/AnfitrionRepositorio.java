package mx.edu.utez.easyHost.repositorio;

import mx.edu.utez.easyHost.modelo.Anfitrion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnfitrionRepositorio extends JpaRepository<Anfitrion, Long> {
    Anfitrion getAnfitrionByRfc(String rfc);
}
