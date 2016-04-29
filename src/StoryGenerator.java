import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by kelliejos on 3/29/16.
 */
public class StoryGenerator {
    final int maxTripLength = 10;
    int remainingTripLength = 10;
    int hikingCnt = 0;
    int artCnt = 0;
    int fishCnt = 0;
    private String startNode = "";
    private String endNode = "";
    private String interest = "hiking";
    String previousNode = "";
    String story = "";
    private StoryBlurbs storyBlurbs = new StoryBlurbs();
    private CityMaps cityMaps = new CityMaps();
    List<String> visitedNodes = new ArrayList<String>();
    private final String[] allNodes = {"los angeles", "monterey", "san francisco", "death valley", "redwoods", "napa", "tahoe", "yosemite"};

    public ArrayList<String> getPossibleNextPoints(String currentNode) {
        ArrayList<String> possibleDests = new ArrayList<String>();
        previousNode = currentNode;
        Map<String, Integer> currentEdges = cityMaps.getMapForNode(currentNode);

        for (String node : allNodes) {
            //Need to exclude the current node from the list of possible destinations, but get the cost of current node to destination
            //Need to exclude the previously visited nodes.
            //Need to pull the map for the possible destination and look up cost from that node to departure node
            int cost = currentEdges.get(node) + cityMaps.getMapForNode(node).get(node);
            Boolean alreadyVisited = visitedNodes.contains(node);
            if (cost < remainingTripLength && !alreadyVisited && !node.equals(currentNode) && !node.equals(endNode)) {
                possibleDests.add(node);
            }
        }
        if (possibleDests.isEmpty()) {
            possibleDests.add(endNode);
        }

        return possibleDests;
    }

    public String getStoryForNode(String previousNode, String node, int fishCnt, int hikingCnt, int artCnt,
                                  String interest, int remainingTripLength, String endNode) {
        String nodeStory = storyBlurbs.getStoryPart(previousNode, node, fishCnt, hikingCnt, artCnt, interest, remainingTripLength, endNode);

        return nodeStory;
    }

    public String getEndNode() {
        return endNode;
    }

    public void setEndNode(String endNode) {
        this.endNode = endNode;
    }

    public String getStartNode() {
        return startNode;
    }

    public void setStartNode(String startNode) {
        Map<String, Integer> nodeList = cityMaps.getMapForNode(startNode);
        story += storyBlurbs.getStoryPart(previousNode, startNode, fishCnt, hikingCnt, artCnt, interest, remainingTripLength, endNode);
        visitedNodes.add(startNode);
        remainingTripLength -= nodeList.get(startNode);
        this.startNode = startNode;
    }

