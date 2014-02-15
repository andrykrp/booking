package org.octocode.booking.parser;

import org.octocode.booking.model.Hotel;

import java.io.InputStream;
import java.net.URI;
import java.util.List;

/**
 * @author Dmitriy Guskov
 */
public interface Parser {
    InputStream loadSource(URI uri);
    List<Hotel> parse(InputStream stream);
}
