import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @date 2024/9/4
 */
public class UndoRedoCalculator{
  private BasicCalculator basicCalculator = new BasicCalculator();
  private List<Common> commonList = new ArrayList<>();
  private int currentIndex = 0;

  /**
   * 计算
   * @param curOperator
   * @param num
   */
  public void calculate(char curOperator, BigDecimal num){
    Common common = new CalculatorCommand(curOperator,num,basicCalculator);
    common.execute();
    commonList.add(common);
    currentIndex++;
  }

  /**
   * 重做前几个命令
   * @param preCommandCount
   */
  public void redo(int preCommandCount){
    System.out.println(String.format("Redo previous %d commands",preCommandCount));
    for(int i=0;i<preCommandCount;i++){
      if(currentIndex < commonList.size()-1){
        ((Common) commonList.get(currentIndex++)).execute();
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
        ((Common) commonList.get(index)).reverse();
      }else{
        System.out.println("no undo commands!!");
      }
    }
  }
}
