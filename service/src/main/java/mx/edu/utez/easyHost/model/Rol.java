package mx.edu.utez.easyHost.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "rol")
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    Long id;
    @Column(name = "nombre_rol", length = 16)
    String nombre;
    @Column(name = "descripcion_rol", length = 32)
    String descripcion;
}
