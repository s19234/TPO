package zad1;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Futil {
    public static void processDir(String dirName, String resultFileName) {
        Path dir = Paths.get(dirName);
        File file = new File(resultFileName);
        Charset in = Charset.forName("Cp1250");
        Charset out = StandardCharsets.UTF_8;
        
        SimpleFileVisitor<Path> simpleFileVisitor = new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                if(file.exists())
                    file.delete();
                
                FileChannel fileIn = FileChannel.open(path);
                FileChannle fileOut = FileChannel.open(Paths.get(file.getPath));
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect((int)fileIn.size());
                
                fileIn.read(byteBuffer);
                byteBuffer.flip();
                CharBuffer charBuffer = in.decode(byteBuffer);
                
                byteBuffer = out.encode(charBuffer);
                fileOut.write(byteBuffer);
                
                return FileVisitResult.CONTINUE;
            }
        };
        try {
            Files.walkFileTree(dir, simpleFileVisitor);
        } catch(IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
