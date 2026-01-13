import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portal")
public class UserPortalController {

    private final RestTemplate restTemplate = new RestTemplate();
    // API endpoint of Repository 2
    private static final String ORDER_SERVICE_URL = "http://order-service/orders/user/";

    @GetMapping("/dashboard/{userId}")
    public String getUserDashboard(@PathVariable String userId) {
        // Calling Repository 2 API
        String orderData = restTemplate.getForObject(ORDER_SERVICE_URL + userId, String.class);
        return "User Dashboard Context: " + orderData;
    }
}
