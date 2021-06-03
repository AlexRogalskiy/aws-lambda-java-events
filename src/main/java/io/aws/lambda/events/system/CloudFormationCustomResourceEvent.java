
package io.aws.lambda.events.system;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * Class to represent the custom resource request event from CloudFormation.
 *
 * CloudFormation invokes your Lambda function asynchronously with this event and includes a callback URL. The function
 * is responsible for returning a response to the callback URL that indicates success or failure.
 *
 * @see <a href="https://docs.aws.amazon.com/lambda/latest/dg/services-cloudformation.html">Using AWS Lambda with AWS CloudFormation</a>
 */
@Data
@Accessors(chain = true)
public class CloudFormationCustomResourceEvent implements Serializable  {

    private String requestType;
    private String serviceToken;
    private String responseUrl;
    private String stackId;
    private String requestId;
    private String logicalResourceId;
    private String physicalResourceId;
    private String resourceType;
    private Map<String, Object> resourceProperties;
    private Map<String, Object> oldResourceProperties;
}
