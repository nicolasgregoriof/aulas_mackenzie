import { Controller, Post, Get, Body, Patch, Delete,Param } from '@nestjs/common';
import { Professors } from './professors.model';
import { ProfessorsService } from './professors.service';

@Controller('professors')
export class ProfessorsController {
    constructor(private readonly professorsService:ProfessorsService){}

    @Get()
    readAllProfessors(): Promise<any>{
        return this.professorsService.readProfessors();
    }

    @Get(':cod_professor')
    readAllProfessor( @Param('cod_professor') cod_professor: string): Promise<any>{
        return this.professorsService.readProfessor(cod_professor);
    }

    @Post()
    async createProfessors(@Body() professors: Professors): Promise<any>{
        var response = await this.professorsService.createProfessors(professors);
        return {id: response};
    }

    @Patch()
    async updateProfessors(@Body() professors: Professors){
        await this.professorsService.updateProfessors(professors);
    }

    @Delete(':cod_professor')
    async deleteProfessors(@Param('cod_professor') cod_professor: number){
        await this.professorsService.deleteProfessors(cod_professor);
        return null;
    }
}
