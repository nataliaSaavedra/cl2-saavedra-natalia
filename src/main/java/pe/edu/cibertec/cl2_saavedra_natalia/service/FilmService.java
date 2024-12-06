package pe.edu.cibertec.cl2_saavedra_natalia.service;

import pe.edu.cibertec.cl2_saavedra_natalia.dto.FilmDetailDto;
import pe.edu.cibertec.cl2_saavedra_natalia.dto.FilmDto;

import java.util.List;

public interface FilmService {
    List<FilmDto> findAll();
    FilmDetailDto findById(Integer filmId);
    Boolean update(FilmDetailDto filmDetailDto);
    Boolean delete(Integer filmId);
    void save(FilmDetailDto filmDetailDto);
}
