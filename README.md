Zadanie: kanały plikowe

Katalog {user.home}/TPO1dir  zawiera pliki tekstowe umieszczone w tym katalogu i jego różnych podkatalogach. Kodowanie plików to Cp1250.
Przeglądając rekursywnie drzewo katalogowe, zaczynające się od {user.home}/TPO1dir,  wczytywać te pliki i dopisywać ich zawartości do pliku o nazwie TPO1res.txt, znadującym się w katalogu projektu. Kodowanie pliku TPO1res.txt winno być UTF-8, a po każdym uruchomieniu programu plik ten powinien zawierać tylko aktualnie przeczytane dane z  plików katalogu/podkatalogow.

Poniższy gotowy fragment winien wykonać całą robotę:
      public class Main {
        public static void main(String[] args) {
          String dirName = System.getProperty("user.home")+"/TPO1dir";
          String resultFileName = "TPO1res.txt";
          Futil.processDir(dirName, resultFileName);
        }
      }
Uwagi:
pliku Main.java nie wolno w żaden sposób modyfikować,
trzeba dostarczyć definicji klasy Futil,
oczywiście, nazwa katalogu i pliku oraz ich położenie są obowiązkowe,
należy zastosować FileVisitor do przeglądania katalogu oraz kanały plikowe (klasa FileChannel) do odczytu/zapisu plików (bez tego rozwiązanie nie uzyska punktów).
w wynikach testów mogą być przedstawione dodatkowe zalecenia co do sposobu wykonania zadania (o ile rozwiązanie nie będzie jeszcze ich uwzględniać),.

Task: file channels
Directory {user.home}/TPO1dir contains text files placed in this directory and its subdirectories. Files encoding is Cp1250.
Recursively looking through the directory tree, starting with {user.home}/TPO1dir, load those files and save theirs text to the file
named TPO1res.txt, placed in project directory. TPO1res.txt encoding should be UTF-8, and after every project start this file should contain only text read from directory/subdirectories.

Following piece of code should do all the work:
      public class Main {
        public static void main(String[] args) {
          String dirName = System.getProperty("user.home")+"/TPO1dir";
          String resultFileName = "TPO1res.txt";
          Futil.processDir(dirName, resultFileName);
        }
      }
Remarks:
file Main.java mustn't be modified under any circumstances,
definition of the class Futil should be delivered,
and of course, directory name and file and their place are mandatory,
class FileVisitor should be used to search the directory and file channels (class FileChannel) for reading from/ writing to the file(s)
(without these project won't be tested).
In tests score might be shown additional requests regarding the way task should be done( unless the project already does what is requested),.
