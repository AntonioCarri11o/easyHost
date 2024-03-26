package mx.edu.utez.easyHost.controller;

import mx.edu.utez.easyHost.dto.AuthDto;
import mx.edu.utez.easyHost.model.Usuario;
import mx.edu.utez.easyHost.service.JwtService;
import mx.edu.utez.easyHost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService  ;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/index")
    public  String index(){
        return "Servicio index";
    }


    @PostMapping("/registrame")
    public  String registrame(@RequestBody Usuario usuario){
        return service.guardarUser(usuario);
    }
    @PostMapping("/admin/test")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public  String soloAdmin (){
        return "Este endpint es solo para admin";
    }

    @PostMapping("/user/test")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public  String parauser (){
        return  "Este es pa user";
    }
    @PostMapping("/login")
    public  String login (@RequestBody AuthDto authDto){
        try {
            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(authDto.getEmail(),authDto.getPassword())
                    )   ;
            if (authentication.isAuthenticated()){
                return jwtService.generateToken(authDto.getEmail());
            }else {
                System.out.println("No valido");
                throw  new UsernameNotFoundException("Ususario no valido");

            }
        }catch (Exception e){
            System.out.println("No valido catch");

            throw  new UsernameNotFoundException("Ususario no valido");

        }
    }

}
