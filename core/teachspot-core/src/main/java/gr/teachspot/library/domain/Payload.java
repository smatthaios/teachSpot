package gr.teachspot.library.domain;

import gr.teachspot.library.exception.DataException;

import java.util.HashMap;
import java.util.Map;


public abstract class Payload {
    private String templatePath;
    private String encoding;

    public Payload(String path, String encoding) {
        this.templatePath = path;
        this.encoding = encoding;
    }

    abstract String getBody();

    public String getTemplatePath() {
        return templatePath;
    }

    public String getEncoding() {
        return encoding;
    }

    /**
     * Prepares a map of key-value elements, to be used while assembling email body message.
     *
     * @return the map of parameters
     *
     * @throws gr.teachspot.library.exception.DataException if the templates encoding is not valid
     */
    Map<String, Object> prepareTemplateParameters() throws DataException {
        final Map<String, Object> model = new HashMap<>();
        try{
            model.put("encoding", encoding);
        } catch(RuntimeException re){
            throw new DataException(String.format("There was a problem while creating email template for encoding[%s]", encoding), re);
        }

        return model;
    }
}
