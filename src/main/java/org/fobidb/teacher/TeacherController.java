package org.fobidb.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// API LAYER *******************************************************

@RestController //Die Klasse ist ein Rest-Controller. Dies bedeutet, dass sie HTTP-Anfragen empfängt und HTTP-Antworten zurückgibt. Außerdem: Alle Objekte sind Beans
@RequestMapping(path = "api/v1/teacher") //Pfad im Browser
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    @PostMapping
    public void registerNewTeacher(@RequestBody Teacher teacher){
        teacherService.addNewTeacher(teacher);
    }

    @DeleteMapping(path = "{teacherId}")
    public void deleteTeacher(@PathVariable ("teacherId") Long teacherId){
        teacherService.deleteTeacher(teacherId);
    }
}
