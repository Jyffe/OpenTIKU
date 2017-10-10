package fi.jyffe.sa.poc.issue_rest_service;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class IssueControllerTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public IssueControllerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( IssueControllerTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testIssue()
    {
        assertTrue( true );
    }
}
