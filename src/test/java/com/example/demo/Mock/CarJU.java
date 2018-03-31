package com.example.demo.Mock;

import com.example.demo.domain.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarJU {

    Car car;

    @Mock
    private CarRepository carRepository;

    @Before
    public void setUp() {
        car = new Car();
        car.setId((long) 1);
        car.setModel("model");
        when(carRepository.count()).thenReturn((long) 1);
        when(carRepository.getCarById((long) 1)).thenReturn(car);
    }


    @Test
    public void testMockPersonRetrieval() {
        Assert.assertEquals("model",
                carRepository.getCarById((long) 1).getModel());
    }

    @Test
    public void testThatMockRepositorySaveDoesNothing() {
        Assert.assertEquals(1, this.carRepository.count());
        Car car2 = new Car();
        car.setId((long) 2);
        car.setModel("model");
        carRepository.save(car2);
        Assert.assertNotEquals(2, this.carRepository.count());
    }
}
