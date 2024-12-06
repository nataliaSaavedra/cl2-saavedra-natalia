package pe.edu.cibertec.cl2_saavedra_natalia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventoryId;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    private Integer storeId;
    private Date lastUpdate;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.REMOVE)
    private List<Rental> rentals;
}
