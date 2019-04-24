

public class Dealership {
    
    private class DealershipNode{
        private String name;
        private DealershipNode nextMake;
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
    
//    public void remove(){
//        
//    }
    
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
}


