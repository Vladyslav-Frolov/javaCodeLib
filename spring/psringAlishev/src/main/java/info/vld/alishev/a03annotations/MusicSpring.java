package info.vld.alishev.a03annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MusicSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContextNewMusic.xml"
        );

        Music music = context.getBean("rockMusic", Music.class);

        MusicPlayer musicPlayer = new MusicPlayer(music);

        musicPlayer.playMusic();

        Music music2 = context.getBean("classicalMusic", Music.class);

        MusicPlayer musicPlayer2 = new MusicPlayer(music2);

        musicPlayer2.playMusic();

        context.close();
    }
}
