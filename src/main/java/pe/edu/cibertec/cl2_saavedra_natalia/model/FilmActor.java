package pe.edu.cibertec.cl2_saavedra_natalia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.cibertec.cl2_saavedra_natalia.model.id.FilmActorId;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film_actor")
public class FilmActor {
    @EmbeddedId
    private FilmActorId id;

    @MapsId("filmId")
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    private Date lastUpdate;
}
