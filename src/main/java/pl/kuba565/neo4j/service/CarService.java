package pl.kuba565.neo4j.service;

import org.springframework.stereotype.Service;
import pl.kuba565.neo4j.model.Car;
import pl.kuba565.neo4j.repository.CarRepository;

import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    public Optional<Car> findCarByIdWithoutLog(Long id) {
        return carRepository.findCarByIdWithoutLog(id);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
