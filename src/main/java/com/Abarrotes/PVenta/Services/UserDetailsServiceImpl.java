package com.Abarrotes.PVenta.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Abarrotes.PVenta.Beans.Usuario;
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
	@Autowired
	private UsuarioServicioImpl USUSI;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Usuario usu = USUSI.findById(1);
		if(usu==null)
		{
			throw new UsernameNotFoundException(username);
		}
		
		return User
				.withUsername(username)
				.password(usu.getPass_user())
				.roles(usu.getNom_user())
				.build();
	}

}
