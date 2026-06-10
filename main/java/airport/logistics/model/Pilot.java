package airport.logistics.model;

public class Pilot {

    public enum Rank {
        CAPTAIN,
        LEUTENENT
    }

    private String name;
    private Rank rank;
    private int flightHours;
    private String certifications;

    public Pilot(String name, Rank rank, int flightHours, String certifications) {
        if (rank == null || flightHours <= 0) {
            throw new IllegalArgumentException();
        }
        this.rank = rank;
        this.name = name;
        this.flightHours = flightHours;
        this.certifications = certifications;
    }

    public String name() { return name; }

    public Rank rank() { return rank; }

    public int flightHours() { return flightHours; }

    public String certifications() {
        return certifications;
    }

    public void rank(Rank rank){
        this.rank = rank;
    }
    public void name(String name){ this.name = name;}
    public void flightHours(int flightHours) {this.flightHours = flightHours;}

    public String toString() {
        return name() + " " + rank() + " " + flightHours() + " " + certications();
    }

}