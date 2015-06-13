/*************************************************************************
 *  Compilation:  javac -classpath .:jl1.0.jar MP3.java         (OS X)
 *                javac -classpath .;jl1.0.jar MP3.java         (Windows)
 *  Execution:    java -classpath .:jl1.0.jar MP3 filename.mp3  (OS X / Linux)
 *                java -classpath .;jl1.0.jar MP3 filename.mp3  (Windows)
 *  
 *  Plays an MP3 file using the JLayer MP3 library.
 *
 *  Reference:  http://www.javazoom.net/javalayer/sources.html
 *
 *
 *  To execute, get the file jl1.0.jar from the website above or from
 *
 *      http://www.cs.princeton.edu/introcs/24inout/jl1.0.jar
 *
 *  and put it in your working directory with this file MP3.java.
 *
 *************************************************************************/

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;

import javazoom.jl.player.Player;

public class MP3 {
	private Player player;
	public BufferedInputStream bis;

	// constructor that takes the name of an MP3 file
	public MP3() {
	}

	public void close() throws IOException {
		if (player != null)
			player.close();
	}

	// play the MP3 file to the sound card
	public void play(String filename) {
		try {
			InputStream stream = MP3.class.getClassLoader()
					.getResourceAsStream(filename);

			bis = new BufferedInputStream(stream);
			player = new Player(bis);

		} catch (Exception e) {
			System.out.println("Problem playing file " + filename);
			System.out.println(e);
		}

		// run in new thread to play in background
		new Thread() {
			public void run() {
				try {
					player.play();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}.start();

	}

	public static long calculateSongLength(String filename) {
		// File f = new File(filename);
		// InputStream stream = MP3.class.getClassLoader().getResourceAsStream(
		// filename);
		// AudioInputStream audioInputStream = null;
		// try {
		// audioInputStream = AudioSystem.getAudioInputStream(stream);
		// } catch (UnsupportedAudioFileException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// } catch (IOException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// AudioFormat format = audioInputStream.getFormat();
		// long frames = audioInputStream.getFrameLength();
		// double durationInSeconds = (frames + 0.0) / format.getFrameRate();
		// System.out.println(durationInSeconds);
		InputStream stream = MP3.class.getClassLoader().getResourceAsStream(
				filename);
		AudioInputStream stream2 = new AudioInputStream(stream, null, 0);
		float durationInMillis = 1000 * stream2.getFrameLength()
				/ stream2.getFormat().getFrameRate();
		System.out.println(durationInMillis);
		return 1000;
	}

	// test client
	public static void main(String[] args) throws IOException {

		calculateSongLength("music/1.mp3");
	}

}