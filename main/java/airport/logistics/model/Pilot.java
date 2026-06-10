package airport.logistics.model;

public class Pilot {

    public enum
    private String name;
    private String rank;
    private int flightHours;
    private String certifications;

    public Pilot(String name, String rank, int flightHours, String certifications) {
        if (rank == null || flightHours <= 0) {
            throw new IllegalArgumentException();
        }
        this.rank = rank;
        this.name = name;
        this.flightHours = flightHours;
        this.certifications = certifications;
    }

    public String name() { return name; }

    public String rank() { return rank; }

    public int flightHours() { return flightHours; }

    public String certifications() {
        return certifications;
    }

    public void rank(String rank){
        this.rank = rank;
    }

    public String toString() {
        return name() + " " + rank() + " " + flightHours() + " " + certications();
    }

}