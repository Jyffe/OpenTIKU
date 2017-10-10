package fi.jyffe.sa.poc.issue_rest_service;

import static org.junit.Assert.*;
import org.junit.Test;

public class IssueTest
{
	@Test
    public void testIssue()
    {
    		Issue sut = new Issue("foo");
    		
        assertEquals("foo", sut.getType());
        
        sut.setType("bar");
        
        assertEquals("bar", sut.getType());
    }
    
}