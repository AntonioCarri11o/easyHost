package mx.edu.utez.easyHost.model;

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
    Integer monto;
    @JoinColumn(name = "fk_estatus", nullable = false)
    @ManyToOne
    Estatus estatus;
    @JoinColumn(name = "fk_reserva", nullable = false)
    @OneToOne
    Reserva reserva;
}
