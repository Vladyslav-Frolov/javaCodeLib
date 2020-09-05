package info.vladyslav.codeLibrary.u01core.core_06_threads;

public class WalkTalk {
    public static void main(String[] args) {
// новые объекты потоков
        TalkThread talk = new TalkThread();
        Thread talk2 = new Thread(new TalkThread());
        Thread talk3 = new TalkThread(); // <-- самый предпочтительный вариант
        Thread walk = new Thread(new WalkRunnable());
// запуск потоков
        talk.start();
        talk2.start();
        talk3.start();
        walk.start();
// WalkRunnable w = new WalkRunnable(); // просто объект, не поток
// w.run(); или talk.run(); // выполнится метод, но поток не запустится!
    }
}