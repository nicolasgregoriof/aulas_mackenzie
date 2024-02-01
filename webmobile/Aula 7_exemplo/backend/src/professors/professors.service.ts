import { Injectable, NotFoundException } from '@nestjs/common';
import { Professors } from './professors.model';
import { InjectModel } from '@nestjs/mongoose';
import {Model} from 'mongoose';

@Injectable()
export class ProfessorsService {
    constructor(@InjectModel('Professors') private readonly professorsModel: Model<Professors>){}

    //CRUD - CREATE, READ, UPDATE, DELETE
    //CREATE
    async createProfessors(professors: Professors){
        const professorsModel = new this.professorsModel(
            {
                name: professors.name,
                cod_professor: professors.cod_professor,
                course: professors.course
            }
        );
        const result = await professorsModel.save();
        return result.id as string;
    }

    //READ
    async readProfessors(){
        const professors = await this.professorsModel.find().exec();
        return professors;
    }

    //READ BY TIA
    async readProfessor(cod_professor: string){
        const professor = await this.professorsModel.findOne({cod_professor: cod_professor}).exec();
        return professor;
    }

    //UPDATE
    async updateProfessors(professors: Professors){
        const updateProfessors = await this.professorsModel.findOne({cod_professor: professors.cod_professor});
        if(!updateProfessors){
            throw new NotFoundException('Could not find the professor.');
        }
        if(professors.name){
            updateProfessors.name = professors.name
        }
        if(professors.course){
            updateProfessors.course = professors.course
        }
        updateProfessors.save()
    }



    //DELETE
    async deleteProfessors(cod_professor: number){
        const result = await this.professorsModel.deleteOne({cod_professor: cod_professor}).exec();
        if (result.n == 0){
            throw new NotFoundException('Could not delete the professor');
        }
    }
}