    public String getStory() {
        return story;
    }


    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }


    public static void main(String[] args) throws IOException {
        StoryGenerator storyGenerator = new StoryGenerator();
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> destList;

        initialSetup(storyGenerator, bufferReader);
        System.out.println(storyGenerator.storyBlurbs.getStoryBlurb(storyGenerator.startNode, storyGenerator.interest));
        String currentNode = storyGenerator.startNode;
        String nextNode;
        String addToPlan;
        Boolean timeRemaining = true;

        while (timeRemaining) {
            destList = storyGenerator.getPossibleNextPoints(currentNode);
            if (destList.size() > 1) {
                do {
                    nextNode = getUsersChoice(storyGenerator, destList);
                    System.out.println(storyGenerator.getStoryForNode(currentNode, nextNode, storyGenerator.fishCnt,
                            storyGenerator.hikingCnt, storyGenerator.artCnt, storyGenerator.interest,
                            storyGenerator.remainingTripLength, storyGenerator.endNode));
                    System.out.println("Do you want to add " + nextNode + " to your travel plan? Select: 1) Yes 2) No");
                    addToPlan = bufferReader.readLine().toLowerCase();
                    if(!addToPlan.equals("yes")) {
                        System.out.println("No problem! Let's try a different location.\n");
                    }
                } while (!addToPlan.equals("yes"));
                System.out.println("Great! I'll add that to your trip plan!\n");
            } else {
                nextNode = storyGenerator.endNode;
                System.out.println("\nThe next day it's time to head to your final destination. You will drive from " +
                        currentNode + " to " + nextNode + ".\n");
                System.out.println(storyGenerator.getStoryForNode(currentNode, nextNode, storyGenerator.fishCnt,
                        storyGenerator.hikingCnt, storyGenerator.artCnt, storyGenerator.interest,
                        storyGenerator.remainingTripLength, storyGenerator.endNode));
                timeRemaining = false;
            }
            storyGenerator.moveToNextNode(currentNode, nextNode);
            currentNode = nextNode;
        }
        System.out.println("Would you like to see your complete travel story? Select 1) Yes 2) No");
        String response = bufferReader.readLine().toLowerCase();
        if (response.equals("yes") || response.equals("1")) {
            System.out.println("\nHere's your completed vacation story. Enjoy!!\n\n" + storyGenerator.story);
        }
    }

    private void moveToNextNode(String currentNode, String nextNode) {
        visitedNodes.add(nextNode);
        Map<String, Integer> currMap = cityMaps.getMapForNode(nextNode);
        int cost = currMap.get(currentNode) + currMap.get(nextNode);
        remainingTripLength -= cost;
        story += "\nThe next morning, you will drive from " + currentNode + " to " + nextNode + ".\n";
        story += getStoryForNode(currentNode, nextNode, fishCnt, hikingCnt, artCnt, interest, remainingTripLength, endNode);
    }

    private static String getUsersChoice(StoryGenerator storyGenerator, ArrayList<String> destList) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String choices = "";
        String selection = "";
        String userChoice = "";

        int i = 1;

        for (String node : destList) {
            choices += i + ") " + node + " ";
            i++;
        }

        do {
            System.out.println("Where would you like to go next in your trip?");
            System.out.println(choices);
            String response = bufferReader.readLine().toLowerCase();
            for(String option : destList){
                if(option.equals(response)){
                    selection = response;
                }
            }
            if(selection.equals("")){
                System.out.println("Sorry, I didn't get that. Please type the name of the type of destination you'd like to visit.");
            }
        } while (selection.equals(""));
        userChoice = getInterest(storyGenerator, bufferReader, selection);
        storyGenerator.setInterest(userChoice);
        return selection;
    }

    private static void initialSetup(StoryGenerator storyGenerator, BufferedReader scan) throws IOException {
        System.out.println("Hi! My name is Alyssa and I'm here to help you plan your perfect California vacation!");
        System.out.println("Together we'll map out the itinerary for your " + storyGenerator.maxTripLength + " day vacation. " +
                "As we choose destinations, I'll make sure that you have time to explore each spot and still be \non " +
                "time for your return flight.\n");
        String userChoice = "";
        do {
            System.out.println("In which city do you want to start your trip? Select 1) San Francisco or 2) Los Angeles");
            userChoice = scan.readLine().toLowerCase();
            if(!userChoice.equals("san francisco") && !userChoice.equals("los angeles")) {
                userChoice = "";
                System.out.println("Sorry, I didn't get that. Please select San Francisco or Los Angeles.");
            }
        } while (userChoice.equals(""));
        storyGenerator.setStartNode(userChoice);
        do {
            System.out.println("In which city do you want to end your trip? Select 1) San Francisco or 2) Los Angeles");
            userChoice = scan.readLine().toLowerCase();
            if(!userChoice.equals("san francisco") && !userChoice.equals("los angeles")) {
                userChoice = "";
                System.out.println("Sorry, I didn't get that. Please select San Francisco or Los Angeles.");
            }
        } while (userChoice.equals(""));
        storyGenerator.setEndNode(userChoice);
        userChoice = getInterest(storyGenerator, scan, storyGenerator.getStartNode());
        storyGenerator.setInterest(userChoice);
        System.out.println("Great! Let's start writing your vacation story together!\n");
    }

    private static String getInterest(StoryGenerator storyGenerator, BufferedReader scan, String node) throws IOException {
        String userChoice;
        do {
            System.out.println("What type of recreation are you interested in while in " + node +
                    "? Select 1) Arts or 2) Hiking 3) Fishing");
            userChoice = scan.readLine().toLowerCase();
            storyGenerator.setInterest(userChoice);
            if(userChoice.equals("arts")){
                storyGenerator.artCnt++;
            } else if(userChoice.equals("hiking")){
                storyGenerator.hikingCnt++;
            } else if(userChoice.equals("fishing")){
                storyGenerator.fishCnt++;
            } else {
                userChoice = "";
                System.out.println("Sorry, I didn't get that. Please type the name of the type of recreation you're interested in.");
            }
        } while (userChoice.equals(""));

        return userChoice;
    }
}
