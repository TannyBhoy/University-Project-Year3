

public class DealershipTest {


    public static void main (String args[]){
        String carMake = Input.getString("Enter make: ");
        Dealership carList = new Dealership(carMake);
        Integer option;
        do {
            System.out.println("0: Quit");
            System.out.println("1: Add Make");         
            System.out.println("2: Display");
            System.out.println("3: Search");
            System.out.println("4: Add Car Details");
            System.out.println("5: Display Cars");
            option = Input.getInteger("input option: ");
            System.out.println();
            switch (option) {
                case 0:
                    System.out.println("Quitting Program");
                    break;
                case 1:
                    carMake = Input.getString("Enter new make: ");
                    carList.addMake(carMake);
                    break;
                case 2:
                    System.out.println(carList);
                    break;     
                case 3:
                    carMake = Input.getString("Search make: ");
                    carList.search(carMake);                   
                    break; 
                case 4:
                    carMake = Input.getString("Search make: ");
                    carList.search(carMake);     
                    String carReg = Input.getString("Registration: ");
                    String carColour = Input.getString("Colour: ");
                    String carModel = Input.getString("Model: ");
                    carList.addCar(carReg, carColour, carModel);  
                    break; 
                    
                case 5:
                    carMake = Input.getString("Search make: ");
                    carList.search(carMake); 
                    carList.displayCars();
                    break;  
                default:
                    System.out.println("invalid option");
            }
        } while (option != 0);
    }
    
}
