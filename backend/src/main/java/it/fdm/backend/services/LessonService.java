package it.fdm.backend.services;

import com.amazonaws.services.s3.model.S3ObjectInputStream;
import it.fdm.backend.dto.VideoLessonDto;
import it.fdm.backend.entities.Privilege;
import it.fdm.backend.entities.ResourceMap;
import it.fdm.backend.enums.Operation;
import it.fdm.backend.repositories.PrivilegeRepository;
import it.fdm.backend.repositories.ResourceMapRepository;
import it.fdm.backend.utils.StorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.UUID;

@Service
public class LessonService {

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Autowired
	private ResourceMapRepository resourceMapRepository;

	public StreamingResponseBody getLessonVideo(UUID videoId, UUID userId) {
		Privilege privilege = privilegeRepository.findOneByUserIdAndVideoId(userId, videoId);

		if (privilege == null || !privilege.getOperation().contains(Operation.READ)) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		ResourceMap resourceMap = resourceMapRepository.findById(videoId);

		return StorageUtil.getObject(resourceMap.getBucketName(), resourceMap.getObjectName());
	}

}
