//*
//*
//stepTwo
//*
//*

public class Car {

    private CarNode carDetails = new CarNode();

    private class CarNode {

        private String reg;
        private String model;
        private String colour;
        private CarNode newCar;
    }

    private CarNode car;
    private CarNode current;
    private CarNode previous;
    private CarNode next;

    public void addCar(String carReg, String carColour, String carModel) {
        CarNode newCar = new CarNode();
        newCar.reg = carReg;
        newCar.colour = carColour;
        newCar.model = carModel;
        System.out.println("\n\tCar details entered:\n" + "\n\tReg: " + newCar.reg + "\n\tColour: " + newCar.colour + "\n\tModel: " + newCar.model + "\n");
        this.current = newCar;
    }

    @Override
    public String toString() {
        String carDetails = new String();
        CarNode current = this.current;
//        this.car = this.current;
        System.out.println("\t" + "'" + carDetails.toUpperCase() + "'" + " details:");
        carDetails += "\t\tReg: " + this.current.reg + "\n";
        carDetails += "\t\tColour: " + this.current.colour + "\n";
        carDetails += "\t\tModel: " + this.current.model + "\n";        

//        if (this.current.newCar == null) {
//        } else {
//            CarNode newCar = current.newCar;
//            while (newCar != null) {
//                carDetails += "\n";
//                carDetails += "Reg: " + current.reg + "\n";
//                carDetails += "Colour: " + current.colour + "\n";
//                carDetails += "Model: " + current.model + "\n";
//
//                newCar = newCar.newCar;
//            }
//        }
        return carDetails;
    }
}
