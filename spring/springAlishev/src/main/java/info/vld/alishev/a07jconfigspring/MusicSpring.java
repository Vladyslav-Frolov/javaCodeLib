package info.vld.alishev.a07jconfigspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MusicSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext contextJava = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        MusicPlayer musicPlayer = contextJava.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        ClassicalMusic classicalMusic1 = contextJava.getBean("classicalMusic", ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = contextJava.getBean("classicalMusic", ClassicalMusic.class);

        System.out.println(classicalMusic1 == classicalMusic2);
        contextJava.close();
    }
}
