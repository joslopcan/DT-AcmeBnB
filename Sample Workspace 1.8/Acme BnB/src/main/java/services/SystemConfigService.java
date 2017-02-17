
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.SystemConfigRepository;
import domain.SystemConfig;

@Service
@Transactional
public class SystemConfigService {

	@Autowired
	private SystemConfigRepository	systemConfigRepository;


	public SystemConfigService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public SystemConfig create() {
		SystemConfig result;

		result = new SystemConfig();
		return result;
	}

	public Collection<SystemConfig> findAll() {
		Collection<SystemConfig> result;

		result = systemConfigRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public SystemConfig findOne(int SystemConfigId) {
		SystemConfig result;

		result = systemConfigRepository.findOne(SystemConfigId);

		return result;
	}

	public void save(SystemConfig systemConfig) {
		Assert.notNull(systemConfig);

		systemConfigRepository.save(systemConfig);
	}

	public void delete(SystemConfig systemConfig) {
		Assert.notNull(systemConfig);
		Assert.isTrue(systemConfig.getId() != 0);

		systemConfigRepository.delete(systemConfig);
	}

	// Other business methods -------------------------------------------------

}
