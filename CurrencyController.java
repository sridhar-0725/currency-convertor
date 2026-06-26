package com.example.currencyconverter.controller;

import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CurrencyController {

    private final Map<String, Double> rates = new LinkedHashMap<>();
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CurrencyController() {
        initializeSeedRates();
    }

    private void initializeSeedRates() {
        rates.put("USD", 1.0);
        rates.put("EUR", 0.92);
        rates.put("INR", 83.5);
        rates.put("GBP", 0.79);
        rates.put("JPY", 156.0);
        rates.put("AUD", 1.52);
        rates.put("CAD", 1.36);
        rates.put("CHF", 0.90);
        rates.put("CNY", 7.24);
        rates.put("AED", 3.67);
        rates.put("SGD", 1.35);
        rates.put("HKD", 7.82);
        rates.put("SEK", 10.64);
        rates.put("NZD", 1.66);
        rates.put("KRW", 1340.0);
        rates.put("NOK", 10.65);
        rates.put("MXN", 17.0);
        rates.put("PLN", 3.95);
        rates.put("ZAR", 18.4);
        rates.put("BRL", 5.47);
        rates.put("TRY", 32.0);
        rates.put("SAR", 3.75);
        rates.put("THB", 35.0);
        rates.put("MYR", 4.69);
        rates.put("IDR", 16000.0);
        rates.put("PHP", 57.0);
        rates.put("DKK", 6.88);
        rates.put("CZK", 22.9);
        rates.put("HUF", 356.0);
        rates.put("ILS", 3.63);
        rates.put("CLP", 930.0);
        rates.put("COP", 4000.0);
        rates.put("ARS", 890.0);
        rates.put("RON", 4.57);
        rates.put("BGN", 1.80);
        rates.put("HRK", 7.0);
        rates.put("ISK", 138.0);
        rates.put("RUB", 92.0);
        rates.put("UAH", 41.0);
        rates.put("PKR", 278.0);
        rates.put("BDT", 117.0);
        rates.put("VND", 26200.0);
        rates.put("KES", 129.0);
        rates.put("NGN", 1610.0);
        rates.put("EGP", 49.0);
        rates.put("MAD", 10.1);
        rates.put("TND", 3.2);
        rates.put("QAR", 3.64);
        rates.put("KWD", 0.31);
        rates.put("OMR", 0.38);
        rates.put("BHD", 0.38);
        rates.put("JOD", 0.71);
        rates.put("LKR", 323.0);
        rates.put("MVR", 15.4);
        rates.put("NPR", 133.0);
        rates.put("CRC", 515.0);
        rates.put("DOP", 58.0);
        rates.put("PEN", 3.7);
        rates.put("BOB", 6.9);
        rates.put("UYU", 39.0);
        rates.put("PYG", 7370.0);
        rates.put("TZS", 2600.0);
        rates.put("UGX", 3700.0);
        rates.put("AMD", 390.0);
        rates.put("GEL", 2.75);
        rates.put("AZN", 1.70);
        rates.put("KZT", 488.0);
        rates.put("BYN", 3.3);
        rates.put("MNT", 3450.0);
        rates.put("UZS", 12750.0);
        rates.put("TWD", 32.7);
        rates.put("BWP", 13.6);
        rates.put("KHR", 4100.0);
        rates.put("LAK", 21400.0);
        rates.put("MMK", 2090.0);
        rates.put("MOP", 8.0);
        rates.put("FJD", 2.25);
        rates.put("WST", 2.70);
        rates.put("XAF", 600.0);
        rates.put("XOF", 600.0);
        rates.put("XPF", 110.0);
        rates.put("ALL", 97.0);
        rates.put("BAM", 1.72);
        rates.put("GHS", 13.6);
        rates.put("RSD", 108.0);
        rates.put("MDL", 18.0);
        rates.put("MKD", 56.0);
        rates.put("SYP", 13000.0);
        rates.put("IQD", 1300.0);
        rates.put("AFN", 71.0);
        rates.put("GTQ", 7.8);
        rates.put("NIO", 36.0);
        rates.put("HNL", 24.0);
        rates.put("SVC", 8.7);
        rates.put("TTD", 6.8);
        rates.put("JMD", 156.0);
        rates.put("BZD", 2.0);
        rates.put("BSD", 1.0);
        rates.put("AWG", 1.8);
        rates.put("ANG", 1.79);
        rates.put("CRC", 515.0);
        rates.put("DOP", 58.0);
        rates.put("PEN", 3.7);
        rates.put("BOB", 6.9);
        rates.put("UYU", 39.0);
        rates.put("PYG", 7370.0);
        rates.put("TZS", 2600.0);
        rates.put("UGX", 3700.0);
        rates.put("AMD", 390.0);
        rates.put("GEL", 2.75);
        rates.put("AZN", 1.70);
        rates.put("KZT", 488.0);
        rates.put("BYN", 3.3);
        rates.put("MNT", 3450.0);
        rates.put("UZS", 12750.0);
        rates.put("TWD", 32.7);
    }

    @GetMapping("/rates")
    public Map<String, Double> getRates() {
        Map<String, Double> merged = new LinkedHashMap<>(rates);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://open.er-api.com/v6/latest/USD"))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                JsonNode root = objectMapper.readTree(response.body());
                JsonNode ratesNode = root.path("rates");
                if (ratesNode.isObject()) {
                    ratesNode.fields().forEachRemaining(entry -> {
                        String code = entry.getKey();
                        double value = entry.getValue().asDouble();
                        if (code.length() == 3) {
                            merged.put(code, value);
                        }
                    });
                }
            }
        } catch (Exception ex) {
            // Fallback to seed data when the live API is unavailable.
        }
        return merged;
    }

    @GetMapping("/convert")
    public Map<String, Object> convert(@RequestParam String from, @RequestParam String to, @RequestParam double amount) {
        Map<String, Double> currentRates = getRates();
        double fromRate = currentRates.getOrDefault(from.toUpperCase(), 1.0);
        double toRate = currentRates.getOrDefault(to.toUpperCase(), 1.0);
        double converted = amount * toRate / fromRate;

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("from", from.toUpperCase());
        response.put("to", to.toUpperCase());
        response.put("amount", amount);
        response.put("converted", Math.round(converted * 100.0) / 100.0);
        response.put("rate", Math.round((toRate / fromRate) * 10000.0) / 10000.0);
        return response;
    }
}
