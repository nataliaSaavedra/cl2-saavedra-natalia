package pe.edu.cibertec.cl2_saavedra_natalia.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.cl2_saavedra_natalia.model.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {

    @Cacheable(value = "films")
    Iterable<Film> findAll();

    @CacheEvict(value = "films", allEntries = true)
    Film save(Film film);

    @CacheEvict(value = "films", allEntries = true)
    void delete(Film film);
}
