package mx.edu.utez.easyHost.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "resenia")
@Entity
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resenia")
    Long id;
    @Column(name = "contenido_resenia")
    String contenido;
    @Column(name = "valoracion_resenia")
    Integer valoracion;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne
    Usuario usuario;
    @JoinColumn(name = "fk_alojamiento", referencedColumnName = "id_alojamiento", nullable = false)
    @ManyToOne
    Alojamiento alojamiento;

    public Resenia(String contenido, int valoracion, Usuario usuario, Alojamiento alojamiento) {
        this.contenido = contenido;
        this.valoracion = valoracion;
        this.usuario = usuario;
        this.alojamiento = alojamiento;
    }
}
