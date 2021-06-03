
package io.aws.lambda.events;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * represents a Lex event
 */
@Data
@Accessors(chain = true)
public class LexEvent implements Serializable {

    private String messageVersion;
    private String invocationSource;
    private String userId;
    private Map<String, String> sessionAttributes;
    private String outputDialogMode;
    private CurrentIntent currentIntent;
    private Bot bot;

    /**
     * Represents a Lex bot
     */
    @Data
    @Accessors(chain = true)
    public class Bot implements Serializable {

        private String name;
        private String alias;
        private String version;
    }

    /**
     * models CurrentIntent of Lex event
     */
    @Data
    @Accessors(chain = true)
    public class CurrentIntent implements Serializable {

        private String name;
        private Map<String, String> slots;
        private String confirmationStatus;
    }
}
