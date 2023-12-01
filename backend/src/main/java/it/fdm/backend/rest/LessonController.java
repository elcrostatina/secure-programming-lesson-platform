package it.fdm.backend.rest;

import com.auth0.jwt.interfaces.DecodedJWT;
import it.fdm.backend.dto.VideoLessonDto;
import it.fdm.backend.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.fdm.backend.dto.ValidateTokenDto;
import it.fdm.backend.services.JwtService;
import it.fdm.backend.services.TokenService;

import java.util.UUID;

@RestController()
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private LessonService lessonService;
    
    @GetMapping("/{videoId}/")
    @CrossOrigin(origins = "*")
    public VideoLessonDto create(@PathVariable UUID videoId, @RequestHeader(value="Authorization") String authorizationHeader) {
        DecodedJWT validateTokenDto = jwtService.validateAndReadJwt(authorizationHeader);
        return lessonService.getLessonVideo(videoId, validateTokenDto.getClaim("userId").as(UUID.class));
    }

}
