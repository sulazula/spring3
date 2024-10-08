package ru.gb.springdemo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springdemo.repository.ReaderRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    ReaderRepository readerRepository;

    @GetMapping
    public ResponseEntity<List<Reader>> getAllReaders() {
        List<Reader> readers = readerRepository.getReaders();

        return ResponseEntity.ok(readers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reader> getById(@PathVariable Long id) {
        Optional<Reader> reader = Optional.ofNullable(readerRepository.getReaderById(id));

        return reader.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reader> createReader(@RequestBody Reader reader) {
        readerRepository.addReader(reader);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReader(@PathVariable Long id) {
        boolean deleted = readerRepository.deleteReaderById(id);

        if (deleted) {
            return ResponseEntity.ok("Removed");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
