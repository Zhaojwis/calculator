import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @date 2024/9/4
 */
public class UndoRedoCalculator{
  private BasicCalculator basicCalculator = new BasicCalculator();
  private List<Command> commandList = new ArrayList<>();
  private int currentIndex = 0;

  /**
   * 计算
   * @param curOperator
   * @param num
   */
  public void calculate(char curOperator, BigDecimal num){
    Command command = new CalculatorCommand(curOperator,num,basicCalculator);
    command.execute();
    commandList.add(command);
    currentIndex++;
  }

  /**
   * 重做前几个命令
   * @param preCommandCount
   */
  public void redo(int preCommandCount){
    System.out.println(String.format("Redo previous %d commands",preCommandCount));
    for(int i=0;i<preCommandCount;i++){
      if(currentIndex < commandList.size()-1){
        ((Command) commandList.get(currentIndex++)).execute();
      }else {
        System.out.println("no redo commands!!");
      }
    }
  }

  /**
   * 撤销前几个命令
   * @param preCommandCount
   */
  public void undo(int preCommandCount){
    System.out.println(String.format("Undo previous %d commands",preCommandCount));
    for(int i=0;i<preCommandCount;i++){
      if(currentIndex>0){
        int index = --currentIndex;
        ((Command) commandList.get(index)).reverse();
      }else{
        System.out.println("no undo commands!!");
      }
    }
  }
}
