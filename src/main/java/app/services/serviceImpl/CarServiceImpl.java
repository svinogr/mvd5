package app.services.serviceImpl;

import app.dao.CarDao;
import app.entity.cars.car.Car;
import app.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarDao carDao;

    @Override
    public Car getById(long id) {
        return carDao.getById(id);
    }

    @Override
    public Car create(Car car) {
        return carDao.create(car);
    }

    @Override
    public Car createUser(Car car) {
        return null;
    }

    @Override
    public boolean update(Car car) {
        return carDao.update(car);
    }

    @Override
    public boolean delete(Car car) {
        return false;
    }

    @Override
    public List<Car> getAllCars() {
        return null;
    }
}
