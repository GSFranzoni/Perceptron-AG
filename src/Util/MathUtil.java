
package Util;

public class MathUtil {
    
    public static Double erroQuadratico(Double yd, Double ya, int t) {
        return Math.pow(yd-ya, 2)/t;
    }
    
}
