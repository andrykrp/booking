package org.octocode.booking.parser.agoda;

import org.octocode.booking.parser.util.CSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Dmitriy Guskov
 */

@Component
public class AgodaParser {
    @Autowired
    private CSVUtil csvUtil;

    public void parse(String file) {
        List<List<String>> hotels = csvUtil.parseFile("/tmp/test.csv");
        System.out.println();
    }
}