package info.vld.alishev.a03annotations;


import java.util.List;

public class MusicPlayer {
//    private Music music;
    private List<info.vld.alishev.a02music.Music> musicList;
    private Music music;
    private String name;
    private int volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

     //IoC
    public MusicPlayer(Music music) {
        this.music = music;
    }

    public MusicPlayer() {
    }

    public void setMusic(Music music) {
        this.music = music;
    }


    public List<info.vld.alishev.a02music.Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<info.vld.alishev.a02music.Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusic(){
        System.out.println("Playing: " + music.getSong());
    }

//    public void playListMusic(){
//        for (Music music : musicList) {
//            System.out.println(music.getSong());
//        }
//    }
}
