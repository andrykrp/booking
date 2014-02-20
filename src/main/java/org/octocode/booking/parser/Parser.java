package org.octocode.booking.parser;

import org.octocode.booking.model.Hotel;

import java.util.List;
import java.util.Map;

/**
 * @author Dmitriy Guskov
 */
public interface Parser {
    List<Hotel> parseHotelList(Map<String, String> requestParams);
}
