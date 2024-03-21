package mx.edu.utez.easyHost.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "resenia_usuario")
@Entity
public class ReseniaUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resenia_usuario")
    Long id;
    @Column(name = "valoracion_resenia_usuario")
    String valoracionReseniaUsuario;
    @Column(name = "calificacion_resenia_usuario")
    Integer calificacionReseniaUsuario;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @OneToOne
    Usuario usuario;
    @JoinColumn(name = "fk_anfitrion", referencedColumnName = "id_anfitrion")
    @OneToOne
    Anfitrion anfitrion;
}
