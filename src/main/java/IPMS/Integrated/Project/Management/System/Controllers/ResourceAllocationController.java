package IPMS.Integrated.Project.Management.System.Controllers;


import IPMS.Integrated.Project.Management.System.Model.ResourceAllocation;
import IPMS.Integrated.Project.Management.System.Services.ResourceAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resource-allocations")
public class ResourceAllocationController {

    @Autowired
    private ResourceAllocationService resourceAllocationService;

    @GetMapping
    public ResponseEntity<List<ResourceAllocation>> getAllResourceAllocations() {
        List<ResourceAllocation> allocations = resourceAllocationService.getAllResourceAllocations();
        return new ResponseEntity<>(allocations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceAllocation> getResourceAllocationById(@PathVariable("id") Long allocationId) {
        ResourceAllocation allocation = resourceAllocationService.getResourceAllocationById(allocationId);
        if (allocation != null) {
            return new ResponseEntity<>(allocation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ResourceAllocation> addResourceAllocation(@RequestBody ResourceAllocation resourceAllocation) {
        ResourceAllocation newAllocation = resourceAllocationService.addResourceAllocation(resourceAllocation);
        return new ResponseEntity<>(newAllocation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResourceAllocation(@PathVariable("id") Long allocationId) {
        resourceAllocationService.deleteResourceAllocation(allocationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
