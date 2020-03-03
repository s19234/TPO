package zad1;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;

public class Futil {
    public static void processDir(String dirName, String result){
        try {
            Files.walkFileTree(Paths.get(dirName), new HashSet<>(), 2, new FileVisitor<Path>(){
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return null;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    // odczytywanie
                    RandomAccessFile aFile = new RandomAccessFile(file.getFileName().toString(), "rw");
                    FileChannel inChannel = aFile.getChannel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int bytesRead = inChannel.read(buffer);
                    StringBuilder stringBuilder = new StringBuilder();
                    String input = null;
                    while(bytesRead != -1){
                        buffer.flip();
                        while(buffer.hasRemaining()){
                            stringBuilder.append((char)buffer.get());
                        }
                        buffer.clear();
                        bytesRead = inChannel.read(buffer);
                    }
                    aFile.close();

                    // zapisywanie
                    input = stringBuilder.toString();
                    byte[] inputBytes = input.getBytes();
                    ByteBuffer bufferWrite = ByteBuffer.wrap(inputBytes);
                    FileOutputStream fos = new FileOutputStream(result);
                    FileChannel fileChannel = fos.getChannel();
                    fileChannel.write(bufferWrite);
                    fileChannel.close();
                    fos.close();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return null;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return null;
                }
            });
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
