//*
//*
//stepOne
//*
//*

public class Dealership {

    public class NameNotUniqueException extends Exception {
    }

    public class NameNotFoundException extends Exception {
    }

//    public class NotValidInputException extends Exception {
//    }
    private class DealershipNode {

        private String name;
        private DealershipNode nextMake;
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

    public void checkMakes(String carMake) throws NameNotUniqueException {
        DealershipNode makes = this.current;
        while (makes != null) {
            if (carMake.equalsIgnoreCase(makes.name)) {
                throw new NameNotUniqueException();
            }
            makes = makes.nextMake;
        }
    }

    public void search(String carMake) throws NameNotFoundException {
        DealershipNode currentVehicle = this.make.nextMake;
        boolean searchMake = true;

        while (searchMake) {
            if (carMake.equals(currentVehicle.name)) {
                currentVehicle = this.make;
                System.out.println("\nSuccess! \n" + "'" + carMake.toUpperCase() + "'" + " Found\n");
                this.current = currentVehicle;
                searchMake = false;
            } else {
                if (currentVehicle.nextMake == null) {
                    System.out.println("'" + carMake.toUpperCase() + "'" + " Not Found\n");
                    searchMake = false;
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
        DealershipNode previousVehicle = null;
        boolean searchMake = true;

        while (searchMake) {
            if (carMake.equals(currentVehicle.name)) {
                currentVehicle = this.make;
                System.out.println("\nSuccess! \n" + "'" + carMake.toUpperCase() + "'" + " Found\n");
                this.current = currentVehicle;
                searchMake = false;
                if(previousVehicle == null){
                    currentVehicle = null;
                }
            } else {
                if (currentVehicle.nextMake == null) {
                    System.out.println("'" + carMake.toUpperCase() + "'" + " Not Found\n");
                    searchMake = false;
                } else {
                    previousVehicle = currentVehicle;
                    currentVehicle = currentVehicle.nextMake;
                    System.out.println("Previous vehicle: " + previousVehicle.name + " Current vehicle: " + currentVehicle.name);
                    if (current.nextMake.name.equals(carMake)) {
                        throw new NameNotFoundException();
                    }
                }
            }
        }

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
}

