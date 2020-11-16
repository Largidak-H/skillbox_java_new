import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Loader {
    static long longFolderSize = 0L;
    public static void main(String[] args) {
        try {
            String strPath ;
            if (args.length > 0) {
                strPath = args[0];
            } else {
                Scanner console = new Scanner(System.in);
                System.out.println("Введите путь до папки:");
                strPath = console.nextLine();
            }
            Path path = Paths.get(strPath);
            if (Files.exists(path) && Files.isDirectory(path)) {
                getSizeOfFolder(path);
                HashMap <Double, String> folderSizeAndUnit  = getSizeAndUnit(longFolderSize);
                System.out.printf("Размер папки %1s составляет %2.1f%3s.%n", strPath,
                        folderSizeAndUnit.keySet().iterator().next(), folderSizeAndUnit.values().iterator().next());
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

    public static HashMap<Double, String> getSizeAndUnit(Long longSize) {
        HashMap<Double, String> sizeAndUnit = new HashMap<>();
        if (longSize > Math.pow(1024,3)) {
            sizeAndUnit.put ((longSize / Math.pow(1024, 3)),"Гб");
        }
        else if (longSize > Math.pow(1024,2)) {
            sizeAndUnit.put ((longSize / Math.pow(1024, 2)),"Мб");
        }
        else if (longSize > Math.pow(1024,1)) {
            sizeAndUnit.put ((longSize / Math.pow(1024, 1)),"Кб");
        } else {
            sizeAndUnit.put ((double) longSize ,"Б");
        }
        return sizeAndUnit;
    }
}
