package com.example.springbootswagger2.controller;

import com.example.springbootswagger2.model.Acteur;
import com.example.springbootswagger2.model.Film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Api(value = "My movie controller", description = "REST Apis related to movie Entity!!!!")
@RestController
public class MyMovieController {
    public static ArrayList<Acteur> acteurs = new ArrayList<Acteur>();
    public static ArrayList<Film> films = new ArrayList<Film>();

    static {
        acteurs.add(new Acteur("LE BEC", "Owen", new Date(2000, 7, 14), null));
        acteurs.add(new Acteur("John", "Doe", new Date(2000, 7, 14), null));
        acteurs.add(new Acteur("Tom", "Jerry", new Date(2000, 7, 14), null));

        films.add(new Film("Le seigneur des anneaux", "Fantastique", null, new Date(2000, 7, 14)));
        films.add(new Film("Titanic", "Je sais pas", null, new Date(2000, 7, 14)));
        films.add(new Film("Le roi lion", "Disney", null, new Date(2000, 7, 14)));

        setActeursToFilms();

    }

    private static void setActeursToFilms() {
        for (Film film : films) {
            int random = (int) (Math.random() * acteurs.size());
            film.setActeurPrincipal(acteurs.get(random));
            acteurs.get(random).setFilmographie(film);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @ApiOperation(value = "Get list of movies in the System ", response = Iterable.class)
    @RequestMapping(value = "/acteurs", method = RequestMethod.GET)
    public ArrayList<Acteur> getAllActeurs() {
        return acteurs;
    }

    @ApiOperation(value = "Get the actor by name ", response = Acteur.class)
    @RequestMapping(value = "/acteurByName/{name}", method = RequestMethod.GET)
    public Acteur getActeurByName(@PathVariable String name) {
        for (Acteur acteur : acteurs) {
            if (acteur.getNom().equals(name)) {
                return acteur;
            }
        }
        return new Acteur("Not found", "Not found", new Date(), null);
    }

    @ApiOperation(value = "Get the actor by film ", response = Acteur.class)
    @RequestMapping(value = "/acteursByFilm/{film}", method = RequestMethod.GET)
    public ArrayList<Acteur> getActeursByFilm(@PathVariable Film film) {
        ArrayList<Acteur> acteursByFilm = new ArrayList<Acteur>();
        for (Acteur acteur : acteurs) {
            if (acteur.getFilmographie().equals(film)) {
                acteursByFilm.add(acteur);
            }
        }
        return acteursByFilm;
    }

    @ApiOperation(value = "Get all films in the System ", response = Iterable.class)
    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public ArrayList<Film> getAllFilms() {
        return films;
    }

    @ApiOperation(value = "Get the film by name ", response = Film.class)
    @RequestMapping(value = "/filmByName/{name}", method = RequestMethod.GET)
    public Film getFilmByName(@PathVariable String name) {
        for (Film film : films) {
            if (film.getTitre().equals(name)) {
                return film;
            }
        }
        return new Film("Film not found", "Film not found", null, new Date(2000, 5, 1));
    }

    @ApiOperation(value = "Get the film by the date ", response = Film.class)
    @RequestMapping(value = "/filmByDate/{dateSortie}", method = RequestMethod.GET)
    public ArrayList<Film> getFilmsByDate(@PathVariable Date dateSortie) {
        ArrayList<Film> filmsByDate = new ArrayList<Film>();
        for (Film film : films) {
            if (film.getDateSortie().equals(dateSortie)) {
                filmsByDate.add(film);
            }
        }
        return filmsByDate;
    }

    @ApiOperation(value = "Delete the film by the name ", response = Film.class)
    @RequestMapping(value = "/deleteFilmByName/{name}", method = RequestMethod.DELETE)
    public Film deleteFilmByName(@PathVariable String name) {
        for (Film film : films) {
            if (film.getTitre().equals(name)) {
                films.remove(film);
                return film;
            }
        }
        return new Film("Film not found", "Film not found", null, new Date(2000, 5, 1));
    }

    @ApiOperation(value = "Delete the actor by the name ", response = Acteur.class)
    @RequestMapping(value = "/deleteActeurByName/{name}", method = RequestMethod.DELETE)
    public Acteur deleteActeurByName(@PathVariable String name) {
        for (Acteur acteur : acteurs) {
            if (acteur.getNom().equals(name)) {
                acteurs.remove(acteur);
                return acteur;
            }
        }
        return new Acteur("Not found", "Not found", new Date(), null);
    }

    @ApiOperation(value = "Update a film ", response = Film.class)
    @RequestMapping(value = "/updateFilm", method = RequestMethod.PUT)
    public Film updateFilm(@RequestBody Film film) {
        for (Film film1 : films) {
            if (film1.getTitre().equals(film.getTitre())) {
                films.remove(film1);
                films.add(film);
                return film;
            }
        }
        return new Film("Film not found", "Film not found", null, new Date(2000, 5, 1));
    }

    @ApiOperation(value = "Update an actor ", response = Film.class)
    @RequestMapping(value = "/updateActeur", method = RequestMethod.PUT)
    public Acteur updateActeur(@RequestBody Acteur acteur) {
        for (Acteur acteur1 : acteurs) {
            if (acteur1.getNom().equals(acteur.getNom())) {
                acteur1.setFilmographie(acteur.getFilmographie());
                acteur1.setPrenom(acteur.getPrenom());
                acteur1.setDateNaissance(acteur.getDateNaissance());
                return acteur1;
            }
        }
        return new Acteur("Not found", "Not found", new Date(), null);
    }
}
