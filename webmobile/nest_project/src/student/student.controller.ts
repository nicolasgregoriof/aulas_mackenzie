import {Body, Controller,Get,Post } from '@nestjs/common';
import { Student } from './student.model';
import { StudentService } from './student.service';

@Controller('student')
export class StudentController {
    constructor(private readonly studentService:StudentService){}

    @Get()
    readAllStudents(): Promise<any>{
        return this.studentService.readStudents();
    }

    @Post()
    async createStudent(@Body() student: Student): Promise<any>{
        var response = await this.studentService.createStudent(student);
        return {id: response};
    }
}
