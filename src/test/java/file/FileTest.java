package file;

import lombok.extern.slf4j.Slf4j;
import moomoo.library.file.FileIO;
import moomoo.library.media.Ffmpeg;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

@Slf4j
public class FileTest {

    @Test
    public void FfmpegMergeTest() {
        String path = "./src/main/resources/parsingdata/test.txt";
        FileIO.writeFile(path, "안녕하세요gg\n");
        ArrayList<String> fileContext = FileIO.readFile(path);

        fileContext.forEach(line -> log.debug("{}", line));
    }
}
