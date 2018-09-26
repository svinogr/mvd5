package app.dao.daoimpl;

import app.dao.CarDao;
import app.entity.cars.car.Car;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl extends BasicDaoImpl<Car> implements CarDao {
    public CarDaoImpl() {
        super(Car.class);
    }
}
