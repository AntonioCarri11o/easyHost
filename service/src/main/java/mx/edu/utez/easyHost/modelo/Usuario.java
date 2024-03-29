package mx.edu.utez.easyHost.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
    @Column(name = "contrasenia_usuario", nullable = false)
    String contrasenia;
    @Column(name = "telefono_usuario", length = 10, nullable = false)
    String telefono;
    @Column(name = "direccion_usuario", length = 60, nullable = false)
    String direccion;
    @Column(name = "f_nac_usuario", nullable = false)
    Date fechaNacimiento;
    @Column(name = "genero_usuario", nullable = false)
    String genero;
    @Column(name = "codigo_usuario", length = 5)
    String codigo;
    @Column(name = "url_imagen_usuario")
    String imagen;
    @JoinColumn(name = "fk_rol", nullable = false)
    @ManyToOne
    Rol rol;

    public Usuario(
            String nombre,
            String apellidos,
            String correo,
            String contrasenia,
            String telefono,
            String direccion,
            Date fechaNacimiento,
            String genero,
            Rol rol
    ) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.rol = rol;
    }
}
