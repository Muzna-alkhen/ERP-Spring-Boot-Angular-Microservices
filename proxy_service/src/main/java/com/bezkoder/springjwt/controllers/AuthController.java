package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.dto.PermissionDto;
import com.bezkoder.springjwt.dto.RoleResponseDto;
import com.bezkoder.springjwt.dto.UserResponseDto;
import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Permission;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.LoginRequest;
import com.bezkoder.springjwt.payload.request.SignupRequest;
import com.bezkoder.springjwt.payload.response.JwtResponse;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.repository.PermissionRepository;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.jwt.JwtUtils;
import com.bezkoder.springjwt.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
    AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
    PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	PermissionRepository permissionRepository;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

			System.out.println(jwtUtils.getTenantIdFromJwtToken(jwt));




		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(),
												 userDetails.getTenantId(),
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}


		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
							"Tenant_"+signUpRequest.getUsername()
		);

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;

					case "general_manager":
						Role gen_manRole = roleRepository.findByName(ERole.ROLE_GEN_MAN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(gen_manRole);

						break;


				case "hr_manager":
						Role hr_manRole = roleRepository.findByName(ERole.ROLE_HR_MAN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(hr_manRole);

						break;



					case "fi_manager":
						Role fi_manRole = roleRepository.findByName(ERole.ROLE_FI_MAN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(fi_manRole);

						break;

					case "hr_emp":
						Role hr_empRole = roleRepository.findByName(ERole.ROLE_HR_EMP)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(hr_empRole);

						break;





					case "fi_emp":
						Role fi_empRole = roleRepository.findByName(ERole.ROLE_FI_EMP)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(fi_empRole);

						break;

					default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@GetMapping("/user-by-token")

	public UserResponseDto getUser(@RequestHeader (name="Authorization") String token)

	{


		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		String username = userDetails.getUsername();

		Optional<User> user =userRepository.findByUsername(username);

		UserResponseDto dto = new UserResponseDto();
		dto.setId(user.get().getId());
		dto.setEmail(user.get().getEmail());
		dto.setUsername(user.get().getUsername());

		Set<Role> roles = user.get().getRoles();
		List<RoleResponseDto> roles_dto = new ArrayList();

		for (Role role :
			 roles) {

		RoleResponseDto role_dto = new RoleResponseDto();
		role_dto.setId(role.getId());
		role_dto.setName(role.getName().name());
		roles_dto.add(role_dto);

		}
        dto.setRoles(roles_dto);

     return dto;
	}
	@GetMapping("/roles")

	public List<RoleResponseDto> getRoles()

	{
		List<Role> roles = roleRepository.findAll();
		List<RoleResponseDto> list = new ArrayList();

		for (Role role: roles)
			  {
			RoleResponseDto dto = new RoleResponseDto();
			dto.setId(role.getId());
			dto.setName(role.getName().name());
			list.add(dto);
		}

		return list;
	}




	@GetMapping("/users")

	public List<UserResponseDto> getUsers()

	{
		List<User> users = userRepository.findAll();
		List<UserResponseDto> list = new ArrayList();

		for (User user: users)
		{
			UserResponseDto dto = new UserResponseDto();
			dto.setId(user.getId());
			dto.setUsername(user.getUsername());
			dto.setEmail(user.getEmail());
		    Set<Role> _roles =  user.getRoles();
		    List<Role> roles = new ArrayList();
		    roles.addAll(_roles);
		    List<RoleResponseDto> roles_dto = new ArrayList();
			for (Role role :
					roles) {

				RoleResponseDto role_dto = new RoleResponseDto();
				role_dto.setId(role.getId());
				role_dto.setName(role.getName().name());
				roles_dto.add(role_dto);
			}
		    dto.setRoles(roles_dto);
			list.add(dto);
		}

		return list;
	}


	@GetMapping("/permissions")
	List<PermissionDto> get()
	{
		List<Permission> permissions = permissionRepository.findAll();
		List<PermissionDto>  list = new ArrayList();


		for (Permission permission: permissions)
		{
			PermissionDto dto = new PermissionDto();
			dto.setId(permission.getId());
			dto.setName(permission.getName());
			dto.setUrl(permission.getUrl());
			list.add(dto);
		}



		return list;
	}

}
