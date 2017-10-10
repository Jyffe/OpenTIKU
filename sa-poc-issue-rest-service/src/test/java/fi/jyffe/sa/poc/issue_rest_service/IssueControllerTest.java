package fi.jyffe.sa.poc.issue_rest_service;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class IssueControllerTest 
    extends TestCase
{
    public IssueControllerTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( IssueControllerTest.class );
    }

    public void testIssue()
    {	
    		IssueController sut = new IssueController();
        
    		assertEquals("foobar", sut.issue("foobar").getType());
    
    }
}
