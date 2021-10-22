package mk.ukim.finki.emt.project.userreservationmanagement.xport.client;

import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class CarClient {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public CarClient(@Value("${app.cars.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Car> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/cars").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Car>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
    public Car findCarById(String id) {
        try {
            Car car = restTemplate.exchange(uri().path("/api/cars/"+id).build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<Car>() {
            }).getBody();
            return car;
        } catch (Exception e) {
           throw new IllegalArgumentException();
        }
    }
    public Car changeCarStatus(String id) {
        try {
            Car car = restTemplate.exchange(uri().path("/api/cars/reserved/"+id).build().toUri(), HttpMethod.GET, null, new ParameterizedTypeReference<Car>() {
            }).getBody();
            return car;
        } catch (Exception e) {
            throw e;
        }
    }
}
