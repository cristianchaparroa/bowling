package jobsity.bowling.service.dto;

import java.util.List;

/**
 * DashboardDTO contains information with bowling lines
 */
public class DashboardDTO {

  private List<LineDTO> lines;

  private boolean valid;

  public DashboardDTO() {

  }

  public DashboardDTO(List<LineDTO> lines) {
    this.lines = lines;
  }
	/**
	* Returns value of lines
	* @return
	*/
	public List<LineDTO> getLines() {
		return lines;
	}

	/**
	* Sets new value of lines
	* @param
	*/
	public void setLines(List<LineDTO> lines) {
		this.lines = lines;
	}

	/**
	* Returns value of valid
	* @return
	*/
	public boolean isValid() {
		return valid;
	}

	/**
	* Sets new value of valid
	* @param
	*/
	public void setValid(boolean valid) {
		this.valid = valid;
	}

  public String toString() {
    StringBuffer buffer = new StringBuffer();
    for (LineDTO l:this.lines) {
      buffer.append(String.format("%s\n",l));
    }
    return buffer.toString();
  }
}
