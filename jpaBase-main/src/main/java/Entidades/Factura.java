package Entidades;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Factura")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fecha;
    @Column
    private int numero;
    @Column
    private int total;

    @OneToMany(mappedBy = "factura", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<DetalleFactura> FactDetalleFactura = new HashSet<DetalleFactura>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

}
