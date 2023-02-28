package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobY = new Job();
        Job jobX = new Job();
        assertNotEquals(jobY.getId(), jobX.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency()instanceof CoreCompetency);
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert",job.getLocation().getValue());
        assertEquals("Quality control",job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality() {
            Job jobX = new Job();
            Job jobY = new Job();
            assertNotEquals(jobX, jobY);
            assertFalse(jobX.getId() == jobY.getId());

    }
@Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    char jobX = job.toString().charAt(0);
    char jobY = job.toString().charAt(job.toString().length()-1);
    assertEquals(jobX,'\n');
    assertEquals(jobY, '\n');
}
@Test
    public void testToStringContainsCorrectLabelsAndData(){
    Job job = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
String jobX = "\n" + "ID: 4" +
        "\n" + "Name: Product tester" +
        "\n" + "Employer: ACME" +
        "\n" + "Location: Desert" +
        "\n" + "Position Type: Quality control" +
        "\n" + "Core Competency: Persistence"+"\n";
assertEquals(jobX, job.toString());
    }
@Test
    public void testToStringHandlesEmptyField(){

        Job job = new Job ("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
    String jobX = "\n" + "ID: 1" +
            "\n" + "Name: Product tester" +
            "\n" + "Employer: Data not available" +
            "\n" + "Location: Desert" +
            "\n" + "Position Type: Data not available" +
            "\n" + "Core Competency: Persistence"+"\n";
    assertEquals(jobX, job.toString());
}
}