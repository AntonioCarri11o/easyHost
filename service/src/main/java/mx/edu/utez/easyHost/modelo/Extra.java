package mx.edu.utez.easyHost.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "extra")
@Entity
public class Extra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_extra")
    Long id;
    @Column(name = "nombre_extra", length = 16, nullable = false)
    String nombre;
    @Column(name = "descripcion_extra", length = 40, nullable = false)
    String descripcion;
    @Column(name = "url_imagen_extra", length = 255, nullable = false)
    String urlImagen;
    @ManyToMany(mappedBy = "extras")
    Set<Alojamiento> alojamientos;
}
