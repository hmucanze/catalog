package catalog;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerTest {
	
protected static EntityManagerFactory entityManagerFactory;
	
	protected EntityManager entityManager;
	
	@BeforeAll
	public static void setUpBeforeClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Catalog-PU");
	}
	
	@AfterAll
	public static void tearDownAfterClass() {
		entityManagerFactory.close();
	}
	
	@BeforeEach
	public void setUp() {
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@AfterEach
	public void tearDown() {
		entityManager.close();
	}

}
