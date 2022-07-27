package info.yash.social.app.service;

import info.yash.social.app.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface ImageService {

    String updateProfileImage(UserDTO user, MultipartFile multipartFile) throws IOException;

    Path getProfileImagesPath();
}
