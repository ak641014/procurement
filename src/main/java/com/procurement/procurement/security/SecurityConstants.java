// Security constants
package com.procurement.procurement.security;

public class SecurityConstants {

    // JWT token settings
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    // Public URLs (no authentication required)
    public static final String[] PUBLIC_URLS = {
            "/api/auth/**",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    };

    // Login URL
    public static final String LOGIN_URL = "/api/auth/login";

    // Token expiration default (in milliseconds) - optional
    public static final long EXPIRATION_TIME = 864_000_00; // 1 day

    // Secret key (can override via application.properties)
    public static final String SECRET = "MyJwtSecretKey1234567890";
}
