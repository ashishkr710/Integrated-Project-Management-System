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
import java.util.Date;
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
        try {
            // Save the file to the server
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filePath);
            Files.write(path, bytes);

            // Create FileContent object
            File files = new File();
            files.setFileName(fileName);
            files.setFilePath(filePath);
            files.setProject(new Project(projectId)); // Assuming Project constructor with projectId
            files.setUser(new User(userId)); // Assuming User constructor with userId
            files.setTimestamp(new Date());

            return fileRepository.save(files);
        } catch (IOException e) {
            // Handle file IO exception
            e.printStackTrace(); // For logging
            throw new IOException("Failed to upload file: " + e.getMessage());
        }
//        // Save the file to the server
//        byte[] bytes = file.getBytes();
//        Path path = Paths.get(filePath);
//        Files.write(path, bytes);
//
//        // Create FileContent object
//        File files = new File();
//        files.setFileName(fileName);
//        files.setFilePath(filePath);
//        files.setProject(new Project(projectId)); // Assuming Project constructor with projectId
//        files.setUser(new User(userId)); // Assuming User constructor with userId
//        files.setTimestamp(new Date());
//
//        return fileRepository.save(files);
    }

    public void deleteFile(Long fileId) {
        fileRepository.deleteById(fileId);
    }
}
