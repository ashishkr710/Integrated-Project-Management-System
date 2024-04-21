package IPMS.Integrated.Project.Management.System.Services;

import IPMS.Integrated.Project.Management.System.Model.Task;
import IPMS.Integrated.Project.Management.System.Repositories.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(){return taskRepository.findAll();}

    public Task getTaskById(Long taskId){ return taskRepository.findById(taskId).orElse(null);}

    public Task createTask(Task task){return taskRepository.save(task);}

    public Task updateTask(Long taskId, Task updatedTask){
        return taskRepository.findById(taskId)
                .map(existingTask -> {
                    BeanUtils.copyProperties(updatedTask, existingTask, "taskId");
                    return taskRepository.save(existingTask);
                })
                .orElse(null);
    }

    public void deleteTask(Long taskId){ taskRepository.deleteById(taskId);}
}
