package IPMS.Integrated.Project.Management.System.Services;

import IPMS.Integrated.Project.Management.System.Model.File;
import IPMS.Integrated.Project.Management.System.Model.Project;
import IPMS.Integrated.Project.Management.System.Model.User;
import IPMS.Integrated.Project.Management.System.Repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    // Directory to store uploaded files
    private static final String UPLOAD_DIR = "/path/to/upload/directory/";

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public File getFileById(Long fileId) {
        return fileRepository.findById(fileId).orElse(null);
    }

    public File uploadFile(MultipartFile file, Long projectId, Long userId) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = UPLOAD_DIR + fileName;

        // Save the file to the server
        byte[] bytes = file.getBytes();
        Path path = Paths.get(filePath);
        Files.write(path, bytes);

        // Create FileContent object
        File fileContent = new File();
//        file.setFileName(fileName);
//        file.setFilePath(filePath);
//        file.setProject(new Project(projectId)); // Assuming Project constructor with projectId
//        file.setUser(new User(userId)); // Assuming User constructor with userId
//        file.setTimestamp(new Date());

        return fileRepository.save(fileContent);
    }

    public void deleteFile(Long fileId) {
        fileRepository.deleteById(fileId);
    }
}
