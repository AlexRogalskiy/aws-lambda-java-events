

package io.aws.lambda.events.kinesis;

import io.aws.lambda.events.TimeWindow;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Represents an Amazon Kinesis event when using <a href="https://docs.aws.amazon.com/lambda/latest/dg/with-kinesis.html#services-kinesis-windows">time windows</a>.
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class KinesisTimeWindowEvent extends KinesisEvent implements Serializable {

    /**
     * Time window for the records in the event.
     */
    private TimeWindow window;

    /**
     * State being built up to this invoke in the time window.
     */
    private Map<String, String> state;

    /**
     * Shard id of the records
     */
    private String shardId;

    /**
     * Kinesis stream or consumer arn.
     */
    private String eventSourceArn;

    /**
     * Set to true for the last invoke of the time window. Subsequent invoke will start a new time window along with a fresh state.
     */
    private Boolean isFinalInvokeForWindow;

    /**
     * Set to true if window is terminated prematurely. Subsequent invoke will continue the same window with a fresh state.
     */
    private Boolean isWindowTerminatedEarly;
}
