package fi.jyffe.sa.poc.issue_rest_service;

import static org.junit.Assert.*;
import org.junit.Test;

public class IssueControllerTest
{
	@Test
    public void testIssue()
    {	
    		IssueController sut = new IssueController();
        
    		assertEquals("foobar", sut.issue("foobar").getType());
    
    }
}
