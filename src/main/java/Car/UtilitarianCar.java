package Car;

/**
 *  <h2> UtilitarianCar class </h2>
 *  it has the Information about the Utilitarian cars
 *  it's the subclass of CombustionCar class
 *
 *  @author OneNightCar Team
 *  @version 1.1.0
 *  @since 2019-12-27
 */
public class UtilitarianCar extends CombustionCar {
    /* /////////////////////Attributes///////////////////////// */

    private Transmission transmission;
    private enum  Transmission{
        MANUAL,
        AUTOMATIC;
    }
    private float cargoCapacity; // in Liter

    /* /////////////////////Methods///////////////////////// */
    /** Constructor with Parameter
     * @param transmission
     * @param cargoCapacity
     * plus the parameters of the father Class CombustionCar
     */
    public UtilitarianCar(Type type, String brand, String model, State state,
                          double GPSLatitude, double GPSLongitude, long odometer,
                          String permission, float price, double tankSize,
                          double fuelLevel, double consumption, Transmission transmission,
                          float cargoCapacity){
        super(type, brand, model, state, GPSLatitude, GPSLongitude, odometer,
                permission, price, tankSize, fuelLevel, consumption);
        this.transmission= transmission;
        this.cargoCapacity= cargoCapacity;
    }

    /** Constructor with Default Values
     *  */

    public UtilitarianCar(){
        super(Type.COMPACT, "VolksWagen", "Golf_8", State.OK,
                50.984790, 11.041410, 197212, "NEWUSER", 39.99f,
                75, 69, 9);
        this.transmission = Transmission.AUTOMATIC;
        this.cargoCapacity = 450.00f;
    }

    public void setFuelLevel(double fuelLevel){
        boolean isReturned = false;
        if(isReturned){
            super.setFuelLevel(fuelLevel);
        }

    }
}
