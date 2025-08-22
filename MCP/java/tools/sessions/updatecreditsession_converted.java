/**
 * MCP Server function for Update an existing payment session
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

class Post_Payments_V1_Sessions_Session_IdMCPTool {
    
    public static Function<MCPServer.MCPRequest, MCPServer.MCPToolResult> getPost_Payments_V1_Sessions_Session_IdHandler(MCPServer.APIConfig config) {
        return (request) -> {
            try {
                Map<String, Object> args = request.getArguments();
                if (args == null) {
                    return new MCPServer.MCPToolResult("Invalid arguments object", true);
                }
                
                List<String> queryParams = new ArrayList<>();
        if (args.containsKey("session_id")) {
            queryParams.add("session_id=" + args.get("session_id"));
        }
        if (args.containsKey("purchase_country")) {
            queryParams.add("purchase_country=" + args.get("purchase_country"));
        }
        if (args.containsKey("client_token")) {
            queryParams.add("client_token=" + args.get("client_token"));
        }
        if (args.containsKey("locale")) {
            queryParams.add("locale=" + args.get("locale"));
        }
        if (args.containsKey("acquiring_channel")) {
            queryParams.add("acquiring_channel=" + args.get("acquiring_channel"));
        }
        if (args.containsKey("status")) {
            queryParams.add("status=" + args.get("status"));
        }
        if (args.containsKey("merchant_reference1")) {
            queryParams.add("merchant_reference1=" + args.get("merchant_reference1"));
        }
        if (args.containsKey("design")) {
            queryParams.add("design=" + args.get("design"));
        }
        if (args.containsKey("expires_at")) {
            queryParams.add("expires_at=" + args.get("expires_at"));
        }
        if (args.containsKey("purchase_currency")) {
            queryParams.add("purchase_currency=" + args.get("purchase_currency"));
        }
        if (args.containsKey("intent")) {
            queryParams.add("intent=" + args.get("intent"));
        }
        if (args.containsKey("merchant_data")) {
            queryParams.add("merchant_data=" + args.get("merchant_data"));
        }
        if (args.containsKey("merchant_reference2")) {
            queryParams.add("merchant_reference2=" + args.get("merchant_reference2"));
        }
        if (args.containsKey("authorization_token")) {
            queryParams.add("authorization_token=" + args.get("authorization_token"));
        }
        if (args.containsKey("order_tax_amount")) {
            queryParams.add("order_tax_amount=" + args.get("order_tax_amount"));
        }
        if (args.containsKey("order_amount")) {
            queryParams.add("order_amount=" + args.get("order_amount"));
        }
        if (args.containsKey("options")) {
            queryParams.add("options=" + args.get("options"));
        }
        if (args.containsKey("attachment")) {
            queryParams.add("attachment=" + args.get("attachment"));
        }
        if (args.containsKey("shipping_address")) {
            queryParams.add("shipping_address=" + args.get("shipping_address"));
        }
        if (args.containsKey("billing_address")) {
            queryParams.add("billing_address=" + args.get("billing_address"));
        }
        if (args.containsKey("merchant_urls")) {
            queryParams.add("merchant_urls=" + args.get("merchant_urls"));
        }
        if (args.containsKey("customer")) {
            queryParams.add("customer=" + args.get("customer"));
        }
        if (args.containsKey("custom_payment_method_ids")) {
            queryParams.add("custom_payment_method_ids=" + args.get("custom_payment_method_ids"));
        }
        if (args.containsKey("order_lines")) {
            queryParams.add("order_lines=" + args.get("order_lines"));
        }
        if (args.containsKey("payment_method_categories")) {
            queryParams.add("payment_method_categories=" + args.get("payment_method_categories"));
        }
                
                String queryString = queryParams.isEmpty() ? "" : "?" + String.join("&", queryParams);
                String url = config.getBaseUrl() + "/api/v2/post_payments_v1_sessions_session_id" + queryString;
                
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
    
    public static MCPServer.Tool createPost_Payments_V1_Sessions_Session_IdTool(MCPServer.APIConfig config) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("type", "object");
        Map<String, Object> properties = new HashMap<>();
        Map<String, Object> session_idProperty = new HashMap<>();
        session_idProperty.put("type", "string");
        session_idProperty.put("required", true);
        session_idProperty.put("description", "session_id");
        properties.put("session_id", session_idProperty);
        Map<String, Object> purchase_countryProperty = new HashMap<>();
        purchase_countryProperty.put("type", "string");
        purchase_countryProperty.put("required", false);
        purchase_countryProperty.put("description", "Input parameter: The purchase country of the customer. The billing country always overrides purchase country if the values are different. Formatted according to ISO 3166 alpha-2 standard, e.g. GB, SE, DE, US, etc.");
        properties.put("purchase_country", purchase_countryProperty);
        Map<String, Object> client_tokenProperty = new HashMap<>();
        client_tokenProperty.put("type", "string");
        client_tokenProperty.put("required", false);
        client_tokenProperty.put("description", "Input parameter: Token to be passed to the JS client");
        properties.put("client_token", client_tokenProperty);
        Map<String, Object> localeProperty = new HashMap<>();
        localeProperty.put("type", "string");
        localeProperty.put("required", false);
        localeProperty.put("description", "Input parameter: Used to define the language and region of the customer. The locale follows the format of (RFC 1766)[https://datatracker.ietf.org/doc/rfc1766/], meaning its value consists of language-country. The following values are applicable: AT: \"de-AT\", \"de-DE\", \"en-DE\" BE: \"be-BE\", \"nl-BE\", \"fr-BE\", \"en-BE\" CH: \"it-CH\", \"de-CH\", \"fr-CH\", \"en-CH\" DE: \"de-DE\", \"de-AT\", \"en-DE\" DK: \"da-DK\", \"en-DK\" ES: \"es-ES\", \"ca-ES\", \"en-ES\" FI: \"fi-FI\", \"sv-FI\", \"en-FI\" GB: \"en-GB\" IT: \"it-IT\", \"en-IT\" NL: \"nl-NL\", \"en-NL\" NO: \"nb-NO\", \"en-NO\" PL: \"pl-PL\", \"en-PL\" SE: \"sv-SE\", \"en-SE\" US: \"en-US\".");
        properties.put("locale", localeProperty);
        Map<String, Object> acquiring_channelProperty = new HashMap<>();
        acquiring_channelProperty.put("type", "string");
        acquiring_channelProperty.put("required", false);
        acquiring_channelProperty.put("description", "Input parameter: The acquiring channel in which the session takes place. Ecommerce is default unless specified. Any other values should be defined in the agreement.");
        properties.put("acquiring_channel", acquiring_channelProperty);
        Map<String, Object> statusProperty = new HashMap<>();
        statusProperty.put("type", "string");
        statusProperty.put("required", false);
        statusProperty.put("description", "Input parameter: The current status of the session. Possible values: 'complete', 'incomplete' where 'complete' is set when the order has been placed.");
        properties.put("status", statusProperty);
        Map<String, Object> merchant_reference1Property = new HashMap<>();
        merchant_reference1Property.put("type", "string");
        merchant_reference1Property.put("required", false);
        merchant_reference1Property.put("description", "Input parameter: Used for storing merchant's internal order number or other reference.");
        properties.put("merchant_reference1", merchant_reference1Property);
        Map<String, Object> designProperty = new HashMap<>();
        designProperty.put("type", "string");
        designProperty.put("required", false);
        designProperty.put("description", "Input parameter: Design package to use in the session. This can only by used if a custom design has been implemented for Klarna Payments and agreed upon in the agreement. It might have a financial impact. Delivery manager will provide the value for the parameter.");
        properties.put("design", designProperty);
        Map<String, Object> expires_atProperty = new HashMap<>();
        expires_atProperty.put("type", "string");
        expires_atProperty.put("required", false);
        expires_atProperty.put("description", "Input parameter: Session expiration date");
        properties.put("expires_at", expires_atProperty);
        Map<String, Object> purchase_currencyProperty = new HashMap<>();
        purchase_currencyProperty.put("type", "string");
        purchase_currencyProperty.put("required", false);
        purchase_currencyProperty.put("description", "Input parameter: The purchase currency of the order. Formatted according to ISO 4217 standard, e.g. USD, EUR, SEK, GBP, etc.");
        properties.put("purchase_currency", purchase_currencyProperty);
        Map<String, Object> intentProperty = new HashMap<>();
        intentProperty.put("type", "string");
        intentProperty.put("required", false);
        intentProperty.put("description", "Input parameter: Intent for the session. The field is designed to let partners inform Klarna of the purpose of the customer’s session.");
        properties.put("intent", intentProperty);
        Map<String, Object> merchant_dataProperty = new HashMap<>();
        merchant_dataProperty.put("type", "string");
        merchant_dataProperty.put("required", false);
        merchant_dataProperty.put("description", "Input parameter: Pass through field to send any information about the order to be used later for reference while retrieving the order details (max 6000 characters)");
        properties.put("merchant_data", merchant_dataProperty);
        Map<String, Object> merchant_reference2Property = new HashMap<>();
        merchant_reference2Property.put("type", "string");
        merchant_reference2Property.put("required", false);
        merchant_reference2Property.put("description", "Input parameter: Used for storing merchant's internal order number or other reference. The value is available in the settlement files. (max 255 characters).");
        properties.put("merchant_reference2", merchant_reference2Property);
        Map<String, Object> authorization_tokenProperty = new HashMap<>();
        authorization_tokenProperty.put("type", "string");
        authorization_tokenProperty.put("required", false);
        authorization_tokenProperty.put("description", "Input parameter: Authorization token.");
        properties.put("authorization_token", authorization_tokenProperty);
        Map<String, Object> order_tax_amountProperty = new HashMap<>();
        order_tax_amountProperty.put("type", "string");
        order_tax_amountProperty.put("required", false);
        order_tax_amountProperty.put("description", "Input parameter: Total tax amount of the order. The value should be in non-negative minor units. Eg: 25 Euros should be 2500.");
        properties.put("order_tax_amount", order_tax_amountProperty);
        Map<String, Object> order_amountProperty = new HashMap<>();
        order_amountProperty.put("type", "string");
        order_amountProperty.put("required", false);
        order_amountProperty.put("description", "Input parameter: Total amount of the order including tax and any available discounts. The value should be in non-negative minor units. Eg: 25 Euros should be 2500.");
        properties.put("order_amount", order_amountProperty);
        Map<String, Object> optionsProperty = new HashMap<>();
        optionsProperty.put("type", "string");
        optionsProperty.put("required", false);
        optionsProperty.put("description", "");
        properties.put("options", optionsProperty);
        Map<String, Object> attachmentProperty = new HashMap<>();
        attachmentProperty.put("type", "string");
        attachmentProperty.put("required", false);
        attachmentProperty.put("description", "");
        properties.put("attachment", attachmentProperty);
        Map<String, Object> shipping_addressProperty = new HashMap<>();
        shipping_addressProperty.put("type", "string");
        shipping_addressProperty.put("required", false);
        shipping_addressProperty.put("description", "");
        properties.put("shipping_address", shipping_addressProperty);
        Map<String, Object> billing_addressProperty = new HashMap<>();
        billing_addressProperty.put("type", "string");
        billing_addressProperty.put("required", false);
        billing_addressProperty.put("description", "");
        properties.put("billing_address", billing_addressProperty);
        Map<String, Object> merchant_urlsProperty = new HashMap<>();
        merchant_urlsProperty.put("type", "string");
        merchant_urlsProperty.put("required", false);
        merchant_urlsProperty.put("description", "");
        properties.put("merchant_urls", merchant_urlsProperty);
        Map<String, Object> customerProperty = new HashMap<>();
        customerProperty.put("type", "string");
        customerProperty.put("required", false);
        customerProperty.put("description", "");
        properties.put("customer", customerProperty);
        Map<String, Object> custom_payment_method_idsProperty = new HashMap<>();
        custom_payment_method_idsProperty.put("type", "string");
        custom_payment_method_idsProperty.put("required", false);
        custom_payment_method_idsProperty.put("description", "Input parameter: Promo codes - The array could be used to define which of the configured payment options within a payment category (pay_later, pay_over_time, etc.) should be shown for this purchase. Discuss with the delivery manager to know about the promo codes that will be configured for your account. The feature could also be used to provide promotional offers to specific customers (eg: 0% financing). Please be informed that the usage of this feature can have commercial implications.");
        properties.put("custom_payment_method_ids", custom_payment_method_idsProperty);
        Map<String, Object> order_linesProperty = new HashMap<>();
        order_linesProperty.put("type", "string");
        order_linesProperty.put("required", false);
        order_linesProperty.put("description", "Input parameter: The array containing list of line items that are part of this order. Maximum of 1000 line items could be processed in a single order.");
        properties.put("order_lines", order_linesProperty);
        Map<String, Object> payment_method_categoriesProperty = new HashMap<>();
        payment_method_categoriesProperty.put("type", "string");
        payment_method_categoriesProperty.put("required", false);
        payment_method_categoriesProperty.put("description", "Input parameter: Available payment method categories");
        properties.put("payment_method_categories", payment_method_categoriesProperty);
        parameters.put("properties", properties);
        
        MCPServer.ToolDefinition definition = new MCPServer.ToolDefinition(
            "post_payments_v1_sessions_session_id",
            "Update an existing payment session",
            parameters
        );
        
        return new MCPServer.Tool(definition, getPost_Payments_V1_Sessions_Session_IdHandler(config));
    }
    
}