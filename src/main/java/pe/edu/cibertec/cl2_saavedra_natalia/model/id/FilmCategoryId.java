package pe.edu.cibertec.cl2_saavedra_natalia.model.id;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class FilmCategoryId {
    private Integer filmId;
    private Integer categoryId;
}
