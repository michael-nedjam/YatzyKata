import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DiceRoll {
	private List<Integer> listDiceValue;
	private int[] diceValue;
	private int numberDiceSide = 6;
	
	public DiceRoll(int ... diceValue) {
		this.listDiceValue = Arrays.stream(diceValue).boxed().collect(Collectors.toList());
		this.diceValue = diceValue;
	}	
	
	public int sumDiceValue() {
		return this.listDiceValue.stream().mapToInt(Integer::intValue).sum();
	}
	
	public int numberOf(int value) {
		return (int) listDiceValue.stream().filter(i -> i == value).count();
	}
	
	public Integer findHighestMatchingDice(int numberOfDice) {
		int[] numberOfValue = listNumberOfValue(this.diceValue, this.numberDiceSide);
		return findLastIndexForMinimunValue(numberOfValue, numberOfDice);
	}
	
	private Integer findLastIndexForMinimunValue(int[] values, int minimunValue) {
		Integer lastIndex = null;
		for(int i = values.length-1; i > 0; i--) {
			if(values[i] >= minimunValue) {
				lastIndex = i;
				break;
			}
		}	
		return lastIndex;
	}
	
	private int[] listNumberOfValue(int[] values, int maxValues) {
		int[] numberOfValue = new int[maxValues + 1];
		for(int value : values) 
			numberOfValue[value]++;
		return numberOfValue;
	}
	
	public boolean isAllDiceValueExistForRange(int fromValue, int toValue) {
		int[] numberOfValue = listNumberOfValue(this.diceValue, this.numberDiceSide);
		for(int value = fromValue; value <= toValue; value++) {
			if(numberOfValue[value]==0) 
				return false;
		}
		return true;
	}
}
