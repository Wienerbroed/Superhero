package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database db = new Database();

    @BeforeEach
    @Test
    void printDatabase() {
        db.populateDatabase();
        assertNotNull(db);
    }

    @Test
    void addHero() {
        Hero batman = new Hero("Batman", "Bruce Wayne", "Intelligence",
                1944, 5, true);
        db.addHero(batman);
        assertEquals("Batman", batman.heroName);
    }

    @Test
    void searchHero() {
        Hero testSearch = db.searchHero("superman");
        assertEquals(testSearch.heroName.toLowerCase(), "superman");
    }

    @Test
    void editHero() {
        Hero testEdit = db.searchHero("superman");
        db.editHero(testEdit);

        testEdit.setHeroName("Batman");

        assertEquals("Batman", testEdit.heroName);
    }

    @Test
    void removeHero() {
        Hero testSearch = db.searchHero("superman");
        db.removeHero(testSearch);

        Hero testSearchAfterRemoval = db.searchHero("superman");
        assertNull(testSearchAfterRemoval);
    }
}