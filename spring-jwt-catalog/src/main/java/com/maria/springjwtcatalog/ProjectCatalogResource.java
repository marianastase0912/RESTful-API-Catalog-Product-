package com.maria.springjwtcatalog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.util.concurrent.RateLimiter;

@RestController
public class ProjectCatalogResource {
	
	private RateLimiter rateLimiter = RateLimiter.create(10);
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	public List<Product> getCatalog() {
		
		List<Product> list = new ArrayList<Product>(); 
		list.add(new Product(1,"Coca-Cola", 6.3, "Drinks", "10.06.2020", "11.06.2020"));
		list.add(new Product(2,"Redbull", 7.0, "Drinks", "09.06.2020", "11.06.2020"));
		list.add(new Product(3,"Apples", 8.0, "Fruits", "10.06.2020", "11.06.2020"));
		list.add(new Product(4,"Dunhill", 21.0, "Cigarettes", "01.06.2020", "11.06.2020"));
		list.add(new Product(5,"T-Shirt", 45.99, "Clothing", "21.05.2020", "11.06.2020"));
		list.add(new Product(6,"Chocolate", 5.5, "Sweets", "06.06.2020", "11.06.2020"));
		return list;
	}
	
	@RequestMapping("/catalog")
	public List<Product> returnCatalog() {
		rateLimiter.acquire(1);
		return getCatalog();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/catalog/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getById(@PathVariable("id") long id) { 
		
		Product found = null;
		for(Product pr : getCatalog()) {
			if(id == (pr.getId())) {
				found = pr;
				}
			}
		if (found == null) {
			rateLimiter.acquire(1);
			return (ResponseEntity<Product>) ResponseEntity.notFound();
		}
		rateLimiter.acquire(1);
		return ResponseEntity.ok(found);
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		rateLimiter.acquire(1);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}