import java.io.File;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Medias { //banque de medias audios
	final JFXPanel fxPanel = new JFXPanel();
	Media intro = new Media(new File ("Ressources/Music/Awakening Will.mp3").toURI().toString());
	MediaPlayer player = new MediaPlayer(intro);//faire une fonction qui lie le media et le player
	Media getReady = new Media(new File("Ressources/System Voice DOA3/Get Ready.mp3").toURI().toString());
	MediaPlayer ready = new MediaPlayer(getReady);
	Media lvl1 = new Media(new File("Ressources/Music/Theme of Zero.mp3").toURI().toString());
	MediaPlayer niv1 = new MediaPlayer(lvl1);
	Media congrats = new Media(new File("Ressources/System Voice DOA3/Congratulations.mp3").toURI().toString());
	MediaPlayer congratulations = new MediaPlayer(congrats);
	Media perso = new Media(new File("Ressources/System Voice DOA3/Challenger Appears.mp3").toURI().toString());
	MediaPlayer pers = new MediaPlayer(perso);	
	Media lvl2 = new Media(new File("Ressources/Music/Boss Battle 1.mp3").toURI().toString());
	MediaPlayer niv2 = new MediaPlayer(lvl2);
	Media lvl3 = new Media(new File("Ressources/Music/Title Screen.mp3").toURI().toString());
	MediaPlayer niv3 = new MediaPlayer(lvl3);
	Media lvl4 = new Media(new File("Ressources/Music/Intro Music.wav").toURI().toString());
	MediaPlayer niv4 = new MediaPlayer(lvl4);
	
}
