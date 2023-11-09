package catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import catalog.model.Film;

public class FilmTest extends EntityManagerTest {
	
	@Test
	public void mustPassWhenInsertFilm() {
		Film film = new Film();
		film.setName("Resident Evil 4");
		film.setDuration(2);
		film.setReleaseYear(2021);
		film.setCoverPhoto("file123.jpg");
		
		entityManager.getTransaction().begin();
		entityManager.persist(film);
		entityManager.getTransaction().commit();
		
		Film savedFilm = entityManager.find(Film.class, film.getId());
		assertEquals("Resident Evil 4", savedFilm.getName());
	}
	
	@Test
	public void mustPassWhenGetFilmByID() {
		Film film = entityManager.find(Film.class, 1L);
		
		assertNotNull(film);
	}
	
	@Test
	public void mustPassWhenUpdateFilm() {
		Film film = entityManager.find(Film.class, 1L);
		
		entityManager.getTransaction().begin();
		film.setName("John Wick 3");
		entityManager.merge(film);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Film saveFilm = entityManager.find(Film.class, film.getId());
		assertEquals("John Wick 3", saveFilm.getName());
	}

}
