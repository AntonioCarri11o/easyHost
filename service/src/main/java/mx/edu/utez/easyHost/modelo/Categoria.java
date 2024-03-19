package mx.edu.utez.easyHost.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "categoria")
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    Long id;
    @Column(name = "nombre_categoria", length = 16, nullable = false)
    String nombre;
    @Column(name = "descripcion_categoria", length = 60, nullable = false)
    String descripcion;

}
