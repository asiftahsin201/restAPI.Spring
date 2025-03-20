package com.example.adp;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ModuleController {

    private final ModuleRepository moduleRepository;

    public ModuleController(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @GetMapping("/modules")
    public Iterable<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    @GetMapping("/modules/{id}")
    public Module getModuleById(@PathVariable Long id) {
        return moduleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping("/modules")
    public Module createModule(@RequestBody Module module) {
        return moduleRepository.save(module);
    }

    @PutMapping("/modules/{id}")
    public Module updateModule(@PathVariable Long id, @RequestBody Module moduleDetails) {
        Module module = moduleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        module.setName(moduleDetails.getName());
        module.setPassmark(moduleDetails.getPassmark());
        module.setOption(moduleDetails.getOption());
        module.setBeCertificate(moduleDetails.getBeCertificate());
        module.setEhScore(moduleDetails.getEhScore());
        return moduleRepository.save(module);
    }

    @DeleteMapping("/modules/{id}")
    public Map<String, String> deleteModule(@PathVariable Long id) {
        if (moduleRepository.existsById(id)) {
            moduleRepository.deleteById(id);
            return Collections.singletonMap("message", "module removed");
        } else {
            return Collections.singletonMap("message", "module not found");
        }
    }

    @GetMapping("/modules/passmark/{passmark}")
    public List<Module> getModulesByPassmark(@PathVariable Long passmark) {
        return moduleRepository.findByPassmark(passmark);
    }
}
