import org.junit.*;
import static org.junit.Assert.*;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(14, Yatzy.chance(new DiceRoll(1,1,3,3,6)));
        assertEquals(21, Yatzy.chance(new DiceRoll(4,5,5,6,1)));
    }

    @Test public void yatzy_scores_50() {
        assertEquals(50, Yatzy.yatzy(new DiceRoll(1,1,1,1,1)));
        assertEquals(0, Yatzy.yatzy(new DiceRoll(1,1,1,2,1)));
    }

    @Test public void ones() {
        assertEquals(2, Yatzy.ones(new DiceRoll(1,1,2,4,4)));
        assertEquals(1, Yatzy.ones(new DiceRoll(2,3,2,5,1)));
        assertEquals(0, Yatzy.ones(new DiceRoll(3,3,3,4,5)));
    }

    @Test
    public void twos() {
        assertEquals(4, Yatzy.twos(new DiceRoll(1,2,3,2,6)));
        assertEquals(10, Yatzy.twos(new DiceRoll(2,2,2,2,2)));
    }

    @Test
    public void test_threes() {
        assertEquals(6, Yatzy.threes(new DiceRoll(1,2,3,2,3)));
        assertEquals(12, Yatzy.threes(new DiceRoll(2,3,3,3,3)));
    }

    @Test
    public void fours() 
    {
        assertEquals(0, Yatzy.fours(new DiceRoll(1,1,6,2,6)));
        assertEquals(8, Yatzy.fours(new DiceRoll(1,1,2,4,4 )));
        assertEquals(4,  Yatzy.fours(new DiceRoll(4,5,5,5,5)));
    }

    @Test
    public void fives() {
        assertEquals(0, Yatzy.fives(new DiceRoll(4,4,4,3,2)));
        assertEquals(5, Yatzy.fives(new DiceRoll(4,4,5,1,3)));
        assertEquals(20, Yatzy.fives(new DiceRoll(4,5,5,5,5)));
    }

    @Test
    public void sixes() {
        assertEquals(0, Yatzy.sixes(new DiceRoll(4,4,4,5,5)));
        assertEquals(6, Yatzy.sixes(new DiceRoll(4,4,6,5,5)));
        assertEquals(18, Yatzy.sixes(new DiceRoll(6,5,6,6,5)));
    }

    @Test
    public void one_pair() {
        assertEquals(8, Yatzy.score_pair(new DiceRoll(3,3,3,4,4)));
        assertEquals(12, Yatzy.score_pair(new DiceRoll(1,1,6,2,6)));
        assertEquals(6, Yatzy.score_pair(new DiceRoll(3,3,3,4,1)));
        assertEquals(6, Yatzy.score_pair(new DiceRoll(3,3,3,3,1)));
    }

    @Test
    public void two_Pair() {
        assertEquals(8, Yatzy.two_pair(1,1,2,3,3));
        assertEquals(0, Yatzy.two_pair(1,1,2,3,4 ));
        assertEquals(6, Yatzy.two_pair(1,1,2,2,2));
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(9, Yatzy.three_of_a_kind(new DiceRoll(3,3,3,4,5)));
        assertEquals(0, Yatzy.three_of_a_kind(new DiceRoll(3,3,4,5,6)));
        assertEquals(9, Yatzy.three_of_a_kind(new DiceRoll(3,3,3,3,1)));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(8, Yatzy.four_of_a_kind(new DiceRoll(2,2,2,2,5)));
        assertEquals(0, Yatzy.four_of_a_kind(new DiceRoll(2,2,2,5,5)));
        assertEquals(8, Yatzy.four_of_a_kind(new DiceRoll(2,2,2,2,2)));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
    }

    @Test
    public void largeStraight() {
    	assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
    	assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouse() {
        assertEquals(8, Yatzy.fullHouse(1,1,2,2,2));
        assertEquals(0, Yatzy.fullHouse(2,2,3,3,4));
        assertEquals(0, Yatzy.fullHouse(4,4,4,4,4));
    }
}