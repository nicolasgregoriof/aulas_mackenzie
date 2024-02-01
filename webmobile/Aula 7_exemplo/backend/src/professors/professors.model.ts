import * as mongoose from 'mongoose';

export const ProfessorsSchema = new mongoose.Schema({
    name: {type: String, require: true},
    cod_professor: {type: String, require: true},
    course: {type: String,require: true},
})

export interface Professors extends mongoose.Document{
    id: string;
    name: string;
    cod_professor: string;
    course: string;
}