package airport.logistics;

import airport.logistics.enums.*;
import airport.logistics.model.*;
import airport.logistics.service.CivilianLogistics;
import airport.logistics.service.LogisticsControl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogisticsControlTest {

    @Test
    void shouldAddShipmentToQueue() {

        Colony colony = new Colony("Mars", 1000);

        LogisticsControl control =
                new CivilianLogistics("Civil", colony);

        Shipment shipment =
                new Shipment(1, "Mars", "Europa", 5);

        control.addShipment(shipment);

        assertEquals(1, control.shipments().size());
    }

    @Test
    void shouldReturnNextShipment() {

        Colony colony = new Colony("Mars", 1000);

        LogisticsControl control =
                new CivilianLogistics("Civil", colony);

        Shipment shipment =
                new Shipment(1, "Mars", "Europa", 5);

        control.addShipment(shipment);

        assertEquals(shipment, control.nextShipment());
    }

    @Test
    void shouldReturnNullWhenNoShipmentsExist() {

        Colony colony = new Colony("Mars", 1000);

        LogisticsControl control =
                new CivilianLogistics("Civil", colony);

        assertNull(control.nextShipment());
    }

    @Test
    void shouldReturnDefensiveCopyOfShipments() {

        Colony colony = new Colony("Mars", 1000);

        LogisticsControl control =
                new CivilianLogistics("Civil", colony);

        var shipments = control.shipments();

        shipments.clear();

        assertEquals(0, shipments.size());
        assertEquals(0, control.shipments().size());
    }

    @Test
    void shouldReturnDefensiveCopyOfReports() {

        Colony colony = new Colony("Mars", 1000);

        LogisticsControl control =
                new CivilianLogistics("Civil", colony);

        var reports = control.airportpletedReports();

        reports.clear();

        assertEquals(0, reports.size());
        assertEquals(0, control.airportpletedReports().size());
    }

    @Test
    void shouldThrowIfShipmentHasNoPilots() {

        Colony colony = new Colony("Mars", 1000);

        LogisticsControl control =
                new CivilianLogistics("Civil", colony);

        Shipment shipment =
                new Shipment(1, "Mars", "Europa", 5);

        control.addShipment(shipment);

        assertThrows(
                IllegalStateException.class,
                control::processNextShipment
        );
    }

    @Test
    void shouldThrowIfRequiredCargoMissing() {

        Colony colony = new Colony("Mars", 1000);

        LogisticsControl control =
                new CivilianLogistics("Civil", colony);

        Shipment shipment =
                new Shipment(1, "Mars", "Europa", 5);

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
                        CargoType.FUEL,
                        100,
                        5
                )
        );

        control.addShipment(shipment);

        assertThrows(
                IllegalStateException.class,
                control::processNextShipment
        );
    }

    @Test
    void shouldThrowIfColonyHasInsufficientCargo() {

        Colony colony = new Colony("Mars", 1000);

        colony.addCargo(
                new Cargo(
                        CargoType.FUEL,
                        50,
                        5
                )
        );

        LogisticsControl control =
                new CivilianLogistics("Civil", colony);

        Shipment shipment =
                new Shipment(1, "Mars", "Europa", 5);

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
                        CargoType.FUEL,
                        100,
                        5
                )
        );

        control.addShipment(shipment);

        assertThrows(
                IllegalStateException.class,
                control::processNextShipment
        );
    }

    @Test
    void shouldConsumeCargoDuringProcessing() {

        Colony colony = new Colony("Mars", 1000);

        Cargo fuel =
                new Cargo(
                        CargoType.FUEL,
                        500,
                        10
                );

        colony.addCargo(fuel);

        LogisticsControl control =
                new CivilianLogistics("Civil", colony);

        Shipment shipment =
                new Shipment(1, "Mars", "Europa", 5);

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
                        CargoType.FUEL,
                        100,
                        1
                )
        );

        control.addShipment(shipment);

        control.processNextShipment();

        assertEquals(
                400,
                colony.getCargo(CargoType.FUEL).quantity()
        );
    }

    @Test
    void shouldCreateMissionReport() {

        Colony colony = new Colony("Mars", 1000);

        colony.addCargo(
                new Cargo(
                        CargoType.FOOD,
                        500,
                        1
                )
        );

        LogisticsControl control =
                new CivilianLogistics("Civil", colony);

        Shipment shipment =
                new Shipment(1, "Mars", "Europa", 5);

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

        assertNotNull(report);
        assertEquals(1,
                control.airportpletedReports().size());
    }

    @Test
    void shouldUpdateShipmentStatusToairportpleted() {

        Colony colony = new Colony("Mars", 1000);

        colony.addCargo(
                new Cargo(
                        CargoType.FOOD,
                        500,
                        1
                )
        );

        LogisticsControl control =
                new CivilianLogistics("Civil", colony);

        Shipment shipment =
                new Shipment(1, "Mars", "Europa", 5);

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

        control.processNextShipment();

        assertEquals(
                ShipmentStatus.airportPLETED,
                shipment.status()
        );
    }
}