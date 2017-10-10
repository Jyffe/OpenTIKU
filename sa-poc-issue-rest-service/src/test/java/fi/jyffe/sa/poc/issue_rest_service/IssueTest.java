package fi.jyffe.sa.poc.issue_rest_service;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class IssueTest extends TestCase
{
    public IssueTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( IssueTest.class );
    }

    public void testIssue()
    {
    		Issue sut = new Issue("foo");
    		
        assertEquals("foo", sut.getType());
        
        sut.setType("bar");
        
        assertEquals("bar", sut.getType());
    }
    
}