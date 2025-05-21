package com.mak;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WalkFS {

    private static final List<String> extensions = List.of("png", "jpeg");
    public static void main(String[] args) throws IOException {
        var path = "D:\\Coding\\test_1";
        int size = 2;
        for(int i = 0; i < 10 ; i++) {
            System.out.println("Page: " + i);
            try (var paths = Files.walk(Paths.get(path), 1)) {
                paths
                        .skip(1)
                        .filter(
                                t -> extensions.contains(extension(t.toString())) ||
                                        canConsider(t)

                        )
                        .skip((long) i * size)
                        .limit(size)
                        .map(Path::toString)
                        .forEach(System.out::println);
            }
        }

    }

    private static boolean canConsider(Path path) {
        if(Files.isDirectory(path)){
            try (var paths = Files.walk(path, 1)) {
                return  paths
                        .skip(1)
                        .anyMatch(t -> extensions.contains(extension(t.toString()))
                             || Files.isDirectory(t));
            }
            catch (IOException exception){
                return false;
            }
        }
        return false;
    }

    private static String extension(String path){
        if (path.lastIndexOf(".") != -1 && path.lastIndexOf(".") != 0) {
            return path.substring(path.lastIndexOf(".") + 1);
        }else
            return "";
    }

}
