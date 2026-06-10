package airport.logistics;

import airport.logistics.enums.*;
import airport.logistics.model.*;
import airport.logistics.service.CivilianLogistics;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CivilianLogisticsTest {

    @Test
    void shouldSuccessfullyProcessQualifiedShipment() {

        Colony colony = new Colony("Mars", 1000);

        colony.addCargo(
                new Cargo(
                        CargoType.FOOD,
                        500,
                        1
                )
        );

        CivilianLogistics control =
                new CivilianLogistics(
                        "Civil",
                        colony
                );

        Shipment shipment =
                new Shipment(
                        1,
                        "Mars",
                        "Europa",
                        4
                );

        shipment.assignPilot(
                new Pilot(
                        "Sarah",
                        PilotRank.CAPTAIN,
                        5000,
                        List.of("Transport")
                )
        );

        shipment.addCargo(
                new Cargo(
                        CargoType.FOOD,
                        50,
                        1
                )
        );

        control.addShipment(shipment);

        TransportReport report =
                control.processNextShipment();

        assertTrue(report.success());
    }

    @Test
    void shouldFailHighRiskShipment() {

        Colony colony = new Colony("Mars", 1000);

        colony.addCargo(
                new Cargo(
                        CargoType.FOOD,
                        500,
                        1
                )
        );

        CivilianLogistics control =
                new CivilianLogistics(
                        "Civil",
                        colony
                );

        Shipment shipment =
                new Shipment(
                        1,
                        "Mars",
                        "Europa",
                        10
                );

        shipment.assignPilot(
                new Pilot(
                        "Sarah",
                        PilotRank.CAPTAIN,
                        5000,
                        List.of("Transport")
                )
        );

        shipment.addCargo(
                new Cargo(
                        CargoType.FOOD,
                        50,
                        1
                )
        );

        control.addShipment(shipment);

        TransportReport report =
                control.processNextShipment();

        assertFalse(report.success());
    }
}