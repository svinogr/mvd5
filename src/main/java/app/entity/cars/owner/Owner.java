package app.entity.cars.owner;

import app.entity.cars.car.Car;
import app.entity.cars.owner.GeneralOwner;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Car> listCars;

    //private GeneralOwner generalOwner;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
