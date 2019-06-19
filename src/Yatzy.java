public class Yatzy {

    public static int chance(DiceRoll aDiceRoll)
    {
        return aDiceRoll.sumDiceValue();
    }

    public static int ones(DiceRoll aDiceRoll) {
        return aDiceRoll.numberOf(1) * 1;
    }

    public static int twos(DiceRoll aDiceRoll) {
        return aDiceRoll.numberOf(2) * 2;
    }

    public static int threes(DiceRoll aDiceRoll) {
        return aDiceRoll.numberOf(3) * 3;
    }
    
    public static int fours(DiceRoll aDiceRoll) {
        return aDiceRoll.numberOf(4) * 4;
    }
    
    public static int fives(DiceRoll aDiceRoll) {
        return aDiceRoll.numberOf(5) * 5;
    }
    
    public static int sixes(DiceRoll aDiceRoll) {
        return aDiceRoll.numberOf(6) * 6;
    }

    
    public static int score_pair(DiceRoll aDiceRoll)
    {
    	int score = 0;
    	Integer dieValue = aDiceRoll.findHighestMatchingDice(2);
    	if(dieValue != null)
    		score = dieValue * 2;
    	return score;
    }
    
    public static int three_of_a_kind(DiceRoll aDiceRoll)
    {
    	int score = 0;
    	Integer dieValue = aDiceRoll.findHighestMatchingDice(3);
    	if(dieValue != null)
    		score = dieValue * 3;
    	return score;
    }
    
    public static int four_of_a_kind(DiceRoll aDiceRoll)
    {
    	int score = 0;
    	Integer dieValue = aDiceRoll.findHighestMatchingDice(4);
    	if(dieValue != null)
    		score = dieValue * 4;
    	return score;
    }
    
    public static int yatzy(DiceRoll aDiceRoll)
    {
    	int score = 0;
    	Integer dieValue = aDiceRoll.findHighestMatchingDice(5);
    	if(dieValue != null)
    		score = 50;
    	return score;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5)
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
    
    public static int smallStraight(DiceRoll aDiceRoll)
    {
    	if(aDiceRoll.isAllDiceValueExistForRange(1, 5))
            return 20;
    	else
    		return 0;
    }

    public static int largeStraight(DiceRoll aDiceRoll)
    {
        if(aDiceRoll.isAllDiceValueExistForRange(2, 6))
            return 20;
        else
        	return 0;
    }

    public static int fullHouse(DiceRoll aDiceRoll)
    {
    	Integer dieValueMatchingThreeTimes = aDiceRoll.findHighestMatchingDice(3);
    	Integer dieValueMatchingTwoTimes = aDiceRoll.findHighestMatchingDice(2);
    	if(dieValueMatchingThreeTimes != null && dieValueMatchingTwoTimes != null)
    		return dieValueMatchingThreeTimes * 3 + dieValueMatchingTwoTimes * 2;
		else
			return 0;
    }
}


