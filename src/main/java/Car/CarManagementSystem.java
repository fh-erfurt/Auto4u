package Car;

import java.util.ArrayList;

/** Represents a Car Management System
 * @see {@link ElectricCar}
 * @see {@link CombustionCar}
 * @author OneNightCar
 * @version 1.0
 * @since 1.0
 */
public class CarManagementSystem {
    public ArrayList<CombustionCar> combustionCarsList;
    public ArrayList<ElectricCar> electricCarsList;


    /** Create a CarManagementSystem with empty lists
     * a list for the Combustion cars and
     * a list for the Electric cars
     * */
    public CarManagementSystem(){
        this.combustionCarsList = new ArrayList<CombustionCar>();
        this.electricCarsList = new ArrayList<ElectricCar>();
    }

    /** Method to Add an electric Car to the ArrayList
     * @param electricCar
     * the Position of the added Car is at the End of the List
     * @see {@link ElectricCar}*/
    public void addCarIntoElectrics(ElectricCar electricCar)
    {
        this.electricCarsList.add(electricCar);
    }


    /** Method to Add a combustion Car to the Array List
     * @param combustionCar
     * the Position of the added Car is at the End of the List
     * @see {@link CombustionCar}*/
    public void addCarIntoCombustion(CombustionCar combustionCar)
    {
        this.combustionCarsList.add(combustionCar);
    }

    /** Method to Delete a electric Car from the Array List
     * @param electricCar
     * @see {@link ElectricCar}*/

    public void deleteCarFromElectric(ElectricCar electricCar){
        this.electricCarsList.remove(electricCar);
    }

    /** Method to Delete a combustion Car from the Array List
     * @param combustionCar
     * @see {@link CombustionCar}*/
    public void deleteCarFromCombustion(CombustionCar combustionCar){
        this.combustionCarsList.remove(combustionCar);
    }


    /** gets the size of the electricCar list
     * @return  the size of electricCarList
     * */
    public int getSizeOfElectricCarsList(){
        return electricCarsList.size();
    }


    /** gets the size of the combustionCar list
     * @return  the size of combustionCarList
     * */
    public int getSizeOfCombustionCarsList(){
        return combustionCarsList.size();
    }

    /** gets the Index(id) of the combustionCar list
     * @return  the Index of combustionCarList
     * */
    public int getCarIDFromCombustion(CombustionCar combustionCar)
    {
        return combustionCarsList.indexOf(combustionCar);
    }


    /** gets the Index(id) of the electricCar list
     * @return  the Index of electricCarList
     * */
    public int getCarIDFromElectric(ElectricCar electricCar)
    {
        return electricCarsList.indexOf(electricCar);
    }
}
