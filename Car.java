public class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void displayDetails() {
        System.out.printf("Car Make: %s%nCar Model: %s%nYear: %d%n", make, model, year);
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2022);
        Car car2 = new Car("Honda", "Civic", 2020);
        car1.displayDetails();
        System.out.println();
        car2.displayDetails();
    }
}
