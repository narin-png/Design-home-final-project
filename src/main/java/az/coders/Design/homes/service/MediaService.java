package az.coders.Design.homes.service;

import az.coders.Design.homes.dto.media.MediaDto;
import az.coders.Design.homes.entity.media.Media;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

public interface MediaService {
    MediaDto uploadMedia(Integer mediaTypeId, MultipartFile file);

    void deleteMedia(Integer id);

    Media getMedia(Integer id);

    MediaType getMediaType(String path);

    Resource getResource(String path);
}
