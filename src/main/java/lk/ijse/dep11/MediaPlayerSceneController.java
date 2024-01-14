package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.io.File;

public class MediaPlayerSceneController {
    public AnchorPane root;
    public MenuBar mnbMenuBar;
    public Menu mniMedia;
    public Menu mniAudio;
    public Menu mniVideo;
    public Menu mniSubtitle;
    public Menu mniHelp;
    public ProgressBar pb1;
    public Button btnPaused;
    public Button btnBack;
    public Button btnStop;
    public Button btnNext;
    public Label lblStarting;
    public Label lblEnding;
    public MediaView mvPlayer;

    MediaPlayer mediaPlayer;

    public void initialize(){
        MenuItem openFile = new MenuItem("Open File");
        MenuItem quite = new MenuItem("Quite");
        mniMedia.getItems().remove(0);
        mniMedia.getItems().addAll(openFile,quite);

        MenuItem increaseVolume = new MenuItem("Increase Volume");
        MenuItem decreaseVolume = new MenuItem("Decrease Volume");
        MenuItem mute = new MenuItem("Mute");
        mniAudio.getItems().remove(0);
        mniAudio.getItems().addAll(increaseVolume,decreaseVolume,mute);

        MenuItem fullScreen = new MenuItem("Full Screen");
        mniVideo.getItems().remove(0);
        mniVideo.getItems().add(fullScreen);

        MenuItem subTitleAdd = new MenuItem("Add Subtitle");
        mniSubtitle.getItems().remove(0);
        mniSubtitle.getItems().add(subTitleAdd);

        MenuItem help = new MenuItem("Help");
        MenuItem about = new MenuItem("About");
        mniHelp.getItems().remove(0);
        mniHelp.getItems().addAll(help,about);

        openFile.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Video & Audio",
                    "*.mp3","*.wav","*.avi","*.mp4","*.mkv"));

            File mediaFile = fileChooser.showOpenDialog(root.getScene().getWindow());

            if(mediaFile!=null){
                Media media = new Media(mediaFile.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
            }


            if(mediaPlayer!=null){
                mvPlayer.setMediaPlayer(mediaPlayer);
                mediaPlayer.play();
            }

        });
    }

    public void btnPausedOnAction(ActionEvent actionEvent) {
        if(mediaPlayer!=null){
            if(mediaPlayer.getStatus()== MediaPlayer.Status.PLAYING){
                mediaPlayer.pause();
            } else {
                mediaPlayer.play();
            }
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
    }

    public void btnStopOnAction(ActionEvent actionEvent) {
    }

    public void btnNextOnAction(ActionEvent actionEvent) {
    }
}
