package mx.edu.utez.easyHost.repository;

import mx.edu.utez.easyHost.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<Usuario, Integer> {
    public Optional<Usuario> findByUsername(String username);
}