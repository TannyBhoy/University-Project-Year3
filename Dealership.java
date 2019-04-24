

public class Dealership {
    
    private class DealershipNode{
        private String name;
        private DealershipNode nextMake;
        private CarNode carDetails = new CarNode();
    }
    
    private class CarNode{
        private String reg;
        private String model;
        private String colour;
        private CarNode nextCar;
    }
    
    private DealershipNode make;
    private DealershipNode current;
    
    protected Dealership(String carMake){
        this.make = new DealershipNode();
        this.make.name = carMake;
        this.current = this.make;
    }
    
    public void addMake(String carMake){
        DealershipNode newMake = new DealershipNode();
        newMake.name = carMake;
        
        if (this.current.nextMake == null){
            this.current.nextMake = newMake;
        }else{
            DealershipNode currentMake = this.current.nextMake;
            while(currentMake.nextMake != null){
                currentMake = currentMake.nextMake;
            }
            currentMake.nextMake = newMake;
        }
    }
    
    public void search(String carMake){
        this.current = this.make;
        
        if(carMake.equals(this.make.name)){
            make = this.make;
            System.out.println("\nSuccess! \n" + "'" + carMake.toUpperCase() + "'" + " Found\n");
            this.current = make;
        }else if(this.make.nextMake == null){
            System.out.println("Not Found");
        }else{
            make = this.make.nextMake;
            
            while (make != null){
                
                if(carMake.equals(make.name)){                   
                   System.out.println("\nSuccess! \n" + "'" + carMake.toUpperCase() + "'" + " Found\n");
                }
                make = make.nextMake;
            }
            this.current = make;
        }
    }
    
    public void addCar(String carReg, String carColour, String carModel){
        CarNode newCar = new CarNode();
        newCar.reg = carReg;
        newCar.colour = carColour;
        newCar.model = carModel;
        
//        if (this.current.carDetails == null){
//            this.current.carDetails = newCar;
////        }else{
////            DealershipNode currentCar = this.current.carDetails;
////            while(currentMake.nextMake != null){
////                currentMake = currentMake.nextMake;
////            }
////            currentMake.nextMake = newMake;
//        }
    }
    
//    public void remove(){
//        }
    
    public String toString(){
        String dealershipDetails = new String();
        this.current = this.make;
        
        dealershipDetails += this.current.name +"\n";
        DealershipNode nextMake = this.current.nextMake;
        
        if (this.current.nextMake == null){
            dealershipDetails += "\n";
        }
        else {
            while (nextMake != null){
                dealershipDetails += nextMake.name + "\n";
                
                nextMake = nextMake.nextMake;
            }
        }
        return dealershipDetails;
    }
    
        public String displayCars(){
        String carDetails = new String();
        CarNode current = this.current.carDetails;
        
        carDetails += "Reg: " + current.reg +"\n";
        carDetails += "Colour: " + current.colour +"\n";
        carDetails += "Model: " + current.model +"\n";
        
        if (current.nextCar == null){
            carDetails += "\n";
        }
        else {
            CarNode nextCar = current.nextCar;
            while (nextCar != null){
                carDetails += "\n";
                
                carDetails += "Reg: " + current.reg +"\n";
                carDetails += "Colour: " + current.colour +"\n";
                carDetails += "Model: " + current.model +"\n";
                
                nextCar = nextCar.nextCar;
            }
        }
        return carDetails;
    }
}


