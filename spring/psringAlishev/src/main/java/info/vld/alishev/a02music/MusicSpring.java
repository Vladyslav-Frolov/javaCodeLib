package info.vld.alishev.a02music;

import info.vld.alishev.a01test.TestBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MusicSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContextMusic.xml"
        );

        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        boolean comparison = firstMusicPlayer == secondMusicPlayer;

        System.out.println(comparison);

        System.out.println(firstMusicPlayer);
        System.out.println(secondMusicPlayer);

        firstMusicPlayer.setVolume(10);

        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());


//       Music music = context.getBean("musicBean", Music.class);

//       MusicPlayer musicPlayer = new MusicPlayer(music);

/*        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playListMusic();

        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());*/

        context.close();
    }
}
