package app.controllers.carcontrollers;

import app.entity.cars.car.Car;
import app.services.CarService;
import app.services.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/car/")
public class CarController {
    @Autowired
    CarService carService;

    @Autowired
    ValidService validService;

    /**
     * @param id       in bd
     * @param response 404 is not exist
     * @return json Car
     */
    @RequestMapping(value = "/{id}")
    public @ResponseBody
    Car getCarById(@PathVariable long id, HttpServletResponse response) {
        Car car = carService.getById(id);
        if (car != null) {
            response.setStatus(200);
        } else response.setStatus(404);

        return car;
    }


    /**
     * @param car
     * @param result
     * @param response 404 faild
     * @return json updated Car
     */
    @RequestMapping(value = "/{id}")
    public @ResponseBody
    Car update(@RequestBody @Valid Car car, BindingResult result, HttpServletResponse response) {
        if (result.hasErrors()) {
            return validService.validCar(car, result);
        }
        boolean updated = carService.update(car);
        if (updated) {
            response.setStatus(200);
        } else response.setStatus(404);
        return car;
    }

}
