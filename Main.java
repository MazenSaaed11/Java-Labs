import java.io.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String fileName = args[0];
            if (!fileName.endsWith(".arxml"))
                throw new NotValidAutosarException("Not an arxml file");

            File file = new File(fileName);
            FileInputStream input = new FileInputStream(file);
            StringBuilder s = new StringBuilder();
            int x;
            boolean empty = true;
            while ((x = input.read()) != -1) {
                s.append((char) x);
                empty = false;
            }
            if (empty)
                throw new emptyAutosarFileException("Empty file");
            String code = s.toString();
            Scanner scanner = new Scanner(code);
            boolean before = true;
            StringBuilder b = new StringBuilder();
            StringBuilder a = new StringBuilder();
            ArrayList<Container> Containers = new ArrayList<Container>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("<CONTAINER")) {
                    String id = line.substring(line.indexOf("UUID=\""), line.indexOf("\">"));
                    line = scanner.nextLine();
                    String sName = line.substring(line.indexOf("<SHORT-NAME>"), line.indexOf("</SHORT-NAME>"));
                    line = scanner.nextLine();
                    String lName = line.substring(line.indexOf("<LONG-NAME>"), line.indexOf("</LONG-NAME>"));
                    Container c = new Container(id, sName, lName);
                    Containers.add(c);
                    before = false;
                    line = scanner.nextLine();
                } else {
                    if (before)
                        b.append((line + '\n'));
                    else
                        a.append((line + '\n'));
                }
            }
            String bef = b.toString();
            String aft = a.toString();
            Collections.sort(Containers);

            String outputFileName = fileName.substring(0, fileName.indexOf(".")) + "_mod.arxml";
            FileOutputStream outputStream = new FileOutputStream(outputFileName);
            outputStream.write(bef.getBytes());
            for (Container c : Containers)
                outputStream.write(c.toString().getBytes());
            outputStream.write(aft.getBytes());
        } catch (NotValidAutosarException c1) {
            System.out.println(c1);
        } catch (emptyAutosarFileException c4) {
            System.out.println(c4);
        } catch (FileNotFoundException c2) {
            System.out.println(c2);
        } catch (IOException c3) {
            System.out.println(c3);
        }
    }
}

class Container implements Comparable<Container> {
    private String UUID;
    private String Short_name;
    private String Long_name;

    public Container(String UUID, String short_name, String long_name) {
        this.UUID = UUID;
        Short_name = short_name;
        Long_name = long_name;
    }


    @Override
    public int compareTo(Container o) {
        return Short_name.compareTo(o.Short_name);
    }

    public String toString() {
        return (
                "<CONTAINER " + UUID + "\">\n"
                        + Short_name + "</SHORT-NAME>\n" +
                        Long_name + "</LONG-NAME>\n" +
                        "</CONTAINER>\n"
        );
    }
}

class NotValidAutosarException extends Exception{
    public NotValidAutosarException(String val) {
    }
}

class emptyAutosarFileException extends Exception {
    public emptyAutosarFileException(String val) {

    }
}