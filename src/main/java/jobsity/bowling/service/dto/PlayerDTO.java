package jobsity.bowling.service.dto;

/**
* It contains the information related with bowling player.
*/
public class PlayerDTO {
  /**
   * Player name
   */
  private String name;

  public PlayerDTO(String name) {
    this.name = name;
  }
	/**
	* Returns value of name
	* @return
	*/
	public String getName() {
		return name;
	}

	/**
	* Sets new value of name
	* @param
	*/
	public void setName(String name) {
		this.name = name;
	}

  public String toString() {
    return String.format("Player:%s",this.name);
  }
}
