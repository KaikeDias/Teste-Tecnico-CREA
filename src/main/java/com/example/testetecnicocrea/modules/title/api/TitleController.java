package com.example.testetecnicocrea.modules.title.api;

import com.example.testetecnicocrea.modules.title.domain.entities.Title;
import com.example.testetecnicocrea.modules.title.domain.entities.TitleDTO;
import com.example.testetecnicocrea.modules.title.domain.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/titles")
@RestController
public class TitleController {
    @Autowired
    private TitleRepository titleRepository;

    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        try {
            var titles = titleRepository.findAll();

            return ResponseEntity.ok(titles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        try {
            var title = titleRepository.findById(id);

            return ResponseEntity.ok(title);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> createTitle(@RequestBody TitleDTO titleDTO) {
        try {
            var titleId = titleRepository.save(titleDTO);

            return ResponseEntity.status(HttpStatus.CREATED).body(titleId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @PutMapping("")
    public ResponseEntity<Object> updateTitle(@RequestBody Title title) {
        try {
            int titleId = titleRepository.update(title);

            return ResponseEntity.ok(titleId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id) {
        try {
            int titleId = titleRepository.deleteById(id);

            return ResponseEntity.ok(titleId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteALL() {
        try {
            int titleId = titleRepository.deleteAll();

            return ResponseEntity.ok(titleId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    @GetMapping("/professionals/{id}")
    public ResponseEntity<Object> findByProfessionalId(@PathVariable int id) {
        try {
            var titles = titleRepository.findByProfessionalId(id);

            return ResponseEntity.ok(titles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }
}
