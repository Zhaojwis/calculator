import java.math.BigDecimal;

/**
 * @author zhao
 * @date 2024/9/4
 */
public class Main {

  public static void main(String[] args) {
    UndoRedoCalculator calculator = new UndoRedoCalculator();
    calculator.execute('+',new BigDecimal(100));
    calculator.execute('-',new BigDecimal(50));
    calculator.execute('*',new BigDecimal(2));
    calculator.execute('/',new BigDecimal(2));
    calculator.reverse();
    calculator.reverse();
    calculator.redo();
    System.out.println("打断redo！！");
    calculator.execute('+',new BigDecimal(200));
    calculator.reverse();
    calculator.redo();
    calculator.redo();//没有可重做的命令
  }
}
