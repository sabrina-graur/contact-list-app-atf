package contact.list.project.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonUtils {

    public static String convertToJson(String body) {
        body = body.replaceAll("\\[|\\]", "");
        String[] keyValuePairs = body.split(",");
        Map<String, Object> jsonMap = new LinkedHashMap<>();

        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

            try {
                int intValue = Integer.parseInt(value);
                jsonMap.put(key, intValue);
            } catch (NumberFormatException e) {
                jsonMap.put(key, value);
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(jsonMap);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
