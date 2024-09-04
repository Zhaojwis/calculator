import java.math.BigDecimal;
import java.math.RoundingMode;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author zhao
 * @date 2024/9/4
 * 
 */
public class BasicCalculator {
   private BigDecimal preTotal = new BigDecimal(0);
   private int scale = 2;//默认精度为小数点后2位
   public void compute(char curOperator,BigDecimal num){
      BigDecimal before = preTotal;
      switch (curOperator){
         case '+':
            preTotal = preTotal.add(num);
            break;
         case '-':
            preTotal = preTotal.subtract(num).setScale(scale, RoundingMode.HALF_UP);
            break;
         case '*':
            preTotal = preTotal.multiply(num).setScale(scale,RoundingMode.HALF_UP);
            break;
         case '/':
            preTotal = preTotal.divide(num,RoundingMode.HALF_UP);
            break;
      }
      System.out.println(before +"" + curOperator +num+"=" + preTotal);
   }



}
