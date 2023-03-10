package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class test {
    @Test
    void split() {
        final java.lang.String[] actual = "1,2".split(",");
        // actual contains [1, 2]
        System.out.println(Arrays.toString(actual));
        assertThat(actual).containsExactly("1","2");
    }

    @Test
    void split2() {
        final java.lang.String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void split3() {
        final java.lang.String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void split4() {
        final char actual = "abc".charAt(2);
        assertThat(actual).isEqualTo('c');
    }
    @DisplayName("특정 위치의 문자를 가져올 때 위치값을 벗어나면 StringIndexOutOfBoundsException() 발생한다")
    @Test
    void split5() {
        final char actual = "abc".charAt(2);
//        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(()->"(1,2)".charAt(4));
    }

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @Test
    void collect1()
    {
        final int actual = numbers.size();
//        assertThat(numbers).hasSize(3);
    }

    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void collect2()
    {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

}
