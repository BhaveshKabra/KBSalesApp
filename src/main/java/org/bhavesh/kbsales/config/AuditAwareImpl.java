package org.bhavesh.kbsales.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		String str="Bhavesh";
		Optional <String> opt=Optional.of(str);
		// TODO Auto-generated method stub
		//SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
		return opt;
	}

}
