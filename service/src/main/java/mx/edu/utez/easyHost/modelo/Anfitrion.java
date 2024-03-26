package mx.edu.utez.easyHost.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "anfitrion")
@Entity
public class Anfitrion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anfitrion")
    Long id;
    @Column(name = "curp_anfitrion", length = 18, nullable = false, unique = true)
    String curp;
    @Column(name = "rfc_anfitrion", length = 13, nullable = false, unique = true)
    String rfc;
    @Column(name = "url_imagen_identificacion_anfitrion", nullable = false)
    String urlImagenIdentificacionAnfitrion;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario", nullable = false)
    @OneToOne
    Usuario usuario;

}
