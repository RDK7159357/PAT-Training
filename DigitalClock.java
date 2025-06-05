import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.IOException;

public class DigitalClock implements Runnable{

    private volatile boolean running = true;
    public  void run(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        while(running){
            LocalTime now = LocalTime.now();
            System.out.print("\r" + now.format(formatter)); // \r returns cursor to the start of the line
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("\nClock interrupted");
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of minutes: ");
        int n = sc.nextInt();
        System.out.println("Enter after how many min should the song play: ");
        DigitalClock obj = new DigitalClock();
        Thread clockThread = new Thread(obj);
        clockThread.start();
        sc.close();
        try {
            Thread.sleep(n * 60000); // Sleep for n seconds
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        obj.running = false; // Stop the clock

        System.out.println("\nClock Stopped");
        try{
            
             File soundFile = new File("Song.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            System.out.println("Song Started");
            // Play for 60 seconds
            Thread.sleep(60000);
            clip.stop(); // Stop after 1 minute
            System.out.println("Song Stopped");

        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
}
