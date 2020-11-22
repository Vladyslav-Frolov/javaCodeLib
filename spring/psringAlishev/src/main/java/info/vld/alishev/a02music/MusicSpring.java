package info.vld.alishev.a02music;

import info.vld.alishev.a01test.TestBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MusicSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContextMusic.xml"
        );

//       Music music = context.getBean("musicBean", Music.class);

//       MusicPlayer musicPlayer = new MusicPlayer(music);

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();

//        System.out.println(testBean.getName());

        context.close();
    }
}
