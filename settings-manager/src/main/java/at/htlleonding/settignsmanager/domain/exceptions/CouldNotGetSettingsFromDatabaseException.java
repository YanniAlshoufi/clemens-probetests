package at.htlleonding.settignsmanager.domain.exceptions;

import java.nio.channels.CancelledKeyException;

public class CouldNotGetSettingsFromDatabaseException extends Exception {
    public CouldNotGetSettingsFromDatabaseException(String message) {
        super(message);
    }
}
