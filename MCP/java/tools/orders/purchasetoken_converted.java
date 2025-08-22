/**
 * MCP Server function for Generate a consumer token
 */

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.function.Function;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

class Post_Payments_V1_Authorizations_Authorization_Token_Customer_TokenMCPTool {
    
    public static Function<MCPServer.MCPRequest, MCPServer.MCPToolResult> getPost_Payments_V1_Authorizations_Authorization_Token_Customer_TokenHandler(MCPServer.APIConfig config) {
        return (request) -> {
            try {
                Map<String, Object> args = request.getArguments();
                if (args == null) {
                    return new MCPServer.MCPToolResult("Invalid arguments object", true);
                }
                
                List<String> queryParams = new ArrayList<>();
        if (args.containsKey("authorizationToken")) {
            queryParams.add("authorizationToken=" + args.get("authorizationToken"));
        }
        if (args.containsKey("purchase_country")) {
            queryParams.add("purchase_country=" + args.get("purchase_country"));
        }
        if (args.containsKey("purchase_currency")) {
            queryParams.add("purchase_currency=" + args.get("purchase_currency"));
        }
        if (args.containsKey("description")) {
            queryParams.add("description=" + args.get("description"));
        }
        if (args.containsKey("intended_use")) {
            queryParams.add("intended_use=" + args.get("intended_use"));
        }
        if (args.containsKey("locale")) {
            queryParams.add("locale=" + args.get("locale"));
        }
        if (args.containsKey("billing_address")) {
            queryParams.add("billing_address=" + args.get("billing_address"));
        }
        if (args.containsKey("customer")) {
            queryParams.add("customer=" + args.get("customer"));
        }
                
                String queryString = queryParams.isEmpty() ? "" : "?" + String.join("&", queryParams);
                String url = config.getBaseUrl() + "/api/v2/post_payments_v1_authorizations_authorization_token_customer_token" + queryString;
                
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization", "Bearer " + config.getApiKey())
                    .header("Accept", "application/json")
                    .GET()
                    .build();
                
                HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                
                if (response.statusCode() >= 400) {
                    return new MCPServer.MCPToolResult("API error: " + response.body(), true);
                }
                
                // Pretty print JSON
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(response.body());
                String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
                
                return new MCPServer.MCPToolResult(prettyJson);
                
            } catch (IOException | InterruptedException e) {
                return new MCPServer.MCPToolResult("Request failed: " + e.getMessage(), true);
            } catch (Exception e) {
                return new MCPServer.MCPToolResult("Unexpected error: " + e.getMessage(), true);
            }
        };
    }
    
    public static MCPServer.Tool createPost_Payments_V1_Authorizations_Authorization_Token_Customer_TokenTool(MCPServer.APIConfig config) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("type", "object");
        Map<String, Object> properties = new HashMap<>();
        Map<String, Object> authorizationTokenProperty = new HashMap<>();
        authorizationTokenProperty.put("type", "string");
        authorizationTokenProperty.put("required", true);
        authorizationTokenProperty.put("description", "");
        properties.put("authorizationToken", authorizationTokenProperty);
        Map<String, Object> purchase_countryProperty = new HashMap<>();
        purchase_countryProperty.put("type", "string");
        purchase_countryProperty.put("required", true);
        purchase_countryProperty.put("description", "Input parameter: ISO 3166 alpha-2 purchase country.");
        properties.put("purchase_country", purchase_countryProperty);
        Map<String, Object> purchase_currencyProperty = new HashMap<>();
        purchase_currencyProperty.put("type", "string");
        purchase_currencyProperty.put("required", true);
        purchase_currencyProperty.put("description", "Input parameter: ISO 4217 purchase currency.");
        properties.put("purchase_currency", purchase_currencyProperty);
        Map<String, Object> descriptionProperty = new HashMap<>();
        descriptionProperty.put("type", "string");
        descriptionProperty.put("required", true);
        descriptionProperty.put("description", "Input parameter: Description of the purpose of the token.");
        properties.put("description", descriptionProperty);
        Map<String, Object> intended_useProperty = new HashMap<>();
        intended_useProperty.put("type", "string");
        intended_useProperty.put("required", true);
        intended_useProperty.put("description", "Input parameter: Intended use for the token.");
        properties.put("intended_use", intended_useProperty);
        Map<String, Object> localeProperty = new HashMap<>();
        localeProperty.put("type", "string");
        localeProperty.put("required", true);
        localeProperty.put("description", "Input parameter: RFC 1766 customer's locale.");
        properties.put("locale", localeProperty);
        Map<String, Object> billing_addressProperty = new HashMap<>();
        billing_addressProperty.put("type", "string");
        billing_addressProperty.put("required", false);
        billing_addressProperty.put("description", "");
        properties.put("billing_address", billing_addressProperty);
        Map<String, Object> customerProperty = new HashMap<>();
        customerProperty.put("type", "string");
        customerProperty.put("required", false);
        customerProperty.put("description", "");
        properties.put("customer", customerProperty);
        parameters.put("properties", properties);
        
        MCPServer.ToolDefinition definition = new MCPServer.ToolDefinition(
            "post_payments_v1_authorizations_authorization_token_customer_token",
            "Generate a consumer token",
            parameters
        );
        
        return new MCPServer.Tool(definition, getPost_Payments_V1_Authorizations_Authorization_Token_Customer_TokenHandler(config));
    }
    
}