package jobsity.bowling.service.dto;

/**
 * ThrowDTO contains the score and number of player throw.
 */
public class ThrowDTO {
  /**
  * It represents the first throw index
  */
  public final static int FIRST_THROW  = 1;
  /**
  * It represents the second throw index
  */
  public final static int SECOND_THROW = 2;
  /**
  * It represents the third throw index
  */
  public final static int THIRD_THROW  = 3;
  /**
  * It is the mark for foul throw.
  */
  public final static String FAULT_SCORE = "F";
  /**
  * This is the representation of ivalid score.
  */
  public final static int INVALID_SCORE = -1;
  /**
  * It is the number of throws allowed for the last frame;
  */
  public final static int NUMBER_OF_THROWS_FOR_LAST_FRAME = 3;
  /**
  * It's the int score for strike score
  */
  public final static int STRIKE_SCORE = 10;
  /**
  * It's the score for strike score
  */
  public final static String STRIKE_SCORE_STR = "10";

  /**
  * Maximun score per throw.
  */
  public final static int MAX_SCORE_PER_THROW = 10;

  /**
  * Maximun number of throws to get spark.
  */
  public final static int THROWS_PER_OPEN_FRAME = 2;

  /**
  * Maximun number of throws to get spark.
  */
  public final static int THROWS_PER_SPARK = 2;
  /**
  * Maximun number fo throws to get a strike.
  */
  public final static int THRWOS_PER_STRIKE =1;
  /**
  * The number of pines knocked
  */
  private String score;

  /**
   * This is the number of throws
   */
  private int index;

  public ThrowDTO() {}

  public ThrowDTO(String score,int index) {
    this.score = score;
    this.index = index;
  }
	/**
	* Returns value of score
	* @return
	*/
	public String getScore() {
		return score;
	}

	/**
	* Sets new value of score
	* @param
	*/
	public void setScore(String score) {
		this.score = score;
	}

	/**
	* Returns value of index
	* @return
	*/
	public int getIndex() {
		return index;
	}

	/**
	* Sets new value of index
	* @param
	*/
	public void setIndex(int index) {
		this.index = index;
	}

  /**
  * This is the string representation of throw.
  * @return String formated.
  */
  @Override
  public String toString() {
    return String.format("Throw(index:%s, score:%s)", this.index, this.score);
  }
}
