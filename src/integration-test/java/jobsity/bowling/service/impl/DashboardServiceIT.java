package jobsity.bowling.service.impl;

import jobsity.bowling.service.DashboardService;
import jobsity.bowling.service.ScoreService;
import jobsity.bowling.service.dto.DashboardDTO;
import jobsity.bowling.service.dto.LineDTO;
import jobsity.bowling.service.dto.FrameDTO;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
    DashboardServiceImpl.class,
    FileServiceImpl.class,
    FrameServiceImpl.class,
    ThrowServiceImpl.class,
    LineServiceImpl.class,
    ValidationServiceImpl.class,
    ScoreServiceImpl.class})
public class DashboardServiceIT {

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private ScoreService scoreService;

    protected Logger logger = LoggerFactory.getLogger(ValidationServiceImpl.class);

    @Test
    public void processPerfectScore() {

      File perfectFile = new File(this.getClass().getResource("/perfect.txt").getFile());
      String pathFile  = String.format("%s",perfectFile.getAbsolutePath().toString());

      DashboardDTO dashboard = this.dashboardService.load(pathFile);
      Assert.assertNotNull(dashboard);
      Assert.assertTrue(dashboard.isValid());

      dashboard = this.scoreService.calculate(dashboard);
      Assert.assertNotNull(dashboard);
      LineDTO jeffLine      = dashboard.getLines().get(0);
      Assert.assertNotNull(jeffLine);

      List<FrameDTO> frames = jeffLine.getFrames();
      Assert.assertNotNull(frames);

      FrameDTO lastFrame    = frames.get(FrameDTO.MAX_NUMBER_OF_FRAMES - 1);
      Assert.assertNotNull(lastFrame);

      int expectedJeffScore = 300;
      Assert.assertTrue(lastFrame.getResult() == expectedJeffScore);
    }

    @Test
    public void processTwoPlyers() {
      File perfectFile = new File(this.getClass().getResource("/scores.txt").getFile());
      String pathFile  = String.format("%s",perfectFile.getAbsolutePath().toString());

      DashboardDTO dashboard = this.dashboardService.load(pathFile);
      Assert.assertNotNull(dashboard);
      Assert.assertTrue(dashboard.isValid());

      dashboard = this.scoreService.calculate(dashboard);
      Assert.assertNotNull(dashboard);
      LineDTO jeffLine      = dashboard.getLines().get(0);
      LineDTO johnLine      = dashboard.getLines().get(1);

      Assert.assertNotNull(jeffLine);
      Assert.assertNotNull(johnLine);

      List<FrameDTO> jeffFrames = jeffLine.getFrames();
      List<FrameDTO> johnFrames = johnLine.getFrames();

      Assert.assertNotNull(jeffFrames);
      Assert.assertNotNull(johnFrames);


      FrameDTO jeffLastFrame  = jeffFrames.get(FrameDTO.MAX_NUMBER_OF_FRAMES - 1);
      FrameDTO johnLastFrame  = johnFrames.get(FrameDTO.MAX_NUMBER_OF_FRAMES - 1);

      Assert.assertNotNull(jeffLastFrame);
      Assert.assertNotNull(johnLastFrame);

      int expectedJeffScore = 167;
      int expectedJhonScore = 151;

      Assert.assertTrue(jeffLastFrame.getResult() == expectedJeffScore);
      Assert.assertTrue(johnLastFrame.getResult() == expectedJhonScore);
    }

    @Test
    public void processZeroScore() {
      File perfectFile = new File(this.getClass().getResource("/zeros.txt").getFile());
      String pathFile  = String.format("%s",perfectFile.getAbsolutePath().toString());

      DashboardDTO dashboard = this.dashboardService.load(pathFile);
      Assert.assertNotNull(dashboard);
      Assert.assertTrue(dashboard.isValid());

      dashboard = this.scoreService.calculate(dashboard);
      Assert.assertNotNull(dashboard);

      LineDTO zeroLine      = dashboard.getLines().get(0);
      Assert.assertNotNull(zeroLine);

      List<FrameDTO> zeroFrames = zeroLine.getFrames();
      Assert.assertNotNull(zeroFrames);

      FrameDTO zeroLastFrame  = zeroFrames.get(FrameDTO.MAX_NUMBER_OF_FRAMES - 1);
      Assert.assertNotNull(zeroLastFrame);

      int expectedScore = 0;
      Assert.assertTrue(zeroLastFrame.getResult() == expectedScore);
    }
}
