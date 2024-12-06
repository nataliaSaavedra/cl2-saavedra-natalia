package pe.edu.cibertec.cl2_saavedra_natalia.model.id;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class FilmActorId implements Serializable {
    private Integer filmId;
    private Integer actorId;
}
