import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Created by kelliejos on 3/30/16.
 */
public class StoryBlurbs {
    private String LosAngelesBlurb = "Upon arriving in Los Angeles, you’ll spend an exciting two days touring the city. " +
            "You’ll tour Beverly Hills and take a trip to walk beneath \nthe Hollywood sign. On the second day, you’ll " +
            "visit the La Brea tar pits and see wooly mammoth and saber tooth cats. You’ll then visit the Santa Monica \n" +
            "Pier before retiring for the night.\n";
    private String MontereyBlurb = "In Monterey you’ll go for a whale watching tour in Monterey Bay, followed by a walk " +
            "down the historic Cannery Row with all its boutique shops. \nYou’ll then drive to Big Sur and hike along the" +
            "trails of the beautiful coastal park. Finally, you’ll return to Monterey and relax with a fine seafood dinner " +
            "on the pier as \nyou watch the sun set over the bay.\n";
    private String SanFranciscoBlurb = "Upon arriving in San Francisco, you’ll get a chance to immerse yourself in the " +
            "beautiful city by taking a ride on the classic \ntrolley through downtown San Francisco followed by a guided " +
            "tour of Chinatown.  The second day of your trip you’ll visit Fisherman’s Wharf \nto observe the resident " +
            "sea life and browse through the quaint shops before enjoying a delicious sundae at the chocolate factory in " +
            "Ghiradelli Square.\n";
    private String NapaBlurb = "In Napa Valley you’ll tour some of the finest wineries in America. Visit the Francis Ford" +
            " Coppola Winery and get up close with props from some of his most well known movies. \nThen you’ll take a " +
            "scenic drive through the valley to Calistoga, where you’ll take a dip in the mineral springs and watch " +
            "California’s Old Faithful Geyser erupt up to eighty feet in the sky.\n";
    private String YosemiteBlurb = "Yosemite is a beautiful park with a bountiful array of things to do. You’ll hike the " +
            "scenic trails in the shadow of El Capitan and Half Dome, \nthen stand at the foot of the dramatic Yosemite " +
            "Falls before hiking up to stand at the top of the same waterfall.  On the second day of your stay in " +
            "\nYosemite, you’ll spend the day rafting the Merced River.\n";
    private String RedwoodsBlurb = "The biggest trees in the world grow in California and you’ll see the tallest of them " +
            "all in Redwood National Park. Take a ride in a car through the \nKlamath Tree, then hike down to the beach " +
            "and explore the tide pools.\n";
    private String TahoeBlurb = "Lake Tahoe has plenty to do no matter what time of year you visit. During your stay this " +
            "summer you’ll hike the trail from the shore of Emerald Bay up to \nMaggie’s Saddle.  Then take a boat ride " +
            "out onto the lake to enjoy its crystal blue waters.  The second day of your stay, you’ll spend time enjoying " +
            "the casinos in Reno, before \nenjoying a quiet evening on the beach watching the sun set over the mountains.\n";
    private String DeathValleyBlurb = "In Death Valley you’ll experience the harsh yet beautiful desert landscape of the " +
            "lowest point on land.  You’ll see the colorful rocks of the badlands \nand visit some of the eerie ghost " +
            "towns that serve as reminders of mining booms of the past.\n";
    /*************************************************/
    private String LosAngelesArtBlurb = "Upon arriving in Los Angeles, you’ll spend an exciting two days touring the city. " +
            "You’ll tour Beverly Hills and take a trip to walk beneath \nthe Hollywood sign. Afterwards, you'll visit the " +
            "Los Angeles County Museum of Art to see the finest collection of art in the city. You’ll then visit the " +
            "Santa Monica \nPier before retiring for the night.\n";
    private String MontereyArtBlurb = "In Monterey you’ll go for a whale watching tour in Monterey Bay, followed by a walk " +
            "down the historic Cannery Row with all its boutique shops. \n You'll drop into the Thomas Kinkade Gallery and" +
            " browse some of his final pieces.\n";
    private String SanFranciscoArtBlurb = "Upon arriving in San Francisco, you’ll get a chance to immerse yourself in the " +
            "beautiful city by taking a ride on the classic \ntrolley through downtown San Francisco followed by a guided " +
            "tour of Chinatown.  The second day of your trip you’ll visit the Presidio, \n followed by a trip to the Fine Art " +
            "Museum and the San Francisco Art Market.\n";
    private String NapaArtBlurb = "In Napa Valley you’ll tour some of the finest wineries in America. Visit the Francis Ford" +
            " Coppola Winery and get up close with props from some of his most well known movies. \nThen you’ll take a " +
            "scenic drive through the valley to Calistoga, where you’ll take a dip in the mineral springs and visit a " +
            "family run factory where they produce all natural hand-made soaps.\n";
    private String YosemiteArtBlurb = "Yosemite is a beautiful park with a bountiful array of things to do. You’ll hike the " +
            "scenic trails in the shadow of El Capitan and Half Dome, \nthen stand at the foot of the dramatic Yosemite " +
            "Falls before hiking up to stand at the top of the same waterfall.  On the second day of your stay in " +
            "\nYosemite, you’ll spend the day in a artist's workshop at the Yosemite Art Center, capturing yesterday's " +
            "experiences in watercolors, oil paints, or any other medium of your choice.\n";
    private String RedwoodsArtBlurb = "The biggest trees in the world grow in California and you’ll see the tallest of them " +
            "all in Redwood National Park. Take a ride in a car through the \nKlamath Tree, then join a photography club" +
            "as you discover the techniques professionals use when photgraphing these impressive giants.\n";
    private String TahoeArtBlurb = "Lake Tahoe has plenty to do no matter what time of year you visit. During your stay this " +
            "summer you’ll hike the trail from the shore of Emerald Bay up to \nMaggie’s Saddle.  Then take a boat ride " +
            "out onto the lake to enjoy its crystal blue waters.  The second day of your stay, you’ll spend time enjoying " +
            "visiting the local art boutiques.\n";
    private String DeathValleyArtBlurb = "In Death Valley you’ll experience the harsh yet beautiful desert landscape of the " +
            "lowest point on land.  You’ll see the colorful rocks of the badlands \nand visit the pottery workshops of " +
            "the locals and discover how to capture the natural beauty in pottery.\n";
    /***********************************/
    private String LosAngelesFishingBlurb = "Upon arriving in Los Angeles, you’ll spend an exciting two days touring the city. " +
            "You’ll tour Beverly Hills and take a trip to walk beneath \nthe Hollywood sign. On the second day, you’ll " +
            "visit the La Brea tar pits and see wooly mammoth and saber tooth cats. You’ll then visit the Santa Monica \n" +
            "Pier before retiring for the night.\n";
    private String MontereyFishingBlurb = "In Monterey you’ll go for a whale watching tour in Monterey Bay, followed by a walk " +
            "down the historic Cannery Row with all its boutique shops. \nYou’ll then join a chartered fishing boat to go " +
            "deep sea fishing in the fertile Bay waters. Finally, you’ll return to Monterey and relax with a fine seafood dinner " +
            "on the pier as \nyou watch the sun set over the bay.\n";
    private String SanFranciscoFishingBlurb = "Upon arriving in San Francisco, you’ll get a chance to immerse yourself in the " +
            "beautiful city by taking a ride on the classic \ntrolley through downtown San Francisco followed by a guided " +
            "tour of Chinatown.  The second day of your trip you’ll visit Fisherman’s Wharf \nto observe the resident " +
            "sea life and go out on a chartered fishing boat into San Francisco Bay.\n";
    private String NapaFishingBlurb = "In Napa Valley you’ll tour some of the finest wineries in America. Visit the Francis Ford" +
            " Coppola Winery and get up close with props from some of his most well known movies. \nThen you’ll spend some" +
            "time fishing for trout and salmon in the Russian River.\n";
    private String YosemiteFishingBlurb = "Yosemite is a beautiful park with a bountiful array of things to do. You’ll hike the " +
            "scenic trails in the shadow of El Capitan and Half Dome, \nthen stand at the foot of the dramatic Yosemite " +
            "Falls before hiking up to stand at the top of the same waterfall.  On the second day of your stay in " +
            "\nYosemite, you’ll spend the day fishing for rainbow trout in the Merced River.\n";
    private String RedwoodsFishingBlurb = "The biggest trees in the world grow in California and you’ll see the tallest of them " +
            "all in Redwood National Park. Take a ride in a car through the \nKlamath Tree, then hike down to the beach " +
            "and enjoy shore fishing from the rocky coast line.\n";
    private String TahoeFishingBlurb = "Lake Tahoe has plenty to do no matter what time of year you visit. During your stay this " +
            "summer you’ll hike the trail from the shore of Emerald Bay up to \nMaggie’s Saddle.  Then take a boat ride " +
            "out onto the lake to enjoy its crystal blue waters.  The second day of your stay, you’ll spend time enjoying " +
            "fishing for salmon and bass before \nenjoying a quiet evening on the beach watching the sun set over the mountains.\n";
    private String DeathValleyFishingBlurb = "In Death Valley you’ll experience the harsh yet beautiful desert landscape of the " +
            "lowest point on land.  You’ll see the colorful rocks of the badlands \nand visit some of the eerie ghost " +
            "towns that serve as reminders of mining booms of the past.\n";
    /****************************/

