package fi.jyffe.sa.poc.issue_rest_service;

/**
 * 
 * @author rantojyr
 *
 * Resource representation class for an Issue
 * 
 * TODO: Other mandatory fields than type, e.g. location, relations to other issues, state, ...
 * 
 */

public class Issue {
	
    private String type;

    public Issue(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    public void setType(String type) {
    		this.type = type;
    }
}
