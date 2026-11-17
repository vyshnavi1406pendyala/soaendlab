package soa.controller;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soa.service.GatewayService;

@RestController
@RequestMapping("/")
public class GatewayController {

	GatewayService GS;
	
	public GatewayController(GatewayService GS)
	{
		this.GS = GS;
	}
	
	@GetMapping("{service}/{api}/{endpoint}")
	public Object getService(@PathVariable String service, 
							 @PathVariable String api,
							 @PathVariable String endpoint)
	{
		return GS.invokeService(HttpMethod.GET, service, api, endpoint, null);
	}
	
	@GetMapping("{service}/{api}/{endpoint}/{id}")
	public Object getService(@PathVariable String service, 
							 @PathVariable String api,
							 @PathVariable String endpoint,
							 @PathVariable Long id)
	{
		return GS.invokeService(HttpMethod.GET, service, api, endpoint + "/" + id, null);
	}
	
	@PostMapping("{service}/{api}/{endpoint}")
	public Object postService(@PathVariable String service, 
							  @PathVariable String api,
							  @PathVariable String endpoint,
							  @RequestBody Object data)
	{
		return GS.invokeService(HttpMethod.POST, service, api, endpoint, data);
	}
	
	@PutMapping("{service}/{api}/{endpoint}/{id}")
	public Object putService(@PathVariable String service,
							 @PathVariable String api,
							 @PathVariable String endpoint,
							 @PathVariable Long id,
							 @RequestBody Object data)
	{
		return GS.invokeService(HttpMethod.PUT, service, api, endpoint + "/" + id, data);
	}
	
	@DeleteMapping("{service}/{api}/{endpoint}/{id}")
	public Object deleteService(@PathVariable String service,
								@PathVariable String api,
							  	@PathVariable String endpoint,
							  	@PathVariable Long id)
	{
		return GS.invokeService(HttpMethod.DELETE, service, api, endpoint + "/" + id, null);
	}
}
