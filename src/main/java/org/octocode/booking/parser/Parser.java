package org.octocode.booking.parser;

import org.octocode.booking.model.Hotel;

import java.util.List;

/**
 * @author Dmitriy Guskov
 */
public interface Parser {
    List<Hotel> parseHotelList();
}
