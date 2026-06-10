package airport.logistics;

import airport.logistics.model.Cargo;
import airport.logistics.enums.CargoType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoTest {

    @Test
    void shouldCreateCargo() {
        Cargo cargo = new Cargo(
                CargoType.FOOD,
                1000,
                5
        );

        assertEquals(CargoType.FOOD, cargo.type());
        assertEquals(1000, cargo.weight());
        assertEquals(5, cargo.priorityLevel());
    }

    @Test
    void shouldThrowForNegativeWeight() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Cargo(CargoType.FOOD, -1, 1)
        );
    }

    @Test
    void shouldThrowForInvalidPriority() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Cargo(CargoType.FOOD, 100, -1)
        );
    }

    @Test
    void shouldIdentifyHighPriorityCargo() {
        Cargo cargo = new Cargo(
                CargoType.MEDICAL,
                50,
                10
        );

        assertTrue(cargo.isHighPriority());
    }

    @Test
    void shouldGenerateReadableString() {
        Cargo cargo = new Cargo(
                CargoType.FUEL,
                200,
                3
        );

        String text = cargo.toString();

        assertTrue(text.contains("FUEL"));
        assertTrue(text.contains("200"));
    }
}