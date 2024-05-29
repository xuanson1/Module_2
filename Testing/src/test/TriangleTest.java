package test;

import org.junit.jupiter.api.Test;
import file.Triangle;
public class TriangleTest {
    @Test
    public void testTest01(){
        int a = 0;
        int b = 1;
        int c = 2;

        String actual = "Dữ liệu không hợp lệ";
        String result = Triangle.checkTriangle(a,b,c);
        assert actual.equals(result);
    }
}
