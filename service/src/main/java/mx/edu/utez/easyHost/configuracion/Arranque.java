package mx.edu.utez.easyHost.configuracion;

import mx.edu.utez.easyHost.modelo.*;
import mx.edu.utez.easyHost.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

@Component
public class Arranque {

    @Autowired
    RolRepositorio rolRepositorio;
    @Autowired
    EstatusRepositorio estatusRepositorio;
    @Autowired
    ExtraRepositorio extraRepositorio;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Autowired
    AnfitrionRepositorio anfitrionRepositorio;
    @Autowired
    AlojamientoRepositorio alojamientoRepositorio;
    @Autowired
    CategoriaRepositorio categoriaRepositorio;
    @Autowired
    ReservaRepositorio reservaRepositorio;
    @Autowired
    ReseniaRepositorio reseniaRepositorio;
    @Autowired
    PagoRepositorio pagoRepositorio;
    @Autowired
    ReseniaUsuarioRepositorio reseniaUsuarioRepositorio;
    @Autowired
    CancelacionRepositorio cancelacionRepositorio;
    @Autowired
    SolicitudRepositorio solicitudRepositorio;
    @PostConstruct
    public void alIniciar() {
        cargarRoles();
        cargarEstatus();
        cargarExtras();
        cargarUsuarios();
        cargarCategorias();
        cargarAlojamiento();
        cargarReservas();
        cargarPago();
        cargarResenia();
        cargarReseniaUsuario();
        cargarCancelacion();
        cargarEjemploAnfitrion();
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
        estatusRepositorio.save(new Estatus(
                "Reservado",
                true
        ));
        estatusRepositorio.save(new Estatus(
                "Finalizado",
                false
        ));
        estatusRepositorio.save(new Estatus(
                "Cancelado",
                false
        ));
    }
    private void cargarUsuarios(){
        cargarAdmin();
        cargarHuespedes();
        cargarAnfitrion();
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
    private void cargarCategorias() {
        categoriaRepositorio.save(new Categoria(
                "Casa",
                "Edificio de con al menos cuatro muros en una zona urbana"
        ));
        categoriaRepositorio.save(new Categoria(
                "Cuarto",
                "Espacio cerrado dentro de una edificación"
        ));
        categoriaRepositorio.save(new Categoria(
                "Cabaña",
                "Construcción pequeña de materiales pobres"
        ));
    }
    private void cargarAdmin() {
        Rol rolAdmin = rolRepositorio.getRolByNombre("ROL_ADMIN");
        usuarioRepositorio.save(
                new Usuario(
                        "Admin",
                        "Uno",
                        "admin@gmail.com",
                        "pass",
                        "9999999999",
                        "direccion de admin",
                        new Date(),
                        "Hombre",
                        rolAdmin
                )
        );
    }

    private void cargarHuespedes() {
        Rol rolHuesped = rolRepositorio.getRolByNombre("ROL_HUESPED");
        usuarioRepositorio.save(new Usuario(
                "Huesped1",
                "Uno",
                "huesped@gmail.com",
                "pass",
                "1111111111",
                "direccion huesped",
                new Date(),
                "Hombre",
                rolHuesped
        ));
        usuarioRepositorio.save(new Usuario(
                "Huesped2",
                "Dos",
                "huesped2@gmail.com",
                "pass",
                "1111111112",
                "direccion huesped2",
                new Date(),
                "Hombre",
                rolHuesped
        ));

        usuarioRepositorio.save(new Usuario(
                "Huesped3",
                "Tres",
                "huesped3@gmail.com",
                "pass",
                "1111111113",
                "direccion huesped3",
                new Date(),
                "Hombre",
                rolHuesped
        ));

    }

    private void cargarAnfitrion() {
        Rol rolAnfitrion = rolRepositorio.getRolByNombre("ROL_ANFITRION");
        Usuario anfitrion = usuarioRepositorio.save(new Usuario(
                "Anfitrion",
                "Uno",
                "anfitrion@gmail.com",
                "pass",
                "2222222222",
                "direccion anfitrion",
                new Date(),
                "Hombre",
                rolAnfitrion
        ));

        anfitrionRepositorio.save(new Anfitrion(
                "RACW050729MMCSHNA9",
                "VECJ880326",
                "https://wallpapercave.com/wp/wp7392497.jpg",
                anfitrion
        ));
    }
    private void cargarAlojamiento() {
        Anfitrion anfitrion = anfitrionRepositorio.getAnfitrionByRfc("VECJ880326");
        Categoria categoria = categoriaRepositorio.getCategoriaByNombre("Casa");
        Estatus estatus = estatusRepositorio.getEstatusByClave("Activo");
        Set<Extra> extras = new HashSet<>();
        extras.add(extraRepositorio.getExtraByNombre("WI-FI"));
        alojamientoRepositorio.save(new Alojamiento(
                "Casa ejemplo",
                "Morelos Xochitepec",
                500.0,
                3,
                3,
                2,
                true,
                Time.valueOf(LocalTime.of(16,0)),
                Time.valueOf(LocalTime.of(9,0)),
                anfitrion,
                categoria,
                estatus,
                extras
        ));

    }

    private void cargarReservas() {
        List<Usuario> huespedes = usuarioRepositorio
                .findAllByCorreoIn(Arrays
                        .asList(
                                "huesped@gmail.com",
                                "huesped2@gmail.com",
                                "huesped3@gmail.com"
                        )
                );
        Estatus pendiente = estatusRepositorio.getEstatusByClave("Pendiente");
        Estatus reservado = estatusRepositorio.getEstatusByClave("Cancelado");
        Estatus rechazado = estatusRepositorio.getEstatusByClave("Finalizado");
        List<Estatus> estatusList = Arrays.asList(pendiente, reservado, rechazado);
        Optional<Alojamiento> opcional = alojamientoRepositorio.findById(Long.valueOf(1));
        Alojamiento alojamiento;
        if (!opcional.isEmpty()) {
            alojamiento = opcional.get();
        } else {
            return;
        }
        for(int i = 0; i < huespedes.size(); i++) {
            Date fechaLlegada = new Date();
            Time horaLlegada = alojamiento.getHoraRecepcion();
            fechaLlegada.setHours(horaLlegada.getHours());
            fechaLlegada.setMinutes(horaLlegada.getMinutes());
            fechaLlegada.setSeconds(0);
            Date fechaSalida = new Date();
            Time horaSalida = alojamiento.getHoraSalida();
            fechaSalida.setHours(horaSalida.getHours());
            fechaSalida.setMinutes(horaSalida.getMinutes());
            fechaSalida.setSeconds(0);
            fechaLlegada.setDate(fechaLlegada.getDate() + i);
            fechaSalida.setDate(fechaSalida.getDate() + 1 + i);
            Usuario huesped = huespedes.get(i);
            Estatus estatus = estatusList.get(i);
            reservaRepositorio.save(new Reserva(
                    fechaLlegada,
                    fechaSalida,
                    i,
                    estatus,
                    alojamiento,
                    huesped
            ));
        }
    }
    private void cargarPago() {
        Estatus estatus = estatusRepositorio.getEstatusByClave("Aprobado");
        Optional<Reserva> opcional = reservaRepositorio.findById(3L);
        Reserva reserva;
        if (!opcional.isEmpty()) {
            reserva = opcional.get();
        } else {
            return;
        }
        pagoRepositorio.save(new Pago(
                new Date(),
                reserva.getAlojamiento().getPrecio(),
                estatus,
                reserva
        ));
    }
    private void cargarResenia() {
        Usuario huesped = usuarioRepositorio.getUsuarioByCorreo("huesped3@gmail.com");
        Optional<Alojamiento> opcional = alojamientoRepositorio.findById(1L);
        Alojamiento alojamiento;
        if (!opcional.isEmpty()) {
            alojamiento = opcional.get();
        } else {
            return;
        }
        reseniaRepositorio.save(new Resenia(
                "Bonito lugar",
                4,
                huesped,
                alojamiento
        ));
    }

    private void cargarReseniaUsuario() {
        Usuario huesped = usuarioRepositorio.getUsuarioByCorreo("huesped3@gmail.com");
        Anfitrion anfitrion = anfitrionRepositorio.getAnfitrionByRfc("VECJ880326");
        reseniaUsuarioRepositorio.save(new ReseniaUsuario(
                "Muy sucio",
                1,
                huesped,
                anfitrion
        ));
    }

    private void cargarCancelacion() {
        Optional<Reserva> opcional = reservaRepositorio.findById(2L);
        Reserva reserva;
        if (!opcional.isEmpty()) {
            reserva = opcional.get();
        } else {
            return;
        }
        cancelacionRepositorio.save(
                new Cancelacion(
                        "Ya no quise",
                        reserva
                )
        );
    }
    private void cargarEjemploAnfitrion() {
        Rol rolHuesped = rolRepositorio.getRolByNombre("ROL_HUESPED");
        usuarioRepositorio.save(new Usuario(
                "Usuario",
                "cuatro",
                "usuario_cuatro@gmail.com",
                "pass",
                "1111111114",
                "direccion usuario cuatro",
                new Date(),
                "Hombre",
                rolHuesped
        ));
        cargarSolicitud();
    }
    private void cargarSolicitud() {
        Usuario usuario = usuarioRepositorio.getUsuarioByCorreo("usuario_cuatro@gmail.com");
        Estatus pendiente = estatusRepositorio.getEstatusByClave("Pendiente");
        Map<String, Object> campos = new HashMap<>();
        campos.put("curp", "LOVA910203HMCSRR05");
        campos.put("rfc", "LOVA910203123");
        campos.put("fk_usuario", "1");
        campos.put("urlImagenIdentificacionAnfitrion", "https://wallpapercave.com/wp/wp7392497.jpg");
        Solicitud solicitud = new Solicitud(
                "verificacion_anfitrion",
                pendiente,
                "",
                usuario
        );
        solicitud.setCampos(campos);
        solicitudRepositorio.save(solicitud);
    }
}
