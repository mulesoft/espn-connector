/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.module;

import org.apache.commons.httpclient.HttpClient;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.api.annotations.rest.*;

import java.io.IOException;

/**
 * Mule ESPN API Connector - Connect Mule applications to the ESPN developer API (see http://developer.espn.com/)
 *
 * @author MuleSoft, Inc.
 */
@Connector(name="espn", schemaVersion="1.0-SNAPSHOT")
public abstract class espnConnector
{
    public static final String BASE_URI = "http://api.espn.com/v1";

    @RestHttpClient
    private HttpClient httpClient;

    /**
     * apiKey provided by ESPN during api registration process
     */
    @Configurable
    @RestUriParam("apiKey")
    private String apiKey;

    public espnConnector()
    {
        httpClient = new HttpClient();
    }

    /**
     * Set property
     *
     * @param apiKey ESPN API key (see developer.espn.com for access to their APIs)
     */
    public void setApiKey(String apiKey)
    {
        this.apiKey = apiKey;
    }

    public String getApiKey()
    {
        return this.apiKey;
    }

    /**
     * Set property
     *
     * @param httpClient
     */

    public void setHttpClient(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public HttpClient getHttpClient(){
        return this.httpClient;
    }

    /* ESPN Athletes API -  http://developer.espn.com/docs/athletes */

    /**
     * getAthletes
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-athletes}
     *
     * @param resource ESPN resource (i.e. /sports/baseball/mlb)
     * @param athleteId ESPN player id
     * @param dates ESPN dates values (year) for requested data (i.e. 2011, 2012, etc...)
     * @param group ESPN group (integer) allows filtering by "group" or division
     * @param enable ESPN optional flag to enable specific info (comma separated string) valid values: [stats|logos|notes|competitors]
     * @param seasonType ESPN season type accepts pre/reg/post for preseason, regular and postseason respectively
     * @param language ESPN lang - valid values include 'en' (English) and 'es' (Spanish)
     * @param limit Used to limit the number of results returned
     * @param offset Used for pagination (i.e. 11 will start with the 11th entry in the response)
     * @param accept Used when you can not set the Accepted header (i.e. application/json, text/xml)
     * @return String representing athlete data (can be JSON or XML depending on 'accept' parameter)
     * @throws IOException Thrown in the event of a communications error
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/athletes/{athleteId}/dates/{dates}?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getAthletes(@RestUriParam("resource") String resource,
                                       @Optional @Default("") @RestUriParam("athleteId") String athleteId,
                                       @Optional @Default("") @RestUriParam("dates") String dates,
                                       @Optional @Default("") @RestQueryParam("groups") String group,
                                       @Optional @Default("") @RestQueryParam("enable") String enable,
                                       @Optional @Default("reg") @RestQueryParam("seasontype") String seasonType,
                                       @Optional @Default("en") @RestQueryParam("lang") String language,
                                       @Optional @Default("50") @RestQueryParam("limit") String limit,
                                       @Optional @Default("0") @RestQueryParam("offset") String offset,
                                       @Optional @Default("application/json") @RestQueryParam("_accept") String accept) throws IOException;

    /* ESPN Teams API -  http://developer.espn.com/docs/teams */

    /**
     * getTeams
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-teams}
     *
     * @param resource ESPN resource (i.e. /sports/baseball/mlb)
     * @param teamId ESPN team identifier
     * @param enable ESPN optional flag to enable specific info (comma separated string) valid values: [venues|stats|roster|leaders]
     * @param groups ESPN group (integer) allows filtering by "group" or division
     * @param language ESPN lang - valid values include 'en' (English) and 'es' (Spanish)
     * @param limit Used to limit the number of results returned
     * @param offset Used for pagination (i.e. 11 will start with the 11th entry in the response)
     * @param accept Used when you can not set the Accepted header (i.e. application/json, text/xml)
     * @return String representing team data (can be JSON or XML depending on 'accept' parameter)
     * @throws IOException Thrown in the event of a communications error
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/teams/{teamId}?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getTeams(@RestUriParam("resource") String resource,
                                    @Optional @Default("") @RestUriParam("teamId") String teamId,
                                    @Optional @Default("") @RestQueryParam("enable") String enable,
                                    @Optional @Default("") @RestQueryParam("groups") String groups,
                                    @Optional @Default("en") @RestQueryParam("lang") String language,
                                    @Optional @Default("50") @RestQueryParam("limit") String limit,
                                    @Optional @Default("0") @RestQueryParam("offset") String offset,
                                    @Optional @Default("application/json") @RestQueryParam("_accept") String accept) throws IOException;

    /* ESPN Headlines API - http://developer.espn.com/docs/headlines */

    /**
     * getNews
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-news}
     *
     * @param resource ESPN resource (i.e. /espnw)
     * @param dates Integer in the form of "yyyymmdd" to get news for a particular date.
     * @param insider ESPN content to be included, valid values: yes, no, only
     * @param language ESPN lang - valid values include 'en' (English) and 'es' (Spanish)
     * @param limit Used to limit the number of results returned
     * @param offset Used for pagination (i.e. 11 will start with the 11th entry in the response)
     * @param accept Used when you can not set the Accepted header (i.e. application/json, text/xml)
     * @return String Representing a stream of all news for current date (can be JSON or XML depending on 'accept' parameter).
     * @throws IOException Thrown in the event of a communications error Thrown in the event of a communications error
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/news?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getNews(@RestUriParam("resource") String resource,
                                   @Optional @Default("") @RestQueryParam("dates") String dates,
                                   @Optional @Default("yes") @RestQueryParam("insider") String insider,
                                   @Optional @Default("en") @RestQueryParam("lang") String language,
                                   @Optional @Default("50") @RestQueryParam("limit") String limit,
                                   @Optional @Default("0") @RestQueryParam("offset") String offset,
                                   @Optional @Default("application/json") @RestQueryParam("_accept") String accept) throws IOException;

    /**
     * getNewsById
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-news-by-id}
     *
     * @param resource ESPN resource (i.e. /espnw)
     * @param newsId ESPN specific story identifier
     * @param dates Integer in the form of "yyyymmdd" to get news for a particular date.
     * @param insider ESPN content to be included, valid values: yes, no, only
     * @param language ESPN lang - valid values include 'en' (English) and 'es' (Spanish)
     * @param accept Used when you can not set the Accepted header (i.e. application/json, text/xml)
     * @return String represents news story identified by input parameter newsId (can be JSON or XML depending on 'accept' parameter).
     * @throws IOException Thrown in the event of a communications error Thrown in the event of a communications error
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/news/{newsId}?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getNewsById(@RestUriParam("resource") String resource,
                                   @Optional @Default("") @RestUriParam("newsId") String newsId,
                                   @Optional @Default("") @RestQueryParam("dates") String dates,
                                   @Optional @Default("yes") @RestQueryParam("insider") String insider,
                                   @Optional @Default("en") @RestQueryParam("lang") String language,
                                   @Optional @Default("application/json") @RestQueryParam("_accept") String accept) throws IOException;


    /**
     * getNewsHeadlines
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-news-headlines}
     *
     * @param resource ESPN resource (i.e. /espnw)
     * @param insider ESPN content to be included, valid values: yes, no, only
     * @param language ESPN lang - valid values include 'en' (English) and 'es' (Spanish)
     * @param limit Used to limit the number of results returned
     * @param offset Used for pagination (i.e. 11 will start with the 11th entry in the response)
     * @param accept Used when you can not set the Accepted header (i.e. application/json, text/xml)
     * @return String ESPN news headlines (can be JSON or XML depending on 'accept' parameter).
     * @throws IOException Thrown in the event of a communications error Thrown in the event of a communications error
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/news/headlines?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getNewsHeadlines(@RestUriParam("resource") String resource,
                                            @Optional @Default("yes") @RestQueryParam("insider") String insider,
                                            @Optional @Default("en") @RestQueryParam("lang") String language,
                                            @Optional @Default("50") @RestQueryParam("limit") String limit,
                                            @Optional @Default("0") @RestQueryParam("offset") String offset,
                                            @Optional @Default("application/json") @RestQueryParam("_accept") String accept) throws IOException;


    /**
     * getNewsHeadlinesTop
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-news-headlines-top}
     *
     * @param resource ESPN resource (i.e. /espnw)
     * @param insider ESPN content to be included, valid values: yes, no, only
     * @param language ESPN lang - valid values include 'en' (English) and 'es' (Spanish)
     * @param region Can be used in conjunction with the lang query string parameter to return focused headlines for a particular region, where available.
     * @param limit Used to limit the number of results returned
     * @param offset Used for pagination (i.e. 11 will start with the 11th entry in the response)
     * @param accept Used when you can not set the Accepted header (i.e. application/json, text/xml)
     * @return String Top stories as shown on ESPN.com home page. Only applicable to /sports resource (can be JSON or XML depending on 'accept' parameter).
     * @throws IOException Thrown in the event of a communications error
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/news/headlines/top?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getNewsHeadlinesTop(@RestUriParam("resource") String resource,
                                               @Optional @Default("yes") @RestQueryParam("insider") String insider,
                                               @Optional @Default("en") @RestQueryParam("lang") String language,
                                               @Optional @Default("us") @RestQueryParam("region") String region,
                                               @Optional @Default("50") @RestQueryParam("limit") String limit,
                                               @Optional @Default("0") @RestQueryParam("offset") String offset,
                                               @Optional @Default("application/json") @RestQueryParam("_accept") String accept) throws IOException;


    /**
     * getAthletesNews
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-athletes-news}
     *
     * @param resource ESPN resource (i.e. /espnw)
     * @param athleteId ESPN identifier for a particular player/athlete.
     * @param dates Integer in the form of "yyyymmdd" to get news for a particular date.
     * @param insider ESPN content to be included, valid values: yes, no, only
     * @param language ESPN lang - valid values include 'en' (English) and 'es' (Spanish)
     * @param limit Used to limit the number of results returned
     * @param offset Used for pagination (i.e. 11 will start with the 11th entry in the response)
     * @param accept Used when you can not set the Accepted header (i.e. application/json, text/xml)
     * @return String Stories about a particular player/athlete (can be JSON or XML depending on 'accept' parameter).
     * @throws IOException Thrown in the event of a communications error
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/athletes/{athleteId}/news?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getAthletesNews(@RestUriParam("resource") String resource,
                                           @RestUriParam("athleteId") String athleteId,
                                           @Optional @Default("") @RestQueryParam("dates") String dates,
                                           @Optional @Default("yes") @RestQueryParam("insider") String insider,
                                           @Optional @Default("en") @RestQueryParam("lang") String language,
                                           @Optional @Default("50") @RestQueryParam("limit") String limit,
                                           @Optional @Default("0") @RestQueryParam("offset") String offset,
                                           @Optional @Default("application/json") @RestQueryParam("_accept") String accept) throws IOException;


    /**
     * getTeamsNews
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-teams-news}
     *
     * @param resource ESPN resource (i.e. /espnw)
     * @param teamId ESPN identifier for a particular team.
     * @param dates Integer in the form of "yyyymmdd" to get news for a particular date.
     * @param insider ESPN content to be included, valid values: yes, no, only
     * @param language ESPN lang - valid values include 'en' (English) and 'es' (Spanish)
     * @param limit Used to limit the number of results returned
     * @param offset Used for pagination (i.e. 11 will start with the 11th entry in the response)
     * @param accept Used when you can not set the Accepted header (i.e. application/json, text/xml)
     * @return String Stories about a particular team (can be JSON or XML depending on 'accept' parameter).
     * @throws IOException Thrown in the event of a communications error
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/{resource}/teams/{teamId}/news?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getTeamsNews(@RestUriParam("resource") String resource,
                                        @RestUriParam("teamId") String teamId,
                                        @Optional @Default("") @RestQueryParam("dates") String dates,
                                        @Optional @Default("yes") @RestQueryParam("insider") String insider,
                                        @Optional @Default("en") @RestQueryParam("lang") String language,
                                        @Optional @Default("50") @RestQueryParam("limit") String limit,
                                        @Optional @Default("0") @RestQueryParam("offset") String offset,
                                        @Optional @Default("application/json") @RestQueryParam("_accept") String accept) throws IOException;


    /**
    * ESPN Helper API Calls
    */

    /**
     * getAllSports
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-sports}
     *
     * @param limit Used to limit the number of results returned
     * @param offset Used for pagination (i.e. 11 will start with the 11th entry in the response)
     * @param accept Used when you can not set the Accepted header (i.e. application/json, text/xml)
     * @return String List of all sports currently supported in the ESPN API (can be JSON or XML depending on 'accept' parameter).
     * @throws IOException Thrown in the event of a communications error
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/sports?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getSports(@Optional @Default("50") @RestQueryParam("limit") String limit,
                                     @Optional @Default("0") @RestQueryParam("offset") String offset,
                                     @Optional @Default("application/json") @RestQueryParam("_accept") String accept) throws IOException;

    /**
     * getSportsOrganizingBodies
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-sports-organizing-bodies}
     *
     * @param sport ESPN sport name
     * @param limit Used to limit the number of results returned
     * @param offset Used for pagination (i.e. 11 will start with the 11th entry in the response)
     * @param accept Used when you can not set the Accepted header (i.e. application/json, text/xml)
     * @return String returns a reference to all organizing bodies, or leagues (e.g. MLB) that are supported within a sport (e.g. baseball) (can be JSON or XML depending on 'accept' parameter).
     * @throws IOException Thrown in the event of a communications error
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/sports/{sport}?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getSportsOrganizingBodies(@RestUriParam("sport") String sport,
                                                     @Optional @Default("50") @RestQueryParam("limit") String limit,
                                                     @Optional @Default("0") @RestQueryParam("offset") String offset,
                                                     @Optional @Default("application/json") @RestQueryParam("_accept") String accept) throws IOException;

    /**
     * getSportsOrganizingGroupsDivisions
     *
     * {@sample.xml ../../../doc/espn-connector.xml.sample espn:get-sports-organizing-groups-divisions}
     *
     * @param sport ESPN sport name
     * @param league ESPN league abbreviation (organizing body)
     * @param limit Used to limit the number of results returned
     * @param offset Used for pagination (i.e. 11 will start with the 11th entry in the response)
     * @param accept Used when you can not set the Accepted header (i.e. application/json, text/xml)
     * @return String returns information for all groups/divisions that make up an organizing body (i.e. MLB) (can be JSON or XML depending on 'accept' parameter).
     * @throws IOException Thrown in the event of a communications error
     *
     */
    @Processor
    @RestCall(uri = BASE_URI + "/sports/{sport}/{league}?apikey={apiKey}", method = HttpMethod.GET)
    public abstract String getSportsOrganizingGroupsDivisions(@RestUriParam("sport") String sport,
                                                              @RestUriParam("league") String league,
                                                              @Optional @Default("50") @RestQueryParam("limit") String limit,
                                                              @Optional @Default("0") @RestQueryParam("offset") String offset,
                                                              @Optional @Default("application/json") @RestQueryParam("_accept") String accept) throws IOException;

}