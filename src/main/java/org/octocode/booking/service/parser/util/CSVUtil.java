package org.octocode.booking.service.parser.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitriy Guskov
 */

@Component
public class CSVUtil {
    private static final Logger LOGGER = Logger.getLogger(CSVUtil.class);
    private Integer fieldsCount;

    @Autowired
    public CSVUtil(@Value("${agoda.fieldsCount}") Integer fieldsCount) {
        this.fieldsCount = fieldsCount;
    }

    public List<String> getValues(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        boolean isQuoteOpen = false;
        int lineLength = line.length();
        for (int i = 0; i < lineLength; i++) {
            char ch = line.charAt(i);
            if (ch == ',') {
                if (isQuoteOpen) {
                    buffer.append(ch);
                } else {
                    values.add(buffer.toString());
                    buffer.setLength(0);
                }
            } else if (ch == '\"' && ((i - 1) > 0) && line.charAt(i - 1) != '\\') {
                if (isQuoteOpen) {
                    isQuoteOpen = false;
                    if ((i + 1) < lineLength && line.charAt(i + 1) == ',') {
                        continue;
                    } else {
                        values.add(buffer.toString());
                        buffer.setLength(0);
                    }
                } else {
                    isQuoteOpen = true;
                }
            } else {
                buffer.append(ch);
            }
        }
        if (values.size() == fieldsCount) {
            return values;
        } else {
            throw new RuntimeException("Corrupted record. Actual size is: " + values.size());
        }
    }

    public List<List<String>> parseFile(String file) {
        return parseFile(Paths.get(file));
    }

    public List<List<String>> parseFile(Path path) {
        List<List<String>> hotels = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String line = null;
            // skip header
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                // tweak for processing malformed csv files
                if (line.charAt(line.length()-1) == ',') {
                    line += reader.readLine();
                }
                hotels.add(getValues(line));
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
        return hotels;
    }
}