import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class WalkSearchFS {

    public static void main(String[] args) throws IOException {
        var loc = "D:\\";
        var path = Path.of(loc);
        var list = List.of("HTTP Request.jmx");
        try(var result = Files.find(path, Integer.MAX_VALUE,
                (path1, basicFileAttributes) -> basicFileAttributes.isRegularFile() && list.stream().anyMatch(t
                        -> path1.toString().endsWith(t))).filter(t -> !t.toString().contains("$"))){
            result.sorted(Comparator.comparingInt(o -> (o.getNameCount() - path.getNameCount())))
                    .forEach(System.out::println);
        }

    }

}
