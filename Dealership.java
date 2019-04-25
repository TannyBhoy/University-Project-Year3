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

//    public boolean search(String carMake) throws NameNotFoundException {
//        this.current = this.make;
//        boolean exists = false;
//        if (carMake.equals(this.make.name)) {
////            make = this.make;
//            exists = true;
//            System.out.println("\nSuccess! \n" + "'" + carMake.toUpperCase() + "'" + " Found\n");
////            this.current = make;
//        } else if (this.make.nextMake == null) {
//            System.out.println("'" + carMake.toUpperCase() + "'" + " Not Found\n");
//        } else {
//            if (current.nextMake.name.equals(carMake)) {
//                throw new NameNotFoundException();
//            }
//            make = this.make.nextMake;
//
//            while (make != null) {
//
//                if (carMake.equals(make.name)) {
//                    System.out.println("\nSuccess! \n" + "'" + carMake.toUpperCase() + "'" + " Found\n");
//                }
//                make = make.nextMake;
//            }
//            this.current = make;
//        }
//        return (exists);
//    }
//
//    public boolean remove(String carMake) throws NameNotFoundException {
//        System.out.println(carMake + "testError");
//        boolean car = search(carMake);
//        System.out.println(car + "testFound");
//        return (car);
//    }
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
