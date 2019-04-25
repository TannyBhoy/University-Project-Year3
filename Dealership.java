//*
//*
//stepTwo
//*
//*
public class Dealership {

    public class NameNotUniqueException extends Exception {
    }

    public class NameNotFoundException extends Exception {
    }

    private class DealershipNode {

        private String name;
        private DealershipNode nextMake;
        private CarNode carDetails = new CarNode();
    }

    private class CarNode {

        private String reg;
        private String model;
        private String colour;
        private CarNode nextCar;
    }

    private DealershipNode make;
    private DealershipNode current;
    private DealershipNode previous;
    private DealershipNode next;

    protected Dealership(String carMake) {
        this.make = new DealershipNode();
        this.make.name = carMake;
        this.current = this.make;
    }

    public void addMake(String carMake) throws NameNotUniqueException {
        DealershipNode newMake = new DealershipNode();
        newMake.name = carMake;

        if (this.current.nextMake == null) {
            this.current.nextMake = newMake;
        } else {
            DealershipNode currentMake = this.current.nextMake;
            if (current.nextMake.name.equalsIgnoreCase(carMake)) {
                throw new NameNotUniqueException();
            }
            while (currentMake.nextMake != null) {
                currentMake = currentMake.nextMake;
            }
            currentMake.nextMake = newMake;
        }
    }

    public void option(Integer option) throws NameNotUniqueException {

    }

    public void search(String carMake) throws NameNotFoundException {
        DealershipNode currentVehicle = this.make.nextMake;
        boolean searchOngoing = true;

        while (searchOngoing) {
            if (carMake.equals(currentVehicle.name)) {
                currentVehicle = this.make;
                System.out.println("\nSuccess! \n" + "'" + carMake.toUpperCase() + "'" + " Found\n");
                this.current = currentVehicle;
                searchOngoing = false;
            } else {
                if (currentVehicle.nextMake == null) {
                    System.out.println("'" + carMake.toUpperCase() + "'" + " Not Found\n");
                    searchOngoing = false;
                } else {
                    currentVehicle = currentVehicle.nextMake;

                    if (current.nextMake.name.equals(carMake)) {
                        throw new NameNotFoundException();
                    }
                }
            }
        }
    }

    public void remove(String carMake) throws NameNotFoundException {
        DealershipNode currentVehicle = this.make;
        boolean searchOngoing = true;

        while (searchOngoing) {
            if (carMake.equals(currentVehicle.name)) {
                currentVehicle = this.make;
                System.out.println("\nSuccess! \n" + "'" + carMake.toUpperCase() + "'" + " Found\n");
                this.current = currentVehicle;
                searchOngoing = false;
            } else {
                if (currentVehicle.nextMake == null) {
                    System.out.println("'" + carMake.toUpperCase() + "'" + " Not Found\n");
                    searchOngoing = false;
                } else {
                    currentVehicle = currentVehicle.nextMake;
                    if (current.nextMake.name.equals(carMake)) {
                        throw new NameNotFoundException();
                    }
                }
            }
        }
        if (carMake.equals(currentVehicle.name)) {
            System.out.println("Match");
            this.previous = this.current;
            this.current = this.next;
        }

    }


    public void addCar(String carReg, String carColour, String carModel) {
        CarNode newCar = new CarNode();
        newCar.reg = carReg;
        newCar.colour = carColour;
        newCar.model = carModel;
    }

    @Override
    public String toString() {
        String dealershipDetails = new String();
        this.current = this.make;

        dealershipDetails += this.current.name + "\n";
        DealershipNode nextMake = this.current.nextMake;

        if (this.current.nextMake == null) {
            dealershipDetails += " \tNo make entered!\n";
        } else {
            while (nextMake != null) {
                dealershipDetails += "\t" + nextMake.name + "\n";

                nextMake = nextMake.nextMake;
            }
        }
        return dealershipDetails;
    }
//}

    public String displayCars() {
        String carDetails = new String();
        CarNode current = this.current.carDetails;

        carDetails += "Reg: " + current.reg + "\n";
        carDetails += "Colour: " + current.colour + "\n";
        carDetails += "Model: " + current.model + "\n";

        if (current.nextCar == null) {
            carDetails += "\n";
        } else {
            CarNode nextCar = current.nextCar;
            while (nextCar != null) {
                carDetails += "\n";

                carDetails += "Reg: " + current.reg + "\n";
                carDetails += "Colour: " + current.colour + "\n";
                carDetails += "Model: " + current.model + "\n";

                nextCar = nextCar.nextCar;
            }
        }
        return carDetails;
    }
}
