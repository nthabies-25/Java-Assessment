package airport.logistics.model;

public class Cargo {
    private String cargoType;
    private double weight;
    private String priorityLevel;

    public Cargo(String cargoType, double weight, String priorityLevel) {
        if (weight <= 0) {
            throw new IllegalArgumentException();
        }
        this.weight = weight;
        this.cargoType = cargoType;
    }

    public String cargoType() {
        return cargoType;
    }

    public double weight() {
        return weight;
    }

    public String priorityLevel() {
        return priorityLevel;
    }

    public void priorityLevel() {
        this.priorityLevel = priorityLevel;
    }

    public void weight(double weight){
        this.weight = weight;
    }

    public void cargoType(String cargoType){
        this.cargoType = cargoType;

    }

    @Override
    public String toString() {
        return cargoType() + " " + weight() + " " + priorityLevel();
    }

    
}
