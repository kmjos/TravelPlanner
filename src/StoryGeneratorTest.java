import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kelliejos on 3/30/16.
 */
public class StoryGeneratorTest {

    @Test
    public void testGetPossibleNextPoints() throws Exception {
        StoryGenerator generator = new StoryGenerator();
        generator.setStartNode("los angeles");
        generator.setEndNode("san francisco");
        generator.remainingTripLength = 1;
        generator.visitedNodes = new ArrayList<String>();
        generator.visitedNodes.add("los angeles");
        generator.visitedNodes.add("tahoe");
        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("san francisco");
        ArrayList<String> destinations = generator.getPossibleNextPoints("tahoe");
        assertEquals(expectedResult, destinations);
    }

    @Test
    public void testGetPossibleNextPointsFromOrigin() throws Exception {
        StoryGenerator generator = new StoryGenerator();
        generator.setStartNode("los angeles");
        generator.setEndNode("san francisco");
        generator.remainingTripLength = 5;
        generator.visitedNodes = new ArrayList<String>();
        generator.visitedNodes.add("los angeles");
        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("monterey");
        expectedResult.add("death valley");
        expectedResult.add("redwoods");
        expectedResult.add("napa");
        expectedResult.add("tahoe");
        expectedResult.add("yosemite");
        ArrayList<String> destinations = generator.getPossibleNextPoints("los angeles");
        assertEquals(expectedResult, destinations);
    }

    @Test
    public void testGetStoryForNode() {
        StoryGenerator generator = new StoryGenerator();
        StoryBlurbs storyBlurbs = new StoryBlurbs();
        generator.setStartNode("los angeles");
        generator.setEndNode("san francisco");
        generator.previousNode = "los angeles";
        generator.setInterest("hiking");
        String story = generator.getStoryForNode("los angeles", "tahoe", 0, 4, 0, "hiking", 7, "san francisco");
        String expectedStory = "Having just spent two days in the bustling city, Tahoe's stunning mountain vistas are sure to be a treat.\n" +
                "What better place for you to continue your sight seeing vacation than Tahoe?\n" + "Lake Tahoe has plenty to do no matter what time of year you visit. During your stay this summer you’ll hike the trail\n" +
                "from the shore of Emerald Bay up to Maggie’s Saddle.  Then take a boat ride out onto the lake to enjoy its crystal\n" +
                "blue waters.\n" + "The second day of your stay, you’ll spend time enjoying the casinos in Reno, before enjoying a quiet\n" +
                "evening on the beach watching the sun set over the mountains.\n";
        assertEquals(expectedStory, story);
    }

    @Test
    public void testGetFreeMarkerStoryForNode() {
        StoryGenerator generator = new StoryGenerator();
        StoryBlurbs storyBlurbs = new StoryBlurbs();
        generator.setStartNode("los angeles");
        generator.setEndNode("san francisco");
        generator.previousNode = "los angeles";
        generator.setInterest("hiking");
        generator.hikingCnt = 4;
        String story = generator.getStoryForNode("los angeles", "tahoe", 0, 4, 0, "hiking", 7, "san francisco");
        String expectedStory = storyBlurbs.getStoryPart("los angeles", "tahoe", 0, 4, 0, "hiking", 7, "san francisco");
        assertEquals(expectedStory, story);
    }

    @Test
    public void testGetTotalStoryAtNode() {
        StoryGenerator generator = new StoryGenerator();
        StoryBlurbs storyBlurbs = new StoryBlurbs();
        generator.setStartNode("los angeles");
        generator.setEndNode("san francisco");
        generator.previousNode = "los angeles";
        generator.setInterest("hiking");
        String expectedStory = "Upon arriving in Los Angeles, you’ll spend an exciting two days touring the city. You’ll " +
                "tour Beverly Hills and\n" + "take a trip to walk beneath the Hollywood sign.\n" + "On the second day, " +
                "you’ll visit the La Brea tar pits and see woolly mammoth and saber tooth cats. You’ll then visit\n" +
                "the Santa Monica Pier before retiring for the night.\n";
        String story = generator.getStory();
        assertEquals(expectedStory, story);
    }
}