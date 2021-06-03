package io.aws.lambda.events.system;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * References a CodeCommit event
 */
@Data
@Accessors(chain = true)
public class CodeCommitEvent implements Serializable {

    private List<Record> records;

    /**
     * represents a Reference object in a CodeCommit object
     */
    @Data
    @Accessors(chain = true)
    public static class Reference implements Serializable {

        private String commit;
        private String ref;
        private Boolean created;
    }

    /**
     * Represents a CodeCommit object in a record
     */
    @Data
    @Accessors(chain = true)
    public static class CodeCommit implements Serializable {

        private List<Reference> references;
    }

    /**
     * represents a CodeCommit record
     */
    @Data
    @Accessors(chain = true)
    public static class Record implements Serializable {

        private String eventId;
        private String eventVersion;
        private String eventTime;
        private String eventTriggerName;
        private Integer eventPartNumber;
        private CodeCommit codeCommit;
        private String eventName;
        private String eventTriggerConfigId;
        private String eventSourceArn;
        private String userIdentityArn;
        private String eventSource;
        private String awsRegion;
        private String customData;
        private Integer eventTotalParts;

        public LocalDateTime getEventDateTime() {
            return LocalDateTime.parse(eventTime);
        }
    }
}
