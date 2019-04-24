
public class DealershipTest {

    public static void main(String args[]) {
        String carMake = Input.getString("Enter make: ");
        Dealership carList = new Dealership(carMake);
        Integer option;
        do {
            System.out.println("0: Quit");
            System.out.println("1: Add Make");
            System.out.println("2: Display");
            System.out.println("3: Search");
//            System.out.println("4: Remove Make");
            option = Input.getInteger("input option: ");
            System.out.println();
            switch (option) {
                case 0:
                    System.out.println("Quitting Program");
                    break;
//                    do {
//                        if ((option) < 0 || > 4) {
//                            System.out.println("ERROR! - Not a valid option");
//                        } else {
//                            System.out.println("Quitting Program");
//                        }
//                    } while (Repeat.repeat());
//                    break;
                    
                case 1:
                    try {
                        carMake = Input.getString("Enter new make: ");
                        carList.addMake(carMake);
                    } catch (Dealership.NameNotUniqueException e) {
                        System.out.println("\n\tError! " + "'" + carMake.toUpperCase() + "'" + " already exists\n");
                        System.out.println("\tPlease enter a new Make\n");
                    }
                    break;
                case 2:
                    System.out.println(carList);
                    break;
                case 3:
                    carMake = Input.getString("Search make: ");
                    carList.search(carMake);
                    break;
//                case 4:
//                    carMake = Input.getString("Search make: ");
//                    carList.remove(carMake);
//                    break;
                default:
                    System.out.println("\t**INVALID OPTION**\n");
                    System.out.println("\tPlease select a valid option from the menu below:\n");
            }
        } while (option != 0);
    }

}

