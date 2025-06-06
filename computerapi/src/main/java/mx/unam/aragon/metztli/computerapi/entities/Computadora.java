package mx.unam.aragon.metztli.computerapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Computer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clave;

    @Column(name = "brand", nullable = false, length = 50)
    @NotBlank(message = "El campo 'Marca' contiene una cadena vacia")
    private String marca;

    @Column(name = "model", columnDefinition = "VARCHAR(50) not null")
    private String modelo;

    @Column(name = "image", insertable = false, columnDefinition = "VARCHAR(250) DEFAULT 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png'")
    private String foto;

    @Column(name = "price", nullable = true)
    private Float precio;
}
