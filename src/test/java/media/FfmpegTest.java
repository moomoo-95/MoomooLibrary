package media;

import lombok.extern.slf4j.Slf4j;
import moomoo.library.media.Ffmpeg;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class FfmpegTest {

    @Test
    public void FfmpegMergeTest() {
        try {
            Ffmpeg.divideMp4();
        } catch (IOException e) {
            log.error("FfmpegTest.FfmpegMergeTest ", e);
        }

    }
}
