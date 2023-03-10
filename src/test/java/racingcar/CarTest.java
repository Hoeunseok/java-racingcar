package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class Car {
    private static final int DEFAULT_POSITION = 0;

    private Name name;
    private int position;

    public Car(String name) {
        this(name , DEFAULT_POSITION); // Channing
    }

    public Car(final Name name, final int position) {
        this(new Name(name), position);
    }

    public Car(final Name name, final int position) {
        this.name = name;
        this.position = position;
    }

    public void changeName(final String name) {
        this.name = name;
    }

    public String get_carName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int current_position() {
        return position;
    }

    public void move(final int condition) {
        if(condition > 4)
            position++;
    }
}

public class CarTest {
    @DisplayName("자동차는 이름을 가진다")
    @ValueSource(strings = {"jason","Hossi"})
    @ParameterizedTest
    public void name(final String name) {
        final Car car = new Car(name, 10);
        assertThat(car.get_carName()).isEqualTo(name);
    }

    @DisplayName("자동차의 이름의 길이가 5글자를 넘으면 예외가 발생한다")
    @Test
    public void name() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()-> new Car("자동차의 이름은 5글자를 넘을수 없습니다", 10));
    }

    @DisplayName("자동차의 초기 위치는 0이다")
    @Test
    void position() {
        final Car car = new Car("jason");
        assertThat(car.getPosition()).isZero();
    }

    @DisplayName("자동차의 현재 위치를 알 수 있다")
    @Test
    void current_position() {
        final Car car = new Car("jason", 10);
        assertThat(car.current_position());
    }

    @DisplayName("자동차가 이동한다")
    @ValueSource(ints = {4,5,6,7,8,9})
    @ParameterizedTest
    void Move(final int condition) {
        final Car car = new Car("jason");
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 정지한다")
    @Test
    void stop(final int condition) {
        final Car car = new Car("jason");
        car.move(condition);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차 이름변경")
    @Test
    void change() {

    }
}
