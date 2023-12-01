package it.fdm.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoLessonDto {
    private String url;

    public VideoLessonDto setUrl(String url) {
        this.url = url;

        return this;
    }
}
