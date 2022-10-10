import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

public class FileWriter {
    public static void writeFile(String filePath, Collection<String> lines) {
        Path path = Path.of(filePath);
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            System.out.println("Wystąpił błąd, dane nie zostały zapisane");
        }
    }
}
