package Entidades;

import com.sun.istack.NotNull;
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
@Table(name = "Categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String denominacion;


    @ManyToMany(mappedBy = "ArtCategoria")
    private Set<Articulo> CatArticulo = new HashSet<Articulo>();
}
