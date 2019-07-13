package pl.mbierut.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mbierut.models.weekend.Weekend;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LongWeekendClient {

    @Value("${urlLongWeekend}")
    private String longWeekendServiceUrl;

    private RestTemplate restTemplate;

    public LongWeekendClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Weekend> getLongWeekendDataForCurrentYearInPoland(){
        String url = longWeekendServiceUrl + LocalDateTime.now().getYear() + "/PL";
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Weekend>>(){}).getBody();
    }
}