package mx.edu.utez.easyHost.modelo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "solicitud")
@Entity
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    Long id;
    @Column(name = "tipo_solicitud", nullable = false)
    String tipo;
    @Column(name = "campos_solicitud", nullable = false, columnDefinition = "json")
    String campos;
    @JoinColumn(name = "fk_estatus", referencedColumnName = "id_estatus", nullable = false, insertable = false, columnDefinition = "bigint default 5")
    @ManyToOne
    Estatus estatus;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    Usuario usuario;

    public Solicitud(String tipo, Estatus estatus, String campos, Usuario usuario) {
        this.tipo = tipo;
        this.campos = campos;
        this.estatus = estatus;
        this.usuario = usuario;
    }

    public Solicitud(String tipo, Estatus estatus, String campos) {
        this.tipo = tipo;
        this.campos = campos;
        this.estatus = estatus;
    }

    public Solicitud(String tipo, String campos) {
        this.tipo = tipo;
        this.campos = campos;
    }

    public void setCampos(Object campos) {
        try {
            this.campos = new ObjectMapper().writeValueAsString(campos);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error al convertir el objeto a JSON", e);
        }
    }

    public <T> T getCampos(Class<T> tipo) {
        try {
            return new ObjectMapper().readValue(campos, tipo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error al convertir JSON a objeto", e);
        }
    }
}
