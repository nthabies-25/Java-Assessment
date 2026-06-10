package airport.logistics.model;

public class Shipment {

    publc enum Status{
        IN_TRANSIT,
        COMPLETE
    }
    private String shipmentId;
    private String origin;
    private String destination;
    private Pilot assignedPilots;
    private Cargo cargoManifest;
    private Status status;

    public Shipment(String shipmentId, String origin, String destination,
                    Pilot assignedPilots, Cargo cargoManifest){
        this.status = Status.IN_TRANSIT;
        this.origin = origin;
        this.destination = destination;
        this.assignedPilots = assignedPilots;
        this.cargoManifest = cargoManifest;
    }

    public String shipmentId() { return shipmentId;}
    public String origin() { return origin;}
    public String destination() { return destination;}
    public Pilot assignedPilots() { return assignedPilots;}

    public void cargoManifest(Cargo cargoManifest){
        this.cargoManifest = cargoManifest;
    }

    public void updateAssignedPilots(Pilots updatedAssignedPilots){
        this.assignedPilots = updatedAssignedPilots;

    }

    public void setStatus(Status status){
        this.status = status;
    }

    public String toString(){
        return shipmentId() + " " + origin() + " "
                + destination() + " " + assignedPilots() + " "
                + cargoManifest() + " " + status;
    }
}