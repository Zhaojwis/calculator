import java.math.BigDecimal;

/**
 * @author zhao
 * @date 2024/9/4
 */
public interface Command {

  void execute(char curOperator, BigDecimal num);
  void reverse();
  void redo();
}
