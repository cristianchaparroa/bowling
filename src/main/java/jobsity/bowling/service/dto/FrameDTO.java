package jobsity.bowling.service.dto;

import java.util.List;

/**
* It contains the information related with a bowling frame
*/
public class FrameDTO {
  /**
  * Maximun number of frames per Line
  */
  public static final int MAX_NUMBER_OF_FRAMES = 10;
  /**
  * First frame
  */
  public static final int FIRST_FRAME = 1;


  public final static int LAST_FRAME = 10;

  public final static String LAST_FRAME_STR = "10";
  /**
  * Number of current frame
  */
  private int number;
  /**
  * Throws int the current frame.
  */
  private List<ThrowDTO> throwz;
  /**
  * Score for frame
  */
  private int score;
  /**
  * Score total including before and next result according with the frame type
  */
  private int result;

  public FrameDTO() {}

  public FrameDTO(int number) {
    this.number = number;
  }

  public FrameDTO(int number,List<ThrowDTO> trows) {
    this.number = number;
    this.throwz = trows;
  }

  @Override
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    buffer.append(String.format("Frame number:%s, Score:%s\n",this.number,this.score));
    for (ThrowDTO t:this.throwz) {
      buffer.append(String.format("\t%s\n", t));
    }
    buffer.append(String.format("\tTotal:%s\n\n",this.result));
    return buffer.toString();
  }


	/**
	* Returns value of number
	* @return
	*/
	public int getNumber() {
		return number;
	}
	/**
	* Sets new value of number
	* @param
	*/
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	* Returns value of throwz
	* @return
	*/
	public List<ThrowDTO> getThrowz() {
		return throwz;
	}

	/**
	* Sets new value of throwz
	* @param
	*/
	public void setThrowz(List<ThrowDTO> throwz) {
		this.throwz = throwz;
	}

	/**
	* Returns value of score
	* @return
	*/
	public int getScore() {
		return score;
	}

	/**
	* Sets new value of score
	* @param
	*/
	public void setScore(int score) {
		this.score = score;
	}

	/**
	* Returns value of result
	* @return
	*/
	public int getResult() {
		return result;
	}

	/**
	* Sets new value of result
	* @param
	*/
	public void setResult(int result) {
		this.result = result;
	}
}