    private final Map<String, String> StoryList = new HashMap<String, String>() {{
        put("los angeles", LosAngelesBlurb);
        put("monterey", MontereyBlurb);
        put("san francisco", SanFranciscoBlurb);
        put("death valley", DeathValleyBlurb);
        put("redwoods", RedwoodsBlurb);
        put("napa", NapaBlurb);
        put("tahoe", TahoeBlurb);
        put("yosemite", YosemiteBlurb);
    }};

    private final Map<String, String> FishingStoryList = new HashMap<String, String>() {{
        put("los angeles", LosAngelesFishingBlurb);
        put("monterey", MontereyFishingBlurb);
        put("san francisco", SanFranciscoFishingBlurb);
        put("death valley", DeathValleyFishingBlurb);
        put("redwoods", RedwoodsFishingBlurb);
        put("napa", NapaFishingBlurb);
        put("tahoe", TahoeFishingBlurb);
        put("yosemite", YosemiteFishingBlurb);
    }};

    private final Map<String, String> ArtStoryList = new HashMap<String, String>() {{
        put("los angeles", LosAngelesArtBlurb);
        put("monterey", MontereyArtBlurb);
        put("san francisco", SanFranciscoArtBlurb);
        put("death valley", DeathValleyArtBlurb);
        put("redwoods", RedwoodsArtBlurb);
        put("napa", NapaArtBlurb);
        put("tahoe", TahoeArtBlurb);
        put("yosemite", YosemiteArtBlurb);
    }};

