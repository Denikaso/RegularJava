import org.example.RegularJava;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
public class RegularTests {
    RegularJava RJ = new RegularJava();

    @ParameterizedTest
    @CsvSource({
            "192.168.1.1, true",
            "127.0.0.1, true",
            "10.10.0.0, true",
            "255.255.255.255, true",
            "172.16.1.1, true",
            "0.0.0.0, true",
            "300.500.700.900, false",
            "127.0.0.0.1, false",
            "256.0.1.1, false",
            "255.255.255.256, false",
            "255.255.255, false",
            "172.16..1, false"
    })
    public void testCorrectIP(String ip, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, RJ.correctIP(ip));
    }
}
