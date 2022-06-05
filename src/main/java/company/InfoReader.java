package company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfoReader {
    public static Map<String, Map<Character, Integer>> INFO;
    public static int RACE_COUNT;
    public static int TYPES_COUNT;

    public static void setInfo(String url) throws IOException {
        List<String> stringList;
        INFO = new HashMap<>();
        try (Stream<String> lines = Files.lines(Paths.get(url))) { //поток из файла
            stringList = lines.collect(Collectors.toList()); //
            String[] numberInfo = stringList.get(0).split(" "); //берем первую строчку из листа
            RACE_COUNT= Integer.parseInt(numberInfo[0]);//3 - всего расы
            TYPES_COUNT= Integer.parseInt(numberInfo[1]);//4 - типа местности
            int iterator = 1;
            for (int i=0; i<RACE_COUNT && iterator< stringList.size();i++) {
                Map<Character, Integer> typesInfo = new HashMap<>();//создаем мапу, которая для каждой расы создаст буква - значение
                String raceName = stringList.get(iterator); //получим Human например
                iterator++;
                for (int j=0; j<TYPES_COUNT && iterator< stringList.size();j++) {
                    String[] typeInfo = stringList.get(iterator).split(" "); //в расе Human
                   String typeName= typeInfo[0];//3
                    int typesCost= Integer.parseInt(typeInfo[1]);//4
                    iterator++;
                    typesInfo.put(typeName.charAt(0),typesCost);
                }
                INFO.put(raceName, typesInfo);
            }
        }
    }
}
