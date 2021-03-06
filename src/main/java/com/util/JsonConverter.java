package com.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by pc8 on 21.04.16.
 */
@Component
public class JsonConverter {

    private static final Logger logger = Logger.getLogger(JsonConverter.class);

    public static String toJSON(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error(e);
        }
        return null;
    }

    public static Object toJavaObject(String json, Object obj) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(json, obj.getClass());
        } catch (IOException e) {
            logger.error(e);
        }
        return null;
    }

}
