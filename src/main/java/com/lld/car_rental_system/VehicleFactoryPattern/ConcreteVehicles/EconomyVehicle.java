package com.lld.car_rental_system.VehicleFactoryPattern.ConcreteVehicles;


import com.lld.car_rental_system.CommonEnums.VehicleEnums.VehicleType;
import com.lld.car_rental_system.VehicleFactoryPattern.Vehicle;

public class EconomyVehicle extends Vehicle {
    private static final double RATE_MULTIPLIER = 1.0;
    public EconomyVehicle(String registrationNumber, String model, VehicleType type, double baseRentalPrice) {
        super(registrationNumber, model, type, baseRentalPrice);
    }

    @Override
    public double calculateRentalFee(int days) {
        return getBaseRentalPrice() * days * RATE_MULTIPLIER;
    }
}
