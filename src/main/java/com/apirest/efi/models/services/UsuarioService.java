package com.apirest.efi.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.efi.models.dao.IUsuarioDao;
import com.apirest.efi.models.entity.Usuarios;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

  public BCryptPasswordEncoder passwordEncoder() {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    return bCryptPasswordEncoder;
  }

  private final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

  @Autowired
  private IUsuarioDao usuarioDao;

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Usuarios usuario = usuarioDao.findByUsername(username);

    if (usuario == null) {
      logger.error("Error en el Login: no existe el usuario '" + username + "' En el Sistema!");
      throw new UsernameNotFoundException(
          "Error en el Login: no existe el usuario '" + username + "' En el Sistema!");
    }

    List<GrantedAuthority> authorities = usuario.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getNombre()))
        .peek(authority -> logger.info("Role :" + authority.getAuthority())).collect(Collectors.toList());

    return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
        authorities);
  }

  @Override
  @Transactional(readOnly = true)
  public Usuarios findByUsername(String username) {
    return usuarioDao.findByUsername(username);
  }
}
