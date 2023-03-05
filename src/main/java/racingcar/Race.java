package racingcar;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Race {
    static int resultPosition;
    static void setPosition(Car getCar)
    {
        if(getCar.get_carPosition() > resultPosition)
            resultPosition = getCar.get_carPosition();
    }

    public static void main(String[] args) {
        List<Car> carList = new ArrayList<Car>();
        int carCnt = 0;
        int count = 0;
        int position = 0;

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.)");
        Scanner inName = new Scanner(System.in);
        String s_inName = inName.next();

        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner inCount = new Scanner(System.in);
        String s_count = inCount.next();

        String[] carArray = s_inName.split(",");
        carCnt = carArray.length;
        count = Integer.valueOf(s_count);
        resultPosition = 0;

        for(int i = 0; i < carCnt; i++)
        {
            Car racingCar = new Car();
            racingCar.set_carName(carArray[i]);
            carList.add(i, racingCar);
        }

        while(count > resultPosition)
        {
            for(int i = 0; i < carCnt; i++)
            {
                carList.get(i).move();
                setPosition(carList.get(i));
                System.out.println(carList.get(i).get_carName()+": "+carList.get(i).get_carPath());
            }
            System.out.println("");
        }
    }
}
