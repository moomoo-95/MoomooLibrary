package moomoo.library.media;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFprobe;

import java.io.IOException;

public class Ffmpeg {
    private static final String INPUT_PATH = "./src/main/resources/media/input.mp4";
    private static final String OUTPUT_PATH = "./src/main/resources/media/output.mp4";

    public Ffmpeg() {
    }

    public void convertToMp3() throws IOException {
        FFmpeg ffmpeg = new FFmpeg("/usr/local/bin/ffmpeg");
        FFprobe ffprobe = new FFprobe("/usr/local/bin/ffprobe");
    }
}
