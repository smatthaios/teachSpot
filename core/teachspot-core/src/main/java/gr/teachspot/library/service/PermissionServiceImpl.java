package gr.teachspot.library.service;

import gr.teachspot.library.domain.Permission;
import gr.teachspot.library.persistence.PermissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** The type Permission service impl contains all the business methods related to a {@link gr.teachspot.library.domain.Permission}. */
@Service
public class PermissionServiceImpl implements PermissionService {

	/** Logger to be used */
	private final static Logger LOG = LoggerFactory.getLogger(PermissionServiceImpl.class);

	/** The Permission Repository. */
	@Autowired
	private PermissionRepository permissionRepository;


	@Override
	public Permission find(Long permissionId) {
		return permissionRepository.find(permissionId);
	}

	@Override
	public List<Permission> get(Long profileId) {
		return permissionRepository.get(profileId);
	}

	@Override
	public void delete(List<Long> permissionList) {
		for(Long permissionId : permissionList) {
			permissionRepository.delete(permissionId);
		}
	}
}
