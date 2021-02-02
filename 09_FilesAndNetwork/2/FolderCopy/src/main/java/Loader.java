import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {

        String strSourcePath;
        String strDestPath;
        Path sourcePath;
        Path destPath;
        if (args.length > 1) {
            strSourcePath = args[0];
            strDestPath = args[1];
            sourcePath = Paths.get(strSourcePath);
        } else {
            Scanner console = new Scanner(System.in);
            do {
                System.out.println("Введите путь до папки-источника:");
                strSourcePath = console.nextLine();
                sourcePath = Paths.get(strSourcePath);
            } while (!Files.exists(sourcePath) && !Files.isDirectory(sourcePath));
                System.out.println("Введите путь до папки назначения:");
                strDestPath = console.nextLine();
        }
        destPath = Paths.get(strDestPath);
        Path finalDestPath = destPath;
        Path finalSourcePath = sourcePath;
        try {
            Files.walkFileTree(sourcePath, EnumSet.of(FileVisitOption.FOLLOW_LINKS),
                    Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {

                        @Override
                        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                                throws IOException {
                            Path targetDir = finalDestPath.resolve(finalSourcePath.relativize(dir));
                            try {
                                Files.copy(dir, targetDir);
                            } catch (FileAlreadyExistsException e) {
                                if (!Files.isDirectory(targetDir))
                                    throw e;
                            }
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                                throws IOException {
                            Files.copy(file, finalDestPath.resolve(finalSourcePath.relativize(file)));
                            return FileVisitResult.CONTINUE;
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
