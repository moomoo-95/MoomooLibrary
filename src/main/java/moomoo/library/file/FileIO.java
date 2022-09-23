package moomoo.library.file;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FileIO {
    private FileIO() {
        // nothing
    }

    public static ArrayList<String> readFile(String filePath){
        File file = new File(filePath);
        if(!file.exists() || !file.isFile()) {
            log.warn("{} do not exist. ", filePath);
            return null;
        }
        try(FileInputStream fileInputStream = new FileInputStream(filePath)) {
            StringBuilder stringBuilder = new StringBuilder(new String(fileInputStream.readAllBytes(), StandardCharsets.UTF_8));
            return new ArrayList<>(List.of(stringBuilder.toString().split("\n")));
        } catch (Exception e) {
            log.error("FileIO.readFile ", e);
            return null;
        }
    }

    public static void writeFile(String filePath, String context) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath, true)) {
            StringBuilder data = new StringBuilder();

            data.append(context);
            fileOutputStream.write(data.toString().getBytes(StandardCharsets.UTF_8));

            // 권한 설정
            Path path = Paths.get(filePath);
            Files.setPosixFilePermissions(path, PosixFilePermissions.fromString("rwxr-xr-x"));
        } catch (Exception e) {
            log.error("FileIO.writeFile ", e);
        }
    }
}
