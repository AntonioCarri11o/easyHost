package mx.edu.utez.easyHost.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "cancelacion")
@Entity
public class Cancelacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cancelacion")
    Long id;
    @Column(name = "motivo_cancelacion")
    String motivo;
    @JoinColumn(name = "fk_reserva", referencedColumnName = "id_reserva",nullable = false)
    @OneToOne
    Reserva reserva;
}
