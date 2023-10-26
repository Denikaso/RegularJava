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
    @ParameterizedTest
    @CsvSource({
            "d4a70f12-956d-4a00-9ec4-87e3b6760573, true",
            "12345678-4F2E-31b1-1e39-0698F20D5Aff, true",
            "00112233-4455-6677-8899-aAbBcCdDeEfF, true",
            "e02fd0e4-00fd-090A-ca30-0d00a0038ba0, true",
            "d4a70f12-956d-4a00-9ec4-87e3b67605730, false",
            "e02fd0e400fd090Aca300d00a0038ba0, false",
            "12345678-4F2E-31p1-1e39-0698K20D5Aff, false",
            "e02fd0e4-00fd-090A8-9e4-87e3b6760573, false"
    })
    public void testCorrectGuid(String guid, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, RJ.correctGuid(guid));
    }
    @ParameterizedTest
    @CsvSource({
            "http://www.example.com, true",
            "https://github.com/Denikaso, true",
            "https://theuselessweb.com/, true",
            "http://sub.example.net:8080/?query=test#anchor, true",
            "https://www.domain.org/?key1=value1&key2=value2, true",
            "http://test-site.info/path/page#section, true",
            "ftp://123.com, false",
            "www.com, false",
            "https://, false",
            "http://localhost:8080?query=test, false",
            "http://example.com/with space, false",
            "http://-example.com, false"
    })
    public void testCorrectURL(String url, boolean expectedResult) {
        Assertions.assertEquals(expectedResult, RJ.correctURL(url));
    }
}
