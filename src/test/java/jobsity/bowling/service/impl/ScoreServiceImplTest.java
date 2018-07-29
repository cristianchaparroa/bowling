package jobsity.bowling.service.impl;


import java.util.Arrays;
import jobsity.bowling.service.dto.ThrowDTO;
import org.junit.Test;
import java.util.List;
import jobsity.bowling.service.dto.FrameDTO;
import org.mockito.InjectMocks;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mockito;
import jobsity.bowling.service.FrameService;
import org.mockito.Mock;

public class ScoreServiceImplTest {

    @Mock
    private FrameService frameService = Mockito.mock(FrameService.class);

    @InjectMocks
    private ScoreServiceImpl scoreService;

    @Before
    public void setup() {
      this.scoreService = new ScoreServiceImpl(frameService);
    }

    @Test
    public void calculateScore() {
        Assert.assertNull(this.scoreService.calculateScore(null));
    }
/*
    public int calculateSparkFrame(List<FrameDTO> frames, FrameDTO cf, int beforeResult) {
      return this.calculateFrame(frames, cf, 1, beforeResult);
    }





    public int calculateOpenFrame(List<FrameDTO> frames,FrameDTO f, int beforeResult) {
      return f.getNumber() == 1 ? f.getScore() : f.getScore() + beforeResult;
    }
*/
    @Test
    public void calculateOpenFrame() {
      // calculate a open frame como primer frame
      // calculate  with bad frames
      Assert.assertTrue(this.scoreService.calculateOpenFrame(null, null, 0) == 0);
      
    }

    @Test
    public void isNotCalculableFrame() {
      List<ThrowDTO> strikeThrows = Arrays.asList(new ThrowDTO[]{ new ThrowDTO("10",ThrowDTO.FIRST_THROW)});
      FrameDTO strike = new FrameDTO(FrameDTO.FIRST_FRAME, strikeThrows);

      List<FrameDTO> frames = Arrays.asList(new FrameDTO[]{strike});

      Assert.assertTrue(this.scoreService.isNotCalculableFrame(null,null));
      Assert.assertFalse(this.scoreService.isNotCalculableFrame(frames, strike));
    }
}
