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
	
}
