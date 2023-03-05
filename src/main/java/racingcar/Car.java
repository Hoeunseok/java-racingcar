package racingcar;
import java.util.Random;

public class Car {
    private String name;
    private int position;
    private StringBuffer path = new StringBuffer();
    private int ranNum = 0;
    private Random random = new Random();
    int set_carName(String input_name)
    {
        this.name = input_name;
        return 0;
    }
    String get_carName()
    {
        return this.name;
    }
    StringBuffer get_carPath()
    {
        return this.path;
    }
    int get_carPosition()
    {
        return this.position;
    }
    void move()
    {
        ranNum = random.nextInt(10);
        if(ranNum >= 4) {
            this.position++;
            path.append("ㅡ");
        }
    }
}
