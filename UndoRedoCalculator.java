import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @date 2024/9/4
 */
public class UndoRedoCalculator extends BasicCalculator implements Command{

  private List<BigDecimal> lastNumList = new ArrayList<>();//最近操作数列表
  private List<Character> lastOptList = new ArrayList<>();//最近操作列表
  private int currentIndex = 0;

  @Override
  public void execute(char curOperator, BigDecimal num) {
    compute(curOperator,num);
    lastNumList.add(num);
    lastOptList.add(curOperator);
    currentIndex = lastOptList.size();
  }

  @Override
  public void reverse() {
    if(currentIndex>0){
      System.out.println("undo previous commands");
      int index = --currentIndex;
      BigDecimal undoNum = lastNumList.get(index);
      Character undoOpt = undo(lastOptList.get(index));
      compute(undoOpt,undoNum);
    }else{
      System.out.println("no undo commands!!");
    }
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

  @Override
  public void redo() {
    if(currentIndex < lastOptList.size()){
      System.out.println("redo command again");
      BigDecimal redoNum = lastNumList.get(currentIndex);
      Character redoOpt = lastOptList.get(currentIndex);
      compute(redoOpt,redoNum);
      currentIndex++;
    }else {
      System.out.println("no redo commands!!");
    }
  }
}
