package app.entity.cars;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

//@Entity(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public Car() {
    }

    private PassportData passportData;
    private GeneralData generalData;
    private AdditionalData additionalData;
    private List<Driver> listDriver;
    private List<Photo> listPhoto;
    private ReglamentTO reglamentTO;
    private ChangeData changeData;

}
