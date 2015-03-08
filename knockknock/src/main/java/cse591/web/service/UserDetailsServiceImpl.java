package cse591.web.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cse591.web.dao.UserDAO;
import cse591.web.dto.RegisterUser;
import cse591.web.utils.KnockSequence;

@SuppressWarnings("deprecation")
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;
	
	private KnockSequence knockSequence=new KnockSequence();
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		RegisterUser user = userDAO.findUserByUserName(username);
		
		if (user != null) {
			knockSequence.hashAndModulo(user.getUsername());
			String password = user.getPassword();
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new GrantedAuthorityImpl("admin"));
			org.springframework.security.core.userdetails.User userDetail;
			userDetail = new org.springframework.security.core.userdetails.User(
					username, password, authorities);
			return userDetail;
		} else {
			throw new UsernameNotFoundException("Username not Found!!");
		}
	}

	
	
}