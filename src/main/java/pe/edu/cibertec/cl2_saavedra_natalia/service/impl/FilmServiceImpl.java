package pe.edu.cibertec.cl2_saavedra_natalia.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.cl2_saavedra_natalia.dto.FilmDetailDto;
import pe.edu.cibertec.cl2_saavedra_natalia.dto.FilmDto;
import pe.edu.cibertec.cl2_saavedra_natalia.model.Film;
import pe.edu.cibertec.cl2_saavedra_natalia.model.Language;
import pe.edu.cibertec.cl2_saavedra_natalia.repository.FilmRepository;
import pe.edu.cibertec.cl2_saavedra_natalia.service.FilmService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<FilmDto> findAll() {
        List<FilmDto> films = new ArrayList<>();
        Iterable<Film> iterable = filmRepository.findAll();
        for(Film film: iterable) {
            FilmDto filmDto = new FilmDto(
                    film.getFilmId(),
                    film.getTitle(),
                    film.getLanguage().getName(),
                    film.getRentalDuration(),
                    film.getRentalRate()
            );
            films.add(filmDto);
        }
        return films;
    }

    @Override
    public FilmDetailDto findById(Integer filmId) {
        Optional<Film> optional = filmRepository.findById(filmId);
        return optional.map(
                film -> new FilmDetailDto(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getLanguage().getLanguageId(),
                        film.getLanguage().getName(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate())).orElse(null);
    }

    @Override
    public Boolean update(FilmDetailDto filmDetailDto) {
        Optional<Film> optional = filmRepository.findById(filmDetailDto.filmId());
        return optional.map(film -> {
            film.setTitle(filmDetailDto.title());
            film.setDescription(filmDetailDto.description());
            film.setReleaseYear(filmDetailDto.releaseYear());
            film.setRentalDuration(filmDetailDto.rentalDuration());
            film.setRentalRate(filmDetailDto.rentalRate());
            film.setLength(filmDetailDto.length());
            film.setReplacementCost(filmDetailDto.replacementCost());
            film.setRating(filmDetailDto.rating());
            film.setSpecialFeatures(filmDetailDto.specialFeatures());
            film.setLastUpdate(new Date());
            filmRepository.save(film);
            return true;
        }).orElse(false);
    }

    @Override
    public Boolean delete(Integer filmId) {
        Optional<Film> optional = filmRepository.findById(filmId);
        return optional.map(film -> {
            filmRepository.delete(film);
            return true;
        }).orElse(false);
    }

    @Override
    public void save(FilmDetailDto filmDetailDto) {
        Film film = new Film();
        film.setTitle(filmDetailDto.title());
        film.setDescription(filmDetailDto.description());
        film.setReleaseYear(filmDetailDto.releaseYear());
        film.setRentalDuration(filmDetailDto.rentalDuration());
        film.setRentalRate(filmDetailDto.rentalRate());
        film.setLength(filmDetailDto.length());
        film.setReplacementCost(filmDetailDto.replacementCost());
        film.setRating(filmDetailDto.rating());
        film.setSpecialFeatures(filmDetailDto.specialFeatures());
        film.setLastUpdate(new Date());

        Language language = new Language();
        language.setLanguageId(filmDetailDto.languageId());
        film.setLanguage(language);
        filmRepository.save(film);
    }
}
