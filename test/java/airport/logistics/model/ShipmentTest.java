package airport.logistics;

import airport.logistics.enums.*;
import airport.logistics.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipmentTest {

    @Test
    void shouldCreateShipment() {
        Shipment shipment =
                new Shipment(
                        1,
                        "Mars",
                        "Europa",
                        7
                );

        assertEquals(
                ShipmentStatus.PENDING,
                shipment.status()
        );
    }

    @Test
    void shouldAssignPilot() {
        Shipment shipment =
                new Shipment(
                        1,
                        "Mars",
                        "Europa",
                        5
                );

        Pilot pilot =
                new Pilot(
                        "Sarah",
                        PilotRank.CAPTAIN,
                        1000,
                        List.of("Transport")
                );

        shipment.assignPilot(pilot);

        assertEquals(
                1,
                shipment.assignedPilots().size()
        );
    }

    @Test
    void shouldAssignCargo() {
        Shipment shipment =
                new Shipment(
                        1,
                        "Mars",
                        "Europa",
                        5
                );

        shipment.addCargo(
                new Cargo(
                        CargoType.FOOD,
                        100,
                        3
                )
        );

        assertEquals(
                1,
                shipment.cargoManifest().size()
        );
    }

    @Test
    void shouldProtectPilotList() {
        Shipment shipment =
                new Shipment(
                        1,
                        "Mars",
                        "Europa",
                        5
                );

        List<Pilot> pilots =
                shipment.assignedPilots();

        pilots.clear();

        assertEquals(
                0,
                shipment.assignedPilots().size()
        );
    }

    @Test
    void shouldCalculateRisk() {
        Shipment shipment =
                new Shipment(
                        1,
                        "Mars",
                        "Europa",
                        8
                );

        shipment.addCargo(
                new Cargo(
                        CargoType.FUEL,
                        500,
                        5
                )
        );

        assertTrue(
                shipment.calculateRisk() > 0
        );
    }

    @Test
    void shouldUpdateStatus() {
        Shipment shipment =
                new Shipment(
                        1,
                        "Mars",
                        "Europa",
                        5
                );

        shipment.updateStatus(
                ShipmentStatus.IN_PROGRESS
        );

        assertEquals(
                ShipmentStatus.IN_PROGRESS,
                shipment.status()
        );
    }
}