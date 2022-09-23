package moomoo.library.media;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

import java.io.IOException;

public class Ffmpeg {
    // input path 는 항상 절대경로
    private static final String INPUT_PATH = "/Users/lhs/Desktop/DEV/MoomooLibrary/src/main/resources/media/input.mp4";
    private static final String OUTPUT_PATH = "./src/main/resources/media/";

    public Ffmpeg() {
    }

    public static void divideMp4() throws IOException {
        FFmpeg ffmpeg = new FFmpeg("/usr/local/bin/ffmpeg");
        FFprobe ffprobe = new FFprobe("/usr/local/bin/ffprobe");

        //다음번 영상 merge 를 위해서 3개의 영상 생성
        for(int i = 0; i < 10; i = i + 3) {
            FFmpegBuilder builder = new FFmpegBuilder()
                    .overrideOutputFiles(true)
                    .addExtraArgs("-ss", "00:00:0" + i)
                    .addInput(INPUT_PATH)
                    .addExtraArgs("-t", "00:00:03")
                    .addOutput(OUTPUT_PATH + "output" + i + ".mp4")
                    .done();

            FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
            executor.createJob(builder).run();
        }

    }
}