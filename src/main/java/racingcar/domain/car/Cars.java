package racingcar.domain.car;

import racingcar.domain.game.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;
    private Position maxCarPosition;
    public Cars() {
        cars = new ArrayList<>();
    }

    public Cars(List<String> carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName, 0));
        }
    }

    public void moveCars(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.moveCarPosition(movingStrategy);
        }
    }

    public List<String> getFarthestCarNames(){
        calculateMaxCarPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addIfPositionEqual(winners, car);
        }
        return winners;
    }

    private void calculateMaxCarPosition(){
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        maxCarPosition = new Position(maxPosition);
    }

    private void addIfPositionEqual(List<String> winners, Car car) {
        if(car.getPosition() == maxCarPosition.getPosition()) {
            winners.add(car.getName());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
