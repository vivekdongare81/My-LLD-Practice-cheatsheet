package com.lld.car_rental_system.VehicleFactoryPattern;


import com.lld.car_rental_system.CommonEnums.VehicleEnums.VehicleType;
import com.lld.car_rental_system.VehicleFactoryPattern.ConcreteVehicles.EconomyVehicle;
import com.lld.car_rental_system.VehicleFactoryPattern.ConcreteVehicles.LuxuryVehicle;
import com.lld.car_rental_system.VehicleFactoryPattern.ConcreteVehicles.SUVVehicle;;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType vehicleType, String registrationNumber, String model, double baseRentalPrice) {
        switch (vehicleType) {
            case ECONOMY:
                return new EconomyVehicle(registrationNumber, model, vehicleType,  baseRentalPrice);
            case LUXURY:
                return new LuxuryVehicle(registrationNumber, model, vehicleType, baseRentalPrice);
            case SUV:
                return new SUVVehicle(registrationNumber, model,vehicleType,  baseRentalPrice);
            default:
                throw new IllegalArgumentException("Unsupported vehicle type: " + vehicleType);
        }
    }
}
