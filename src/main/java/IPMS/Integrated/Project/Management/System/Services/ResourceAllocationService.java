package IPMS.Integrated.Project.Management.System.Services;

import IPMS.Integrated.Project.Management.System.Model.ResourceAllocation;
import IPMS.Integrated.Project.Management.System.Repositories.ResourceAllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceAllocationService {
    @Autowired
    private ResourceAllocationRepository resourceAllocationRepository;

    public List<ResourceAllocation> getAllResourceAllocations() {
        return resourceAllocationRepository.findAll();
    }

    public ResourceAllocation getResourceAllocationById(Long allocationId) {
        return resourceAllocationRepository.findById(allocationId).orElse(null);
    }

    public ResourceAllocation addResourceAllocation(ResourceAllocation resourceAllocation) {
        return resourceAllocationRepository.save(resourceAllocation);
    }

    public void deleteResourceAllocation(Long allocationId) {
        resourceAllocationRepository.deleteById(allocationId);
    }
}
