package mx.edu.utez.easyHost.configuracion;

import mx.edu.utez.easyHost.modelo.Estatus;
import mx.edu.utez.easyHost.modelo.Extra;
import mx.edu.utez.easyHost.modelo.Rol;
import mx.edu.utez.easyHost.repositorio.EstatusRepositorio;
import mx.edu.utez.easyHost.repositorio.ExtraRepositorio;
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
    @Autowired
    EstatusRepositorio estatusRepositorio;
    @Autowired
    ExtraRepositorio extraRepositorio;
    @PostConstruct
    public void alIniciar() {
        cargarRoles();
        cargarEstatus();
    }

    private void cargarRoles() {
        rolRepositorio.save(new Rol(
                "ROL_ADMIN",
                "Gestion general"
        ));
        rolRepositorio.save(new Rol(
                "ROL_ANFITRION",
                "Crea y renta espacios"
        ));
        rolRepositorio.save(new Rol(
                "ROL_HUESPED",
                "Se hospeda en espacios"
        ));
    }

    private void cargarEstatus() {
        estatusRepositorio.save(new Estatus(
                "Activo",
                true
        ));
        estatusRepositorio.save(new Estatus(
           "Inactivo",
           false
        ));
        estatusRepositorio.save(new Estatus(
                "Aprobado",
                true
        ));
        estatusRepositorio.save(new Estatus(
                "Rechazado",
                false
        ));
        estatusRepositorio.save(new Estatus(
                "Pendiente",
                false
        ));
    }

    private void cargarExtras() {
        extraRepositorio.save(
                new Extra(
                        "WI-FI",
                        "Conexión de internet inalhámbrica",
                        "https://cdn-icons-png.flaticon.com/512/93/93158.png"
                )
        );
    }
}
