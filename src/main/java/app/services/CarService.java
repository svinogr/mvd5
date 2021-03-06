package app.services;

import app.entity.cars.car.Car;

import java.util.List;

public interface CarService {
    Car getById(long id);

    Car create(Car car);

    Car createUser(Car car);

    boolean update(Car car);

    boolean delete(Car car);

    List<Car> getAllCars();

}
