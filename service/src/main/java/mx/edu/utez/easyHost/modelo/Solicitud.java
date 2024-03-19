package mx.edu.utez.easyHost.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "solicitud")
@Entity
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    Long id;
    @Column(name = "tipo_solicitud", nullable = false)
    String tipo;
    @Column(name = "campos_solicitud", columnDefinition = "json", nullable = false)
    String campos;
    @JoinColumn(name = "fk_estatus", referencedColumnName = "id_estatus", nullable = false)
    @ManyToOne
    Estatus estatus;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    Usuario usuario;
}
