import java.math.BigDecimal;

/**
 * @author zhao
 * @date 2024/9/4
 */
public class CalculatorCommand extends Common {

  private char curOperator;
  private BigDecimal num;
  private BasicCalculator basicCalculator;

  public CalculatorCommand(char curOperator, BigDecimal num, BasicCalculator basicCalculator) {
    this.curOperator = curOperator;
    this.num = num;
    this.basicCalculator = basicCalculator;
  }

  @Override
  public void execute() {
    basicCalculator.compute(curOperator,num);
  }

  @Override
  public void reverse() {
    basicCalculator.compute(undo(curOperator),num);
  }

  private char undo(char preOperator){
    char undo= ' ';
    switch (preOperator){
      case '+':
        undo = '-';
        break;
      case '-':
        undo ='+';
        break;
      case '*':
        undo = '/';
        break;
      case '/':
        undo='*';
        break;
    }
    return undo;
  }
}
