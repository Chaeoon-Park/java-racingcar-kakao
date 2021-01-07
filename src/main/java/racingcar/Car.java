package racingcar;

import java.util.Objects;

public class Car {

    private Position position = new Position();
    private Name name;

    private Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return this.name.getName();
    }

    public void moveCarPosition(MovingStrategy movingStrategy) {
        if (movingStrategy.moveable()) {
            this.position = position.move();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
