package inf112.skeleton.app;

import objects.mainPlayer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ScoreDB {

    private List<mainPlayer> players;
    private File scoreDB;
    private PrintWriter printWriter;
    private List<Integer> scores;


    /**
     * Creates a file with the all-time top ten best scores
     * @param players
     */
    public ScoreDB(List<mainPlayer> players){
        this.players = players;
        this.scores = new ArrayList<>();
        create();
        read();
        write();
    }

    /**
     * creates a new file if it does not already exist
     */
    public void create() {
        try {
            scoreDB = new File("filename.txt");
            if (scoreDB.createNewFile()) {
                System.out.println("File created: " + scoreDB.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * 1. Adds the new scores to the list of scores
     * 2. Sorts the list in descending order and adds the first ten scores to topTen
     * @return top ten best scores
     */
    public List<Integer> getTopTen(){
        List<Integer> topTen = new ArrayList<>();
        for (mainPlayer player : players){
            if (player.isAlive())
                scores.add(player.getKillStreak());
        }
        Collections.sort(scores, Collections.reverseOrder());
        for (int score : scores){
            if (topTen.size() > 9)
                break;

            topTen.add(score);
        }
        return topTen;
    }

    /**
     * Writes the top ten best scores to the created or existing file
     */
    public void write(){
        try {
            printWriter = new PrintWriter("filename.txt");

            int count = 0;
            for (Integer score : getTopTen()){
                count++;
                printWriter.println(score + " kills");
            }
            printWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * adds the existing scores to a list
     */
    public void read(){
        try {
            Scanner myReader = new Scanner(scoreDB);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(" ");
                int score = Integer.parseInt(data[0]);
                scores.add(score);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
