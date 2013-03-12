/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.module;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.construct.Flow;
import org.mule.tck.AbstractMuleTestCase;
import org.mule.tck.FunctionalTestCase;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class EspnConnectorTest extends FunctionalTestCase
{
    @Override
    protected String getConfigResources()
    {
        return "mule-config.xml";
    }

    /**
     * ESPN Athletes API
     */

    @Test
    public void testGetAthletes() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");

        runFlowWithPayloadAndExpectJSON("getAthletes", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_ByGroup() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("group","1");

        runFlowWithPayloadAndExpectJSON("getAthletes_ByGroup", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_WithLimit() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("limit","5");

        runFlowWithPayloadAndExpectJSON("getAthletes_WithLimit", "success", msg, "status");
    }

    @Test
    public void testGetAthletes_WithOffset() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("limit","5");
        msg.put("offset","3");

        runFlowWithPayloadAndExpectJSON("getAthletes_WithOffset", "success", msg, "status");
    }

    @Test
    public void testGetAthletes_AcceptTextXml() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("limit","5");
        msg.put("accept","text/xml");

        runFlowWithPayloadAndExpectXML("getAthletes_AcceptTextXml", "success", msg, "/response/status");
    }

    @Test
    public void testGetAthletes_ByAthleteId() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("athleteId","31662");

        runFlowWithPayloadAndExpectJSON("getAthletes_ByAthleteId", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_ByDates() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("athleteId","31662");
        msg.put("dates","2012");

        runFlowWithPayloadAndExpectJSON("getAthletes_ByDates", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_BySeasonType() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("athleteId","31662");
        msg.put("dates","2012");
        msg.put("seasonType", "reg");

        runFlowWithPayloadAndExpectJSON("getAthletes_BySeasonType", "success",  msg, "status");
    }

    @Test
    public void testGetAthletes_ByLanguage() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("athleteId","31662");
        msg.put("dates","2012");
        msg.put("lang","es");

        runFlowWithPayloadAndExpectJSON("getAthletes_ByLanguage", "success",  msg, "status");
    }

    /**
     * ESPN Teams API
     */

    @Test
    public void testGetTeams() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");

        runFlowWithPayloadAndExpectJSON("getTeams", "success", msg, "status");
    }

    @Test
    public void testGetTeams_EnableVenues() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");

        runFlowWithPayloadAndExpectJSON("getTeams_EnableVenues", "success", msg, "status");
    }

    @Test
    public void testGetTeams_ByGroup() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("group","1");

        runFlowWithPayloadAndExpectJSON("getTeams_ByGroup", "success", msg, "status");
    }

    @Test
    public void testGetTeams_ByLanguage() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("lang","es");

        runFlowWithPayloadAndExpectJSON("getTeams_ByLanguage", "success", msg, "status");
    }

    @Test
    public void testGetTeams_ByTeamId() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("teamId","2");

        runFlowWithPayloadAndExpectJSON("getTeams_ByTeamId", "success",  msg, "status");
    }

    /**
     * ESPN Headlines API
     */

    @Test
    public void failingTestGetNews() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");

        runFlowWithPayloadAndExpectJSON("getNews","success", msg, "status");
    }

    @Test
    public void testGetNews_ByDates() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("dates","20120821");

        runFlowWithPayloadAndExpectJSON("getNews_ByDates","success", msg, "status");
    }


    @Test
    public void failingTestGetNews_ByInsider() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("insider","only");

        runFlowWithPayloadAndExpectJSON("getNews_ByInsider","success", msg, "status");
    }


    @Test
    public void failingTestGetNews_ByLanguage() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("lang","es");

        runFlowWithPayloadAndExpectJSON("getNews_ByLanguage","success", msg, "status");
    }


    @Test
    public void failingTestGetNews_ByNewsId() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("newsId","8256331");

        runFlowWithPayloadAndExpectJSON("getNews_ByNewsId","success", msg, "status");
    }

    @Test
    public void testGetNewsHeadlines() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");

        runFlowWithPayloadAndExpectJSON("getNewsHeadlines","success", msg, "status");
    }

    @Test
    public void testGetNewsHeadlinesTop() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");

        runFlowWithPayloadAndExpectJSON("getNewsHeadlinesTop","success", msg, "status");
    }

    @Test
    public void testGetNewsHeadlinesTop_ByLanguageAndRegion() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/soccer");
        msg.put("lang","es");
        msg.put("region","ar");

        runFlowWithPayloadAndExpectJSON("getNewsHeadlinesTop_ByLanguageAndRegion","success", msg, "status");
    }

    @Test
    public void failingTestGetAthletesNews() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("athleteId","31662");

        runFlowWithPayloadAndExpectJSON("getAthletesNews","success", msg, "status");
    }

    @Test
    public void failingTestGetTeamsNews() throws Exception
    {
        Map msg = new HashMap();
        msg.put("resource","sports/baseball/mlb");
        msg.put("teamId","2");

        runFlowWithPayloadAndExpectJSON("getTeamsNews","success", msg, "status");
    }

    /**
     * ESPN Helper API
     */

    @Test
    public void testGetSports() throws Exception
    {
        runFlowAndExpectJSON("getSports","success", "status");
    }

    @Test
    public void testGetSportsOrganizingBodies() throws Exception
    {
        Map msg = new HashMap();
        msg.put("sport","baseball");

        runFlowWithPayloadAndExpectJSON("getSportsOrganizingBodies","success", msg, "status");
    }

    @Test
    public void testGetSportsOrganizingGroupsDivisions() throws Exception
    {
        Map msg = new HashMap();
        msg.put("sport","baseball");
        msg.put("league","mlb");

        runFlowWithPayloadAndExpectJSON("getSportsOrganizingGroupsDivisions","success", msg, "status");
    }


    /**
    * Run the flow specified by name and assert equality on the expected output
    *
    * @param flowName The name of the flow to run
    * @param expect The expected output
    */
    protected <T> void runFlowAndExpect(String flowName, T expect) throws Exception
    {
        Flow flow = lookupFlowConstruct(flowName);
        MuleEvent event = AbstractMuleTestCase.getTestEvent(null);
        MuleEvent responseEvent = flow.process(event);

        assertEquals(expect, responseEvent.getMessage().getPayload());
    }

    /**
     * Run the flow specified by name and assert equality on the expected output
     *
     * @param flowName The name of the flow to run
     * @param expect The expected output
     * @param keyName The JSON key identifier used for comparison
     */
    protected <T> void runFlowAndExpectJSON(String flowName, T expect, T keyName) throws Exception
    {
        Flow flow = lookupFlowConstruct(flowName);
        MuleEvent event = AbstractMuleTestCase.getTestEvent(null);
        MuleEvent responseEvent = flow.process(event);

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> response = mapper.readValue((String) responseEvent.getMessage().getPayload(), Map.class);

        assertEquals(expect, response.get(keyName));
    }


    /**
    * Run the flow specified by name using the specified payload and assert
    * equality on the expected output
    *
    * @param flowName The name of the flow to run
    * @param expect The expected output
    * @param payload The payload of the input event
    */
    protected <T, U> void runFlowWithPayloadAndExpect(String flowName, T expect, U payload) throws Exception
    {
        Flow flow = lookupFlowConstruct(flowName);
        MuleEvent event = AbstractMuleTestCase.getTestEvent(payload);
        MuleEvent responseEvent = flow.process(event);

        assertEquals(expect, responseEvent.getMessage().getPayload());
    }

    /**
     * Run the flow specified by name using the specified payload and assert
     * equality on the expected output
     *
     * @param flowName The name of the flow to run
     * @param expect The expected output
     * @param payload The payload of the input event
     * @param keyName The name of the JSON key that contains the required assertion parameter.
     */
    protected <T, U> void runFlowWithPayloadAndExpectJSON(String flowName,  T expect, U payload, T keyName) throws Exception
    {
        Flow flow = lookupFlowConstruct(flowName);
        MuleEvent event = AbstractMuleTestCase.getTestEvent(payload);
        MuleEvent responseEvent = flow.process(event);

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> response = mapper.readValue((String) responseEvent.getMessage().getPayload(), Map.class);

        assertEquals(expect, response.get(keyName));

    }

    /**
     * Run the flow specified by name using the specified payload and assert
     * equality on the expected output
     *
     * @param flowName The name of the flow to run
     * @param expect The expected output
     * @param payload The payload of the input event
     * @param xpathString The xPath string that indicates the location of the parameter required for the assertion against the 'expected' value (i.e. /response/status).
     */
    protected <T, U> void runFlowWithPayloadAndExpectXML(String flowName,  T expect, U payload, T xpathString) throws Exception
    {
        Flow flow = lookupFlowConstruct(flowName);
        MuleEvent event = AbstractMuleTestCase.getTestEvent(payload);
        MuleEvent responseEvent = flow.process(event);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader((String) responseEvent.getMessage().getPayload())));

            XPath xPath = XPathFactory.newInstance().newXPath();

            Node node = (Node) xPath.evaluate((String) xpathString, document, XPathConstants.NODE);

            assertEquals(expect,node.getTextContent());

        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Retrieve a flow by name from the registry
     *
     * @param name Name of the flow to retrieve
     */
    protected Flow lookupFlowConstruct(String name)
    {
        return (Flow) AbstractMuleTestCase.muleContext.getRegistry().lookupFlowConstruct(name);
    }

}
