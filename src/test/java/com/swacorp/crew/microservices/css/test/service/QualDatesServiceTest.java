package com.swacorp.crew.microservices.css.test.service;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swacorp.crew.microservices.css.test.config.QualDatesTestConfig;

/**
 * Created by POD Norris on 5/11/16.
 */
//Spring JunitConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = QualDatesTestConfig.class)
//Allows to get an ramdom aviable port
@WebIntegrationTest({"server.port: 0"})
public class QualDatesServiceTest {

    /**
     * A random available port is injected into the port field just for testing
     * purposes.
     */
    @Value("${local.server.port}")
    private int port;
    //test ID value
    private final String QUALDATE_ID = "123456";
    private final String CM_ID = "4587";
    private final String QUAL_ID = "3452";

    //Required to Generate JSON content from Java objects
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Create an entity ChangeLog into a region
     * @throws Exception 
     */
    @SuppressWarnings("rawtypes")
	@Test
    public void createQualDateEntryTest() throws Exception {

        //Test RestTemplate to invoke the API.
        RestTemplate restTemplate = new TestRestTemplate();
        String SERVER_URL = "http://localhost:" + port;
        String API = "/api/qualification/qualdates";

        //Building the Request body data
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("qualDateId", QUALDATE_ID);
        requestBody.put("crewMemberId", CM_ID);
        requestBody.put("qualificationId", QUAL_ID);
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        //Creating http entity object with request body and headers
        HttpEntity<String> httpEntity
                = new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);

        //Invoking the API
        ResponseEntity<Map> apiResponse
                = restTemplate.postForEntity(SERVER_URL + API, httpEntity, Map.class);

        assertEquals(HttpStatus.CREATED, apiResponse.getStatusCode());

    }

    /**
     * Get a ChangeLog entry from local region by ID
     * @throws Exception 
     */
    @SuppressWarnings("rawtypes")
	@Test
    public void getQualDateByIdTest() throws Exception {
    	createQualDateEntryTest();
        //Test RestTemplate to invoke the API.
        RestTemplate restTemplate = new TestRestTemplate();
        String SERVER_URL = "http://localhost:" + port;
        String API = "/api/qualification/qualdates/";
        //Invoking the API
        ResponseEntity<Map> apiResponse
                = restTemplate.getForEntity(SERVER_URL + API + QUALDATE_ID, Map.class);

        assertEquals(HttpStatus.OK, apiResponse.getStatusCode());
        assertNotNull(apiResponse.getBody());
    }

    /**
     * Get a ChangeLog entry from local region by ID, to test
     * a BadRequest response.
     * @throws Exception 
     */
    @SuppressWarnings("rawtypes")
	@Test
    public void getChangeLogByIdBadRequesTest() throws Exception {
        
        //Test RestTemplate to invoke the API.
        RestTemplate restTemplate = new TestRestTemplate();
        String SERVER_URL = "http://localhost:" + port;
        String API = "/api/qualification/qualdates";
        String badQualDateID = "/badrequest";
        //Invoking the API
        ResponseEntity<Map> apiResponse
                = restTemplate.getForEntity(SERVER_URL + API + badQualDateID, Map.class);

        assertEquals(HttpStatus.BAD_REQUEST, apiResponse.getStatusCode());
        assertNotNull(apiResponse.getBody());
    }

    /**
     * test the update for an entry changeLog based on given ID
     * @throws Exception 
     */
    @SuppressWarnings("rawtypes")
	@Test
    public void getChangeLogUpdateTest() throws Exception {
        createQualDateEntryTest();
        //Test RestTemplate to invoke the API.
        RestTemplate restTemplate = new TestRestTemplate();
        String SERVER_URL = "http://localhost:" + port;
        String API = "/api/qualification/qualdates/";

        Map<String, String> map = new HashMap<String, String>();
        map.put("qualDateId", QUALDATE_ID);
        //update values
        map.put("comment", "x217376");
        restTemplate.put(SERVER_URL + API + QUALDATE_ID, null, map);

        //Invoking the API
        ResponseEntity<Map> apiResponse
                = restTemplate.getForEntity(SERVER_URL + API + QUALDATE_ID, Map.class);

        assertEquals(HttpStatus.OK, apiResponse.getStatusCode());
        assertNotNull(apiResponse.getBody());
    }
    
    /**
     * Test delete operation for an changeLog entity
     * @throws Exception 
     */
    @SuppressWarnings("rawtypes")
	@Test
    public void getQualDateDeleteTest() throws Exception {
        createQualDateEntryTest();
        //Test RestTemplate to invoke the API.
        RestTemplate restTemplate = new TestRestTemplate();        
        String SERVER_URL = "http://localhost:" + port;
        String API = "/api/qualification/qualdates";
        String qualDateId = "/"+QUALDATE_ID;
        
        Map<String, String> map = new HashMap<>();
        map.put("changeLogID", QUALDATE_ID);
        
        //Invoking the API        
        ResponseEntity<Map> apiResponse
                = restTemplate.getForEntity(SERVER_URL + API + qualDateId, Map.class);

        assertEquals(HttpStatus.OK, apiResponse.getStatusCode());
        assertNotNull(apiResponse.getBody());
        
        //delete
        restTemplate.delete(SERVER_URL + API + qualDateId,map);
        
        apiResponse = restTemplate.getForEntity(SERVER_URL + API + qualDateId, Map.class);        
        assertEquals(HttpStatus.NOT_FOUND, apiResponse.getStatusCode());
        
    }   
    
}
