import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        try {
            String strSourcePath;
            String strDestPath;
            Path sourcePath;
            Path destPath;
            if (args.length > 1) {
                strSourcePath = args[0];
                strDestPath = args[1];
                sourcePath = Paths.get(strSourcePath);
                destPath = Paths.get(strDestPath);
            } else {
                Scanner console = new Scanner(System.in);
                do {
                    System.out.println("Введите путь до папки-источника:");
                    strSourcePath = console.nextLine();
                    sourcePath = Paths.get(strSourcePath);
                } while (!Files.exists(sourcePath) && !Files.isDirectory(sourcePath));
                do {
                    System.out.println("Введите путь до папки назначения:");
                    strDestPath = console.nextLine();
                    destPath = Paths.get(strDestPath);
                } while (!Files.exists(destPath) && !Files.isDirectory(destPath));
            }
            copyFolder(sourcePath, destPath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void copyFolder(Path pathSource, Path pathDest) throws IOException {
        Files.list(pathSource)
                .forEach(p -> {
                    try {
                        Files.copy(p.toAbsolutePath(), pathDest.resolve(p.getFileName()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        Files.list(pathSource)
                .filter(Files::isDirectory)
                .forEach(p -> {
                    try {
                        copyFolder(p.toAbsolutePath(), pathDest.resolve(p.getFileName()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
