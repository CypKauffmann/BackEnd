package com.intiFormation.config;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service // cette classe est un service Spring
public class jwtUtil {
	
	// clé secrète utilisée pour signer et valider le token JWT
	private String SECRET_KEY = "secret";

    // extraction du nom d'utilisateur à partir du token JWT
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // extraction de la date d'expiration à partir du token JWT
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // extraction de la revendication (claim) spécifiée à partir du token JWT
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // extraction de toutes les revendications (claims) à partir du token JWT
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    // vérification que le token JWT est expiré
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // génération d'un token JWT pour l'utilisateur spécifié
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    // création d'un token JWT avec les revendications et le nom d'utilisateur spécifiés
    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // expiration du token dans 10 heures
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    // validation du token JWT pour l'utilisateur spécifié
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
        
        
   /*  En résumé, cette classe fournit des méthodes pour créer, valider et extraire des informations à partir d'un token JWT. Elle utilise la bibliothèque io.jsonwebtoken pour créer et analyser le token JWT.
       Les principales fonctionnalités fournies par cette classe sont :

    Extraction du nom d'utilisateur et de la date d'expiration à partir du token JWT
    Extraction d'une revendication (claim) spécifiée à partir du token JWT
    Génération d'un token JWT pour un utilisateur spécifié
    Validation d'un token JWT pour un utilisateur spécifié

Ces fonctionnalités sont implémentées dans les méthodes extractUsername, extractExpiration, extractClaim, createToken, validateToken, etc. */
        
        
        
        
    }

}
