package com.DesignPatterns.Structural;

public class Adapter {

	//Use Case: Connect 2 untreleated interf
	//Eg: Media Player adv MediaPlyr
	
	public static void main(String[] args) {
	     AudioPlayer audioPlayer = new AudioPlayer();

	     audioPlayer.play("mp3", "beyond_the_horizon.mp3");
	     audioPlayer.play("mp4", "alone.mp4");
	     audioPlayer.play("vlc", "far_far_away.vlc");
	     audioPlayer.play("avi", "mind_me.avi");
	 }
	
	
	

}

//Target interface
interface MediaPlayer {
 void play(String audioType, String fileName);
}

//Adaptee class with a different interface
class AdvancedMediaPlayer {
 void playVlc(String fileName) {
     System.out.println("Playing vlc file. Name: " + fileName);
 }

 void playMp4(String fileName) {
     System.out.println("Playing mp4 file. Name: " + fileName);
 }
}

//Adapter class that implements the target interface and uses the adaptee
class MediaAdapter implements MediaPlayer {
 private AdvancedMediaPlayer advancedMusicPlayer;

 public MediaAdapter(String audioType) {
     if (audioType.equalsIgnoreCase("vlc")) {
         advancedMusicPlayer = new AdvancedMediaPlayer();
     } else if (audioType.equalsIgnoreCase("mp4")) {
         advancedMusicPlayer = new AdvancedMediaPlayer();
     }
 }

 @Override
 public void play(String audioType, String fileName) {
     if (audioType.equalsIgnoreCase("vlc")) {
         advancedMusicPlayer.playVlc(fileName);
     } else if (audioType.equalsIgnoreCase("mp4")) {
         advancedMusicPlayer.playMp4(fileName);
     }
 }
}

//Client class using the adapter
class AudioPlayer implements MediaPlayer {
 private MediaAdapter mediaAdapter;

 @Override
 public void play(String audioType, String fileName) {
     // Inbuilt support for mp3 music files
     if (audioType.equalsIgnoreCase("mp3")) {
         System.out.println("Playing mp3 file. Name: " + fileName);
     }
     // MediaAdapter is providing support to play other file formats
     else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
         mediaAdapter = new MediaAdapter(audioType);
         mediaAdapter.play(audioType, fileName);
     } else {
         System.out.println("Invalid media. " + audioType + " format not supported");
     }
 }
}
