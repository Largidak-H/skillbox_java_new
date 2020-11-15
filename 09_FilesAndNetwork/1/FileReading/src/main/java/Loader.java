import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Loader {
    static long longFolderSize = 0L;
    public static void main(String[] args) {
        try {
            Scanner console = new Scanner(System.in);
            System.out.println("Введите путь до папки:");
            String strPath = console.nextLine();
            Path path = Paths.get(strPath);
            if (Files.exists(path) && Files.isDirectory(path)) {
                getSizeOfFolder(path);
                double folderSize;
                String unit;
                if (longFolderSize > Math.pow(1024,3)) {
                    folderSize = longFolderSize / Math.pow(1024, 3);
                    unit = "Гб";
                }
                else if (longFolderSize > Math.pow(1024,2)) {
                    folderSize = longFolderSize / Math.pow(1024, 2);
                    unit = "Мб";
                }
                else if (longFolderSize > Math.pow(1024,1)) {
                    folderSize = longFolderSize / Math.pow(1024, 1);
                    unit = "Кб";
                } else {
                    folderSize = longFolderSize;
                    unit = "Б";
                }
                System.out.printf("Размер папки %1s составляет %2.1f%3s.%n", strPath, folderSize, unit);
            }
            else {
                System.out.printf("Папки %s не существует.%n", strPath);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void getSizeOfFolder(Path path) throws IOException {
        List<Path> files = Files.list(path)
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());
        longFolderSize += files.stream().mapToLong(p -> p.toFile().length()).sum();
        List<Path> folders = Files.list(path)
                .filter(Files::isDirectory)
                .collect(Collectors.toList());
        if (!folders.isEmpty()) {
            folders.forEach(p -> {
                try {
                    getSizeOfFolder(p);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
