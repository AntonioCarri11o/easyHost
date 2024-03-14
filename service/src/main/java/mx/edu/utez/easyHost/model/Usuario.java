package mx.edu.utez.easyHost.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    Long id;
    @Column(name = "nombre_usuario", length = 30, nullable = false)
    String nombre;
    @Column(name = "apellidos_usuario", length = 50, nullable = false)
    String apellidos;
    @Column(name = "correo_usuario", length = 50, nullable = false, unique = true)
    String correo;

}
