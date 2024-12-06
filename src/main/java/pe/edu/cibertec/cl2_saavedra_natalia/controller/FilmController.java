package pe.edu.cibertec.cl2_saavedra_natalia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.cl2_saavedra_natalia.dto.FilmDetailDto;
import pe.edu.cibertec.cl2_saavedra_natalia.service.FilmService;

@Controller
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping
    public String maintenanceFilm(Model model) {
        model.addAttribute("films", filmService.findAll());
        System.out.println("Mostrando listado...\n");
        return "maintenanceFilm";
    }

    @GetMapping("/details/{id}")
    public String filmDetails(@PathVariable(name = "id") Integer filmId, Model model) {
        model.addAttribute("film", filmService.findById(filmId));
        System.out.println("Mostrando detalles...\n");
        return "filmDetails";
    }

    @GetMapping("/edit/{id}")
    public String filmEdit(@PathVariable(name = "id") Integer filmId, Model model) {
        FilmDetailDto film = filmService.findById(filmId);
        model.addAttribute("film", film);
        return "filmEdit";
    }

    @PostMapping("/edit/confirm")
    public String filmEdit(@ModelAttribute FilmDetailDto film) {
        filmService.update(film);
        System.out.println("Actualizando film...\n");
        return "redirect:/film";
    }

    @GetMapping("/delete/{id}")
    public String filmDelete(@PathVariable(name = "id") Integer filmId) {
        filmService.delete(filmId);
        System.out.println("Eliminando film...\n");
        return "redirect:/film";
    }

    @GetMapping("/register")
    public String filmRegister(Model model) {
        model.addAttribute("film", new FilmDetailDto());
        return "filmRegister";
    }

    @PostMapping("/register/confirm")
    public String filmRegister(@ModelAttribute FilmDetailDto filmDetailDto) {
        filmService.save(filmDetailDto);
        System.out.println("Registrando film...\n");
        return "redirect:/film";
    }
}
