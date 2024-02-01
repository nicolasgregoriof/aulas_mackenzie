import * as mongoose from 'mongoose';

export const StudentSchema = new mongoose.Schema({
    name: {type: String, require: true},
    tia:{type: String, require: true},
    course: {type: String, require: true}
}) 

export interface Student extends mongoose.Document{
    id: string;
    name: string;
    tia: string;
    course: string;
}