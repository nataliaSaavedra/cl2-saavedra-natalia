package pe.edu.cibertec.cl2_saavedra_natalia.dto;

import java.util.Date;

public record FilmDetailDto(
        Integer filmId,
        String title,
        String description,
        Integer releaseYear,
        Integer languageId,
        String language,
        Integer rentalDuration,
        Double rentalRate,
        Integer length,
        Double replacementCost,
        String rating,
        String specialFeatures,
        Date lastUpdate
) {
    public FilmDetailDto() {
        this(null, "", "", 0,
                0, "", 0, 0.0, 0,
                0.0, "", "", null);
    }
}
