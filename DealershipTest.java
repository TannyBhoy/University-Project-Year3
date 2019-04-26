//*
//*
//stepTwo
//*
//*
public class DealershipTest {

    public static void main(String args[]) {
        String DealershipName = Input.getString("Enter Dealership Name: ");
        System.out.println("\nWelcome to " + "'" + DealershipName.toUpperCase() + "'" + " Dealership\n");
        System.out.println("Please select an option from the menu\n");
        String carMake = "";
        Dealership makeList = new Dealership(DealershipName);
        Car carList = new Car();
        Integer option;
        do {
            System.out.println("0: Quit");
            System.out.println("1: Add Make");
            System.out.println("2: Display");
            System.out.println("3: Search");
            System.out.println("4: Remove Make");
            System.out.println("5: Add Car Details");
            System.out.println("6: Display Car Details\n");
            option = Input.getInteger("input option: ");
            System.out.println();
            switch (option) {
                case 0:
                    System.out.println("Quitting Program");
                    break;
                case 1:
                    try {
                        carMake = Input.getString("Enter new make: ");
                        makeList.checkMakes(carMake);
                        makeList.addMake(carMake);
                        System.out.println("'" + carMake.toUpperCase() + "'" + " added\n");
                    } catch (Dealership.NameNotUniqueException e) {
                        System.out.println("\n\tError! " + "'" + carMake.toUpperCase() + "'" + " already exists\n");
                        System.out.println("\tPlease enter a new Make\n");
                    }
                    break;
                case 2:
                    System.out.println(makeList);
                    break;
                case 3:
                    try {
                        carMake = Input.getString("Search make: ");
                        makeList.search(carMake);
                    } catch (Dealership.NameNotFoundException e) {
                        System.out.println("\n\tError! " + "'" + carMake.toUpperCase() + "'" + " does not exist\n");
                        System.out.println("\tPlease enter a new Search\n");
                    }
                    break;
                case 4:
                    try {
                        carMake = Input.getString("Search make: ");
                        makeList.remove(carMake);
                    } catch (Dealership.NameNotFoundException e) {
                        System.out.println("\n\tError! " + "'" + carMake.toUpperCase() + "'" + " does not exist\n");
                        System.out.println("\tPlease enter a new Search\n");
                    }
                    break;
                case 5:
                    try {
                        carMake = Input.getString("Search make: ");
                        makeList.search(carMake);
                        System.out.println("Add details for " + "'" + carMake.toUpperCase() + "'" + ":\n");
                        String carReg = Input.getString("Registration: ");
                        String carColour = Input.getString("Colour: ");
                        String carModel = Input.getString("Model: ");
                        carList.addCar(carReg, carColour, carModel);
                    } catch (Dealership.NameNotFoundException e) {
                        System.out.println("\n\tError! " + "'" + carMake.toUpperCase() + "'" + " does not exist\n");
                        System.out.println("\tPlease enter a new Search\n");
                    }
                    break;                  
                case 6:
                    System.out.println(carList);
                    break;  
                default:
                    System.out.println("\t**INVALID OPTION**\n");
                    System.out.println("\tPlease select a valid option from the menu below:\n");
            }
        } while (option != 0);
    }

}

