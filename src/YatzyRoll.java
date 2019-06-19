public class YatzyRoll {
	
	private DiceRoll diceRoll = null;
	private Category category = null;
	
	public YatzyRoll(int ...dice) {
		this.diceRoll = new DiceRoll(dice);
	}
	
	public YatzyRoll PlaceOn(Category category) throws Exception {
		if(this.category != null)
			throw new Exception("roll allready placed on category " + this.category);
		this.category = category;
		return this;
	}
	
	public int getScore() throws Exception {
		if(this.category == null)
			throw new Exception("Roll need to be place on category first !");
		int score = 0;
		switch (this.category) {
		case CHANCE:
			score = this.diceRoll.sumDiceValue();
			break;
		case YATZY:
			score = yatzy(this.diceRoll);
			break;
		case ONES:
			score = this.diceRoll.numberOf(1) * 1;
			break;
		case TWOS:
			score = this.diceRoll.numberOf(2) * 2;
			break;
		case THREES:
			score = this.diceRoll.numberOf(3) * 3;
			break;
		case FOURS:
			score = this.diceRoll.numberOf(4) * 4;
			break;
		case FIVES:
			score = this.diceRoll.numberOf(5) * 5;
			break;
		case SIXES:
			score = this.diceRoll.numberOf(6) * 6;
			break;
		case PAIR:
			score = score_pair(this.diceRoll);
			break;
		case TWO_PAIRS:
			break;
		case THREE_OF_A_KIND:
			score = three_of_a_kind(this.diceRoll);
			break;
		case FOUR_OF_A_KIND:
			score = four_of_a_kind(this.diceRoll);
			break;
		case SMALL_STRAIGHT:
			score = this.diceRoll.isAllDiceValueExistForRange(1, 5) ? 15 : 0;
			break;
		case LARGE_STRAIGHT:
			score = this.diceRoll.isAllDiceValueExistForRange(2, 6) ? 20 : 0;
			break;
		case FULL_HOUSE:
			score = fullHouse(this.diceRoll);
			break;
		default:
			break;
		}
		return score;
	}
    
    private static int score_pair(DiceRoll aDiceRoll)
    {
    	int score = 0;
    	Integer dieValue = aDiceRoll.findHighestMatchingDice(2);
    	if(dieValue != null)
    		score = dieValue * 2;
    	return score;
    }
    
    private static int three_of_a_kind(DiceRoll aDiceRoll)
    {
    	int score = 0;
    	Integer dieValue = aDiceRoll.findHighestMatchingDice(3);
    	if(dieValue != null)
    		score = dieValue * 3;
    	return score;
    }
    
    private static int four_of_a_kind(DiceRoll aDiceRoll)
    {
    	int score = 0;
    	Integer dieValue = aDiceRoll.findHighestMatchingDice(4);
    	if(dieValue != null)
    		score = dieValue * 4;
    	return score;
    }
    
    private static int yatzy(DiceRoll aDiceRoll)
    {
    	int score = 0;
    	Integer dieValue = aDiceRoll.findHighestMatchingDice(5);
    	if(dieValue != null)
    		score = 50;
    	return score;
    }

    private static int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    private static int fullHouse(DiceRoll aDiceRoll)
    {
    	Integer dieValueMatchingThreeTimes = aDiceRoll.findHighestMatchingDice(3);
    	Integer dieValueMatchingTwoTimes = aDiceRoll.findHighestMatchingDice(2);
    	if(dieValueMatchingThreeTimes != null && dieValueMatchingTwoTimes != null)
    		return dieValueMatchingThreeTimes * 3 + dieValueMatchingTwoTimes * 2;
		else
			return 0;
    }
}


