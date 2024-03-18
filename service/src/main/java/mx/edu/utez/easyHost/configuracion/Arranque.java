package mx.edu.utez.easyHost.configuracion;

import mx.edu.utez.easyHost.modelo.Rol;
import mx.edu.utez.easyHost.repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class Arranque {

    @Autowired
    RolRepositorio rolRepositorio;

    @PostConstruct
    public void alIniciar() {
        cargarRoles();
    }

    private void cargarRoles() {
        rolRepositorio.save(new Rol(
                "admin",
                "Gestion general"
        ));
        rolRepositorio.save(new Rol(
                "anfitrion",
                "Crea y renta espacios"
        ));
        rolRepositorio.save(new Rol(
                "huesped",
                "Se hospeda en espacios"
        ));
    }
}
