package contact.list.project.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonUtils {

    public static String convertToJson(String body) { //TODO: remove this, use only rest assured. Object response
        body = body.replaceAll("\\[|\\]", ""); //removes square brackets from the input string and replace it with an empty string
        String[] keyValuePairs = body.split(","); //modified string into an array of key-value pairs based on commas.
        Map<String, Object> jsonMap = new LinkedHashMap<>(); //LinkedHashMap order of insertions

        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":"); //splits each key-value pair into two parts,based on the colon : separator.
            String key = keyValue[0].trim(); //удаляются начальные и конечные пробелы
            String value = keyValue[1].trim();

            try {
                int intValue = Integer.parseInt(value);
                jsonMap.put(key, intValue);
            } catch (NumberFormatException e) {
                jsonMap.put(key, value);
            }
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(jsonMap); //is part of the Jackson library. To convert Java objects to JSON and vice versa.
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
