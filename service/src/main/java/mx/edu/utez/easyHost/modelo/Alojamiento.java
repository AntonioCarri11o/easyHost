package mx.edu.utez.easyHost.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "alojamiento")
@Entity
public class Alojamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alojamiento")
    Long id;
    @Column(name = "descripcion_alojamiento", nullable = false)
    String descripcion;
    @Column(name = "ubicacion_alojamiento", nullable = false)
    String ubicacion;
    @Column(name = "precio_alojamiento", nullable = false)
    Double precio;
    @Column(name = "n_huespedes_alojamiento", nullable = false)
    Integer numeroHuespedes;
    @Column(name = "n_camas_alojamiento", nullable = false)
    Integer numeroCamas;
    @Column(name = "n_banios_alojamiento", nullable = false)
    Integer numeroBanios;
    @Column(name = "disponibilidad_alojamiento", nullable = false)
    Boolean disponibilidad;
    @Column(name = "h_recepcion_alojamiento", nullable = false)
    Time horaRecepcion;
    @Column(name = "h_salida_alojamiento", nullable = false)
    Time horaSalida;
    @JoinColumn(name = "fk_anfitrion", referencedColumnName = "id_anfitrion", nullable = false)
    @ManyToOne
    Anfitrion anfitrion;
    @JoinColumn(name = "fk_categoria", referencedColumnName = "id_categoria", nullable = false)
    @ManyToOne
    Categoria categoria;
    @JoinColumn(name = "fk_estatus", referencedColumnName = "id_estatus", nullable = false)
    @ManyToOne
    Estatus estatus;
    @ManyToMany
    @JoinTable(
            name = "extra_alojamiento",
            joinColumns = @JoinColumn(name = "id_alojamiento"),
            inverseJoinColumns = @JoinColumn(name = "id_extra")
    )
    Set<Extra> extras;

    public Alojamiento(String descripcion, String ubicacion, Double precio, Integer numeroHuespedes, Integer numeroCamas, Integer numeroBanios, Boolean disponibilidad, Time horaRecepcion, Time horaSalida, Anfitrion anfitrion, Categoria categoria, Estatus estatus) {
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.numeroHuespedes = numeroHuespedes;
        this.numeroCamas = numeroCamas;
        this.numeroBanios = numeroBanios;
        this.disponibilidad = disponibilidad;
        this.horaRecepcion = horaRecepcion;
        this.horaSalida = horaSalida;
        this.anfitrion = anfitrion;
        this.categoria = categoria;
        this.estatus = estatus;
    }

    public Alojamiento(String descripcion, String ubicacion, Double precio, Integer numeroHuespedes, Integer numeroCamas, Integer numeroBanios, Boolean disponibilidad, Time horaRecepcion, Time horaSalida, Anfitrion anfitrion, Categoria categoria, Estatus estatus, Set<Extra> extras) {
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.numeroHuespedes = numeroHuespedes;
        this.numeroCamas = numeroCamas;
        this.numeroBanios = numeroBanios;
        this.disponibilidad = disponibilidad;
        this.horaRecepcion = horaRecepcion;
        this.horaSalida = horaSalida;
        this.anfitrion = anfitrion;
        this.categoria = categoria;
        this.estatus = estatus;
        this.extras = extras;
    }
}
