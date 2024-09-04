import java.math.BigDecimal;

/**
 * @author zhao
 * @date 2024/9/4
 */
public class Main {

  public static void main(String[] args) {
    UndoRedoCalculator calculator = new UndoRedoCalculator();
    calculator.calculate('+',new BigDecimal(100));
    calculator.calculate('-',new BigDecimal(50));
    calculator.calculate('*',new BigDecimal(2));
    calculator.calculate('/',new BigDecimal(2));
    calculator.undo(3);//撤销前4个命令

    calculator.redo(2);//再次执行前三个命令
    System.out.println("打断redo！！");
    calculator.calculate('+',new BigDecimal(200));
  }
}
