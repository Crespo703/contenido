package cine.plus.cl.contenido.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contenido")
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable=false)
    private String titulo;

    @Column(length = 50, nullable=false)
    private String tipo;

    @Column(length = 30, nullable=false)
    private String categoria;

    @Column(length= 10, nullable=false)
    private boolean estado;

    @Column(length = 30, nullable=false)
    private String idioma;

    @Column(length = 60, nullable=false)
    private String urlstreaming;
}
