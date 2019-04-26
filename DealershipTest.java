//*
//*
//stepOne
//*
//*
public class DealershipTest {

    public static void main(String args[]) {
        String DealershipName = Input.getString("Enter Dealership Name: ");
        System.out.println("\nWelcome to " + "'" + DealershipName.toUpperCase() + "'" + " Dealership\n");
        System.out.println("Please select an option from the menu\n");
        String carMake = "";
        Dealership carList = new Dealership(DealershipName);
        Integer option;
        do {
            System.out.println("0: Quit");
            System.out.println("1: Add Make");
            System.out.println("2: Display");
            System.out.println("3: Search");
            System.out.println("4: Remove Make\n");
            option = Input.getInteger("input option: ");
            System.out.println();
            switch (option) {
                case 0:
                    System.out.println("Quitting Program");
                    break;
                case 1:
                    try {
                        carMake = Input.getString("Enter new make: ");
                        carList.checkMakes(carMake);
                        carList.addMake(carMake);
                        System.out.println("'" + carMake.toUpperCase() + "'" + " added\n");
                    } catch (Dealership.NameNotUniqueException e) {
                        System.out.println("\n\tError! " + "'" + carMake.toUpperCase() + "'" + " already exists\n");
                        System.out.println("\tPlease enter a new Make\n");
                    }
                    break;
                case 2:
                    System.out.println(carList);
                    break;
                case 3:
                    try {
                        carMake = Input.getString("Search make: ");
                        carList.search(carMake);
                    } catch (Dealership.NameNotFoundException e) {
                        System.out.println("\n\tError! " + "'" + carMake.toUpperCase() + "'" + " does not exist\n");
                        System.out.println("\tPlease enter a new Search\n");
                    }
                    break;
                case 4:
                    try {
                        carMake = Input.getString("Search make: ");
                        carList.remove(carMake);
                    } catch (Dealership.NameNotFoundException e) {
                        System.out.println("\n\tError! " + "'" + carMake.toUpperCase() + "'" + " does not exist\n");
                        System.out.println("\tPlease enter a new Search\n");
                    }                    
                    break;
                default:
                    System.out.println("\t**INVALID OPTION**\n");
                    System.out.println("\tPlease select a valid option from the menu below:\n");
            }
        } while (option != 0);
    }

}

