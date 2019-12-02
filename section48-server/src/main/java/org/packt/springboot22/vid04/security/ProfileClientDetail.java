package org.packt.springboot22.vid04.security;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import lombok.Setter;

@Setter
public class ProfileClientDetail implements ClientDetails {

	private String clientId;
	private Set<String> resourceIds;
	private boolean secretRequired;
	private String clientSecret;
	private boolean scoped;
	private Set<String> scopes;
	private Set<String> authGrantTypes;
	
	private Map<String, Object> additionalInformation;
	private boolean autoApprove;
	private Integer refreshTokenValiditySeconds;
	private Integer accessTokenValiditySeconds;
	private Collection<GrantedAuthority> authorities;
	private Set<String> registeredRedirectUri;
	
	@Override
	public String getClientId() {
	    return clientId;
	}
	
	@Override
	public Set<String> getResourceIds() {
		return resourceIds;
	}

	@Override
	public boolean isSecretRequired() {
		// TODO Auto-generated method stub
		return secretRequired;
	}

	@Override
	public String getClientSecret() {
		// TODO Auto-generated method stub
		return clientSecret;
	}

	@Override
	public boolean isScoped() {
		// TODO Auto-generated method stub
		return scoped;
	}

	@Override
	public Set<String> getScope() {
		// TODO Auto-generated method stub
		return scopes;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		// TODO Auto-generated method stub
		return authGrantTypes;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		// TODO Auto-generated method stub
		return registeredRedirectUri;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return accessTokenValiditySeconds;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return refreshTokenValiditySeconds;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		return autoApprove;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return additionalInformation;
	}

}
