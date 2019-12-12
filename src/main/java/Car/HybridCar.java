package Car;

/**
 *  <h2> HybridCar class </h2>
 *  it has the Information about the hybrid cars
 *  it's the subclass of CombustionCar class
 *
 *  @author OneNightCar Team
 *  @version 1.0
 *  @since 2019-12-12
 */
public class HybridCar extends CombustionCar {
    private float rangeOfElectricity;

    // constructor with Parameter
    public HybridCar(Type type, String brand, String model, State state,
                     double GPSLatitude, double GPSLongitude, long odometer,
                     String permission, float price, double tankSize,
                     double fuelLevel, double consumption, float rangeOfElectricity){
        super(type, brand, model, state, GPSLatitude, GPSLongitude, odometer,
                permission, price, tankSize, fuelLevel, consumption);
        this.rangeOfElectricity = rangeOfElectricity;
    }

    // default Constructor
    public HybridCar(){
        super(type.MINI,"BMW", "i3", state.OK, 50.92878, 11.5899,
                46000, "REGULARUSER", 79.00f, 9,75, 7);
        this.rangeOfElectricity= 150;
    }


    public void setFuelLevelHybrid(double fuelLevelHybrid){
        // noch zu machen
    }
}
