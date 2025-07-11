package com.canerkilinc.api.controller;

import com.canerkilinc.api.entity.Lecture;
import com.canerkilinc.api.entity.User;
import com.canerkilinc.api.service.ILectureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lectures")

public class LectureController {

    private final ILectureService lectureService;

    public LectureController(ILectureService lectureService){
        this.lectureService = lectureService;
    }

    @GetMapping
    ResponseEntity<Page<Lecture>> getLectures(@RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer pageSize){
        return ResponseEntity.ok(lectureService.getAll(PageRequest.of(page,pageSize, Sort.by("id"))));
    }

    @PostMapping
    public ResponseEntity<Lecture> createLecture(@RequestBody Lecture lecture){
        return ResponseEntity.ok(lectureService.save(lecture));
    }

    @GetMapping("/{id}")
    ResponseEntity<Lecture> getLecture(@PathVariable Integer id){
        return ResponseEntity.ok(lectureService.getById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteLecture(@PathVariable Integer id){
        lectureService.delete(id);
        return ResponseEntity.ok().build();
    }

}
