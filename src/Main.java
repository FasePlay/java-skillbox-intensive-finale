import static java.lang.Thread.sleep;

public class Main {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {
        System.out.println(ANSI_BLUE + "Запуск программы по отправке скриншотов" + ANSI_RESET);

        System.out.println(ANSI_YELLOW + "Создание обьектов" + ANSI_RESET);
        Screenshots thread1 = new Screenshots();
        DropboxUpload thread2 = new DropboxUpload();
        sleep(2000);
        System.out.println(ANSI_GREEN + "Обьекты созданы!" + ANSI_RESET);

        System.out.println(ANSI_YELLOW + "Запуск потоков" + ANSI_RESET);
        sleep(2000);
        thread1.start();
        thread2.start();
        System.out.println(ANSI_GREEN + "Потоки запущены!" + ANSI_RESET);
    }
}