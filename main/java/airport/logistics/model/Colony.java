package airport.logistics.model;

import java.util.List;
import java.util.ArrayList;

public class Colony {
    private String colonyName;
    private List<String> population;
    private Map<String, Cargo> shipmentHistory;

    public Colony(String colonyName, List<String> population){
        this.colonyName = colonyName;
        this.population = new ArrayList<>();
        this.shipmentHistory = new hashMap<>();
    }

    public String colonyName() { return colonyName;}

    public List<String> population() {
        return population;
    }

    public Map<String, Cargo> getShipmentHistory() {
        return shipmentHistory;
    }

    public Map<String, Cargo> getShipmentHistory(){
        for (Shipment shipmentHistory : shipment){
            if (shipment.status == Shipment.Status.IN_TRANSIT){
                shipment.setStatus(Shipment.Status.COMPLETE);

                getShipmentHistory(shipmentHistory);

            }
            return shipmentHistory;

        }
        return null;

    }
}