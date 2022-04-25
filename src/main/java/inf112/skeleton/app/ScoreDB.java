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


    public ScoreDB(List<mainPlayer> players){
        this.players = players;
        this.scores = new ArrayList<>();
        create();
        read();
        write();
    }

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
