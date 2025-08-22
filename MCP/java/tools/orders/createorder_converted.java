/**
 * MCP Server function for Create a new order
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

class Post_Payments_V1_Authorizations_Authorization_Token_OrderMCPTool {
    
    public static Function<MCPServer.MCPRequest, MCPServer.MCPToolResult> getPost_Payments_V1_Authorizations_Authorization_Token_OrderHandler(MCPServer.APIConfig config) {
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
        if (args.containsKey("merchant_data")) {
            queryParams.add("merchant_data=" + args.get("merchant_data"));
        }
        if (args.containsKey("purchase_country")) {
            queryParams.add("purchase_country=" + args.get("purchase_country"));
        }
        if (args.containsKey("status")) {
            queryParams.add("status=" + args.get("status"));
        }
        if (args.containsKey("locale")) {
            queryParams.add("locale=" + args.get("locale"));
        }
        if (args.containsKey("purchase_currency")) {
            queryParams.add("purchase_currency=" + args.get("purchase_currency"));
        }
        if (args.containsKey("merchant_reference1")) {
            queryParams.add("merchant_reference1=" + args.get("merchant_reference1"));
        }
        if (args.containsKey("authorization_token")) {
            queryParams.add("authorization_token=" + args.get("authorization_token"));
        }
        if (args.containsKey("merchant_reference2")) {
            queryParams.add("merchant_reference2=" + args.get("merchant_reference2"));
        }
        if (args.containsKey("order_tax_amount")) {
            queryParams.add("order_tax_amount=" + args.get("order_tax_amount"));
        }
        if (args.containsKey("order_amount")) {
            queryParams.add("order_amount=" + args.get("order_amount"));
        }
        if (args.containsKey("auto_capture")) {
            queryParams.add("auto_capture=" + args.get("auto_capture"));
        }
        if (args.containsKey("merchant_urls")) {
            queryParams.add("merchant_urls=" + args.get("merchant_urls"));
        }
        if (args.containsKey("shipping_address")) {
            queryParams.add("shipping_address=" + args.get("shipping_address"));
        }
        if (args.containsKey("customer")) {
            queryParams.add("customer=" + args.get("customer"));
        }
        if (args.containsKey("billing_address")) {
            queryParams.add("billing_address=" + args.get("billing_address"));
        }
        if (args.containsKey("custom_payment_method_ids")) {
            queryParams.add("custom_payment_method_ids=" + args.get("custom_payment_method_ids"));
        }
        if (args.containsKey("payment_method_categories")) {
            queryParams.add("payment_method_categories=" + args.get("payment_method_categories"));
        }
        if (args.containsKey("order_lines")) {
            queryParams.add("order_lines=" + args.get("order_lines"));
        }
                
                String queryString = queryParams.isEmpty() ? "" : "?" + String.join("&", queryParams);
                String url = config.getBaseUrl() + "/api/v2/post_payments_v1_authorizations_authorization_token_order" + queryString;
                
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
    
    public static MCPServer.Tool createPost_Payments_V1_Authorizations_Authorization_Token_OrderTool(MCPServer.APIConfig config) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("type", "object");
        Map<String, Object> properties = new HashMap<>();
        Map<String, Object> authorizationTokenProperty = new HashMap<>();
        authorizationTokenProperty.put("type", "string");
        authorizationTokenProperty.put("required", true);
        authorizationTokenProperty.put("description", "");
        properties.put("authorizationToken", authorizationTokenProperty);
        Map<String, Object> merchant_dataProperty = new HashMap<>();
        merchant_dataProperty.put("type", "string");
        merchant_dataProperty.put("required", false);
        merchant_dataProperty.put("description", "Input parameter: Pass through field to send any information about the order to be used later for reference while retrieving the order details (max 6000 characters)");
        properties.put("merchant_data", merchant_dataProperty);
        Map<String, Object> purchase_countryProperty = new HashMap<>();
        purchase_countryProperty.put("type", "string");
        purchase_countryProperty.put("required", true);
        purchase_countryProperty.put("description", "Input parameter: The purchase country of the customer. The billing country always overrides purchase country if the values are different. Formatted according to ISO 3166 alpha-2 standard, e.g. GB, SE, DE, US, etc.");
        properties.put("purchase_country", purchase_countryProperty);
        Map<String, Object> statusProperty = new HashMap<>();
        statusProperty.put("type", "string");
        statusProperty.put("required", false);
        statusProperty.put("description", "Input parameter: The current status of the session. Possible values: 'complete', 'incomplete' where 'complete' is set when the order has been placed.");
        properties.put("status", statusProperty);
        Map<String, Object> localeProperty = new HashMap<>();
        localeProperty.put("type", "string");
        localeProperty.put("required", false);
        localeProperty.put("description", "Input parameter: Used to define the language and region of the customer. The locale follows the format of (RFC 1766)[https://datatracker.ietf.org/doc/rfc1766/], meaning its value consists of language-country. The following values are applicable: AT: \"de-AT\", \"de-DE\", \"en-DE\" BE: \"be-BE\", \"nl-BE\", \"fr-BE\", \"en-BE\" CH: \"it-CH\", \"de-CH\", \"fr-CH\", \"en-CH\" DE: \"de-DE\", \"de-AT\", \"en-DE\" DK: \"da-DK\", \"en-DK\" ES: \"es-ES\", \"ca-ES\", \"en-ES\" FI: \"fi-FI\", \"sv-FI\", \"en-FI\" GB: \"en-GB\" IT: \"it-IT\", \"en-IT\" NL: \"nl-NL\", \"en-NL\" NO: \"nb-NO\", \"en-NO\" PL: \"pl-PL\", \"en-PL\" SE: \"sv-SE\", \"en-SE\" US: \"en-US\".");
        properties.put("locale", localeProperty);
        Map<String, Object> purchase_currencyProperty = new HashMap<>();
        purchase_currencyProperty.put("type", "string");
        purchase_currencyProperty.put("required", true);
        purchase_currencyProperty.put("description", "Input parameter: The purchase currency of the order. Formatted according to ISO 4217 standard, e.g. USD, EUR, SEK, GBP, etc.");
        properties.put("purchase_currency", purchase_currencyProperty);
        Map<String, Object> merchant_reference1Property = new HashMap<>();
        merchant_reference1Property.put("type", "string");
        merchant_reference1Property.put("required", false);
        merchant_reference1Property.put("description", "Input parameter: Used for storing merchant's internal order number or other reference.");
        properties.put("merchant_reference1", merchant_reference1Property);
        Map<String, Object> authorization_tokenProperty = new HashMap<>();
        authorization_tokenProperty.put("type", "string");
        authorization_tokenProperty.put("required", false);
        authorization_tokenProperty.put("description", "Input parameter: Authorization token.");
        properties.put("authorization_token", authorization_tokenProperty);
        Map<String, Object> merchant_reference2Property = new HashMap<>();
        merchant_reference2Property.put("type", "string");
        merchant_reference2Property.put("required", false);
        merchant_reference2Property.put("description", "Input parameter: Used for storing merchant's internal order number or other reference. The value is available in the settlement files. (max 255 characters).");
        properties.put("merchant_reference2", merchant_reference2Property);
        Map<String, Object> order_tax_amountProperty = new HashMap<>();
        order_tax_amountProperty.put("type", "string");
        order_tax_amountProperty.put("required", false);
        order_tax_amountProperty.put("description", "Input parameter: Total tax amount of the order. The value should be in non-negative minor units. Eg: 25 Euros should be 2500.");
        properties.put("order_tax_amount", order_tax_amountProperty);
        Map<String, Object> order_amountProperty = new HashMap<>();
        order_amountProperty.put("type", "string");
        order_amountProperty.put("required", true);
        order_amountProperty.put("description", "Input parameter: Total amount of the order including tax and any available discounts. The value should be in non-negative minor units. Eg: 25 Euros should be 2500.");
        properties.put("order_amount", order_amountProperty);
        Map<String, Object> auto_captureProperty = new HashMap<>();
        auto_captureProperty.put("type", "string");
        auto_captureProperty.put("required", false);
        auto_captureProperty.put("description", "Input parameter: Allow merchant to trigger auto capturing.");
        properties.put("auto_capture", auto_captureProperty);
        Map<String, Object> merchant_urlsProperty = new HashMap<>();
        merchant_urlsProperty.put("type", "string");
        merchant_urlsProperty.put("required", false);
        merchant_urlsProperty.put("description", "");
        properties.put("merchant_urls", merchant_urlsProperty);
        Map<String, Object> shipping_addressProperty = new HashMap<>();
        shipping_addressProperty.put("type", "string");
        shipping_addressProperty.put("required", false);
        shipping_addressProperty.put("description", "");
        properties.put("shipping_address", shipping_addressProperty);
        Map<String, Object> customerProperty = new HashMap<>();
        customerProperty.put("type", "string");
        customerProperty.put("required", false);
        customerProperty.put("description", "");
        properties.put("customer", customerProperty);
        Map<String, Object> billing_addressProperty = new HashMap<>();
        billing_addressProperty.put("type", "string");
        billing_addressProperty.put("required", false);
        billing_addressProperty.put("description", "");
        properties.put("billing_address", billing_addressProperty);
        Map<String, Object> custom_payment_method_idsProperty = new HashMap<>();
        custom_payment_method_idsProperty.put("type", "string");
        custom_payment_method_idsProperty.put("required", false);
        custom_payment_method_idsProperty.put("description", "Input parameter: Promo codes - The array could be used to define which of the configured payment options within a payment category (pay_later, pay_over_time, etc.) should be shown for this purchase. Discuss with the delivery manager to know about the promo codes that will be configured for your account. The feature could also be used to provide promotional offers to specific customers (eg: 0% financing). Please be informed that the usage of this feature can have commercial implications.");
        properties.put("custom_payment_method_ids", custom_payment_method_idsProperty);
        Map<String, Object> payment_method_categoriesProperty = new HashMap<>();
        payment_method_categoriesProperty.put("type", "string");
        payment_method_categoriesProperty.put("required", false);
        payment_method_categoriesProperty.put("description", "Input parameter: Available payment method categories");
        properties.put("payment_method_categories", payment_method_categoriesProperty);
        Map<String, Object> order_linesProperty = new HashMap<>();
        order_linesProperty.put("type", "string");
        order_linesProperty.put("required", true);
        order_linesProperty.put("description", "Input parameter: The array containing list of line items that are part of this order. Maximum of 1000 line items could be processed in a single order.");
        properties.put("order_lines", order_linesProperty);
        parameters.put("properties", properties);
        
        MCPServer.ToolDefinition definition = new MCPServer.ToolDefinition(
            "post_payments_v1_authorizations_authorization_token_order",
            "Create a new order",
            parameters
        );
        
        return new MCPServer.Tool(definition, getPost_Payments_V1_Authorizations_Authorization_Token_OrderHandler(config));
    }
    
}