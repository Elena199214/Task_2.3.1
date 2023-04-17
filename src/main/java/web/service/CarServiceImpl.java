package web.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Kia", 2019, "silver"));
        cars.add(new Car("Ford", 2013, "white"));
        cars.add(new Car("Nissan", 2015, "red"));
        cars.add(new Car("Lexus", 2020, "black"));
        cars.add(new Car("Audi", 2016, "blue"));
    }


    @Override
    public List<Car> getCars(int count) {
        return ((count > 0 && count < 5) ? cars.stream().limit(count).toList() : cars);
    }
}

