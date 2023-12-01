package it.fdm.backend.services;

import it.fdm.backend.dto.VideoLessonDto;
import it.fdm.backend.entities.Privilege;
import it.fdm.backend.entities.ResourceMap;
import it.fdm.backend.enums.Operation;
import it.fdm.backend.repositories.PrivilegeRepository;
import it.fdm.backend.repositories.ResourceMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class LessonService {

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Autowired
	private ResourceMapRepository resourceMapRepository;

	public VideoLessonDto getLessonVideo(UUID videoId, UUID userId) {
		Privilege privilege = privilegeRepository.findOneByUserIdAndVideoId(userId, videoId);

		if (privilege == null || !privilege.getOperation().contains(Operation.READ)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		ResourceMap resourceMap = resourceMapRepository.findById(videoId);

		// get resource from storage
		return new VideoLessonDto().setUrl(resourceMap.getObjectName());
}

}
