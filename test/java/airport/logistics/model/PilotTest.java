package test.java.airport.logistics.model;

import airport.logistics.enums.PilotRank;
import airport.logistics.model.Pilot;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PilotTest {

    @Test
    void shouldCreatePilot() {
        Pilot pilot = new Pilot(
                "Sarah",
                PilotRank.CAPTAIN,
                5000,
                List.of("Heavy Transport")
        );

        assertEquals("Sarah", pilot.name());
        assertEquals(PilotRank.CAPTAIN, pilot.rank());
        assertEquals(5000, pilot.flightHours());
    }

    @Test
    void shouldRejectNegativeHours() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pilot(
                        "Sarah",
                        PilotRank.CAPTAIN,
                        -1,
                        List.of("Heavy Transport")
                )
        );
    }

    @Test
    void shouldRejectEmptyCertifications() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pilot(
                        "Sarah",
                        PilotRank.CAPTAIN,
                        100,
                        List.of()
                )
        );
    }

    @Test
    void shouldUseDefensiveCopy() {
        Pilot pilot = new Pilot(
                "Sarah",
                PilotRank.CAPTAIN,
                100,
                List.of("Mining")
        );

        List<String> certs = pilot.certifications();

        certs.clear();

        assertEquals(
                1,
                pilot.certifications().size()
        );
    }

    @Test
    void shouldDetectCertification() {
        Pilot pilot = new Pilot(
                "Sarah",
                PilotRank.CAPTAIN,
                100,
                List.of("Mining")
        );

        assertTrue(
                pilot.hasCertification("Mining")
        );

        assertFalse(
                pilot.hasCertification("Science")
        );
    }
}