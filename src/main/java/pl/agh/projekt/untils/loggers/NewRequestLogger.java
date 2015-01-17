package pl.agh.projekt.untils.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by karol on 08.11.14.
 */
public class NewRequestLogger {

    private static long surfix = 0;
    private final String id;

    private final String path;
    private String messageBody = null;
    private String error = null;
    private String response = null;
    private final String method;

    private long start;
    private long end;

    private static final Logger LOGGER = LoggerFactory.getLogger("RequestLogger");

    public NewRequestLogger(HttpServletRequest httpServletRequest) {
        this.start = System.currentTimeMillis();
        this.id = createedID();
        this.path = (String) httpServletRequest.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        this.method = httpServletRequest.getMethod();
    }

    public NewRequestLogger(HttpServletRequest httpServletRequest, String messageBody) {
        this(httpServletRequest);
        this.messageBody = messageBody;
    }

    private synchronized String createedID() {
        StringBuilder stringBuilder = new StringBuilder(3);
        stringBuilder.append(start);
        stringBuilder.append("-");
        stringBuilder.append(surfix);
        surfix++;
        return stringBuilder.toString();
    }

    public void setError(String message) {
        error = message;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void end() {
        end = System.currentTimeMillis();
        long time = end - start;
        LOGGER.info("[id= {},method = {}, path= {},messageBody = {}, error = {}, response= {}, time= {}]", id, method, path, messageBody, error, response, String.valueOf(time));
    }
}
