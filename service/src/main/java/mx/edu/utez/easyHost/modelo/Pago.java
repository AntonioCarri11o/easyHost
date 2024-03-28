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
@Table(name = "pago")
@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    Long id;
    @Column(name = "fecha_pago", nullable = false)
    Date fecha;
    @Column(name = "monto_pago", nullable = false)
    Double monto;
    @JoinColumn(name = "fk_estatus", nullable = false)
    @ManyToOne
    Estatus estatus;
    @JoinColumn(name = "fk_reserva", nullable = false)
    @OneToOne
    Reserva reserva;

    public Pago(Date fecha, Double monto, Estatus estatus, Reserva reserva) {
        this.fecha = fecha;
        this.monto = monto;
        this.estatus = estatus;
        this.reserva = reserva;
    }
}
