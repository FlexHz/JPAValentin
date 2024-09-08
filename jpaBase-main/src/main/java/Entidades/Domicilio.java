package Entidades;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Domicilio")
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String nombrecalle;

    @Column
    @NonNull
    private int nrocalle;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;
}
