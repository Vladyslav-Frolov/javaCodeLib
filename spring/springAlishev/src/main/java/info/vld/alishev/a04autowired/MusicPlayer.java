package info.vld.alishev.a04autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private ClassicalMusic classicalMusic;
    private RockMusic RockMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        RockMusic = rockMusic;
    }

    /*     //IoC

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public MusicPlayer() {
    }

    @Autowired
    public void setMusic(Music music) {
        this.music = music;
    }*/

    public String playMusic(){
//        System.out.println("Playing: " + classicalMusic.getSong());
//        System.out.println("Playing: " + RockMusic.getSong());
        return "Playing: " + classicalMusic.getSong() + "; " + RockMusic.getSong();
    }
}