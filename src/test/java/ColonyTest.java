import airport.logistics.enums.CargoType;
import airport.logistics.model.*;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ColonyTest {

    @Test
    void shouldAddInventory() {
        Colony colony =
                new Colony("Mars Prime", 10000);

        Cargo cargo =
                new Cargo(
                        CargoType.FOOD,
                        500,
                        2
                );

        colony.addCargo(cargo);

        assertNotNull(
                colony.getCargo(CargoType.FOOD)
        );
    }

    @Test
    void shouldReturnNullForUnknownCargo() {
        Colony colony =
                new Colony("Mars Prime", 10000);

        assertNull(
                colony.getCargo(
                        CargoType.FUEL
                )
        );
    }

    @Test
    void shouldReturnUnmodifiableInventory() {
        Colony colony =
                new Colony("Mars Prime", 10000);

        Map<?, ?> inventory =
                colony.inventory();

        assertThrows(
                UnsupportedOperationException.class,
                inventory::clear
        );
    }

    @Test
    void shouldStoreReport() {
        Colony colony =
                new Colony("Mars Prime", 10000);

        Shipment shipment =
                new Shipment(
                        1,
                        "Mars",
                        "Europa",
                        5
                );

        TransportReport report =
                new TransportReport(
                        shipment,
                        true,
                        "Success"
                );

        colony.addReport(report);

        assertEquals(
                1,
                colony.reports().size()
        );
    }
}