    private final Map<String, String> FreeMarkerList = new HashMap<String, String>() {{
        put("los angeles", "src/LosAngeles.ftl");
        put("monterey", "src/Monterey.ftl");
        put("san francisco", "src/SanFrancisco.ftl");
        put("death valley", "src/DeathValley.ftl");
        put("redwoods", "src/Redwoods.ftl");
        put("napa", "src/Napa.ftl");
        put("tahoe", "src/Tahoe.ftl");
        put("yosemite", "src/Yosemite.ftl");
    }};

    public String getStoryBlurb(String node, String interest) {
        if (interest.equals("arts")) {
            return ArtStoryList.get(node);
        } else if (interest.equals("fishing")) {
            return FishingStoryList.get(node);
        } else {
            return StoryList.get(node);
        }
    }

    public String getStoryPart(String prevNode, String currNode, int fishCnt, int hikingCnt, int artCnt,
                               String interest, int remainingTripLength, String destinationNode) {
        Configuration cfg = new Configuration();
        String currTemplate = FreeMarkerList.get(currNode);
        try {
            //Load template from source folder
            Template template = cfg.getTemplate(currTemplate);

            // Build the data-model
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("currNode", currNode);
            data.put("prevNode", prevNode);
            data.put("fishCnt", fishCnt);
            data.put("hikingCnt", hikingCnt);
            data.put("artCnt", artCnt);
            data.put("interest", interest);
            data.put("remainingTripLength", remainingTripLength);
            data.put("destinationNode", destinationNode);

            Writer out = new StringWriter();
            template.process(data, out);
            return out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return "Oops...something went wrong!";
    }
}
