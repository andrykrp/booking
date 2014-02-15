package org.octocode.booking.client;

import java.io.InputStream;
import java.net.URI;

/**
 * @author Dmitriy Guskov
 */
public interface Client {
    InputStream loadSource(URI uri);
}
