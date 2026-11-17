package soa.service;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class GatewayService {

    DiscoveryClient DC;

    int current = 0;

    public GatewayService(DiscoveryClient DC) {
        this.DC = DC;
    }

    public Object invokeService(HttpMethod method, String service,
                                String api, String endpoint, Object data) {

        List<ServiceInstance> services = DC.getInstances(service);

        if (services.isEmpty())
            throw new RuntimeException("No service found");

        if (current >= services.size())
            current = 0;

        ServiceInstance instance = services.get(current++);

        String url = String.format("%s/%s/%s",
                instance.getUri(),
                api.trim(),
                endpoint.trim());

        System.out.println("Calling URL: " + url);

        RestClient client = RestClient.create();

        if (method == HttpMethod.POST)
            return client.post()
                    .uri(url)
                    .body(data)
                    .retrieve()
                    .body(String.class);

        else if (method == HttpMethod.PUT)
            return client.put()
                    .uri(url)
                    .body(data)
                    .retrieve()
                    .body(String.class);

        else if (method == HttpMethod.DELETE)
            return client.delete()
                    .uri(url)
                    .retrieve()
                    .body(String.class);

        else
            return client.get()
                    .uri(url)
                    .retrieve()
                    .body(String.class);
    }
}