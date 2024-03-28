package mx.edu.utez.easyHost.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "reserva")
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    Long id;
    @Column(name = "f_llegada_reserva")
    Date fechaLlegada;
    @Column(name = "f_salida_reserva")
    Date fechaSalida;
    @Column(name = "n_huespedes_reserva")
    Integer numeroHuespedes;
    @JoinColumn(name = "fk_estatus", referencedColumnName = "id_estatus", nullable = false)
    @ManyToOne
    Estatus estatus;
    @JoinColumn(name = "fk_alojamiento", referencedColumnName = "id_alojamiento", nullable = false)
    @ManyToOne
    Alojamiento alojamiento;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne
    Usuario usuario;

    public Reserva(Date fechaLlegada, Date fechaSalida, Integer numeroHuespedes, Estatus estatus, Alojamiento alojamiento, Usuario usuario) {
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.numeroHuespedes = numeroHuespedes;
        this.estatus = estatus;
        this.alojamiento = alojamiento;
        this.usuario = usuario;
    }
}
