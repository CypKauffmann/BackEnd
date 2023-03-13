package com.intiFormation.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component // cette classe est un composant Spring
public class RequestFilter extends OncePerRequestFilter {
	
	@Autowired // injection de dépendance : Spring fournit une instance de UserDetailsService
    private UserDetailsService userDetailsService;

    @Autowired // injection de dépendance : Spring fournit une instance de jwtUtil
    private jwtUtil jwtokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// extraction du token JWT et du nom d'utilisateur à partir de l'en-tête Authorization
		final String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            username = jwtokenUtil.extractUsername(jwt);
        }

        // vérification que le nom d'utilisateur est non null et que l'authentification n'a pas encore été effectuée
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // chargement des détails de l'utilisateur à partir de l'implémentation UserDetailsService
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            // validation du token JWT
            if (jwtokenUtil.validateToken(jwt, userDetails)) {

                // création d'un jeton d'authentification pour l'utilisateur
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                
                // ajout de détails supplémentaires à l'objet UsernamePasswordAuthenticationToken
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                // mise à jour du contexte de sécurité
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        
        // appel du filtre suivant dans la chaîne
        filterChain.doFilter(request, response);

	}

}
