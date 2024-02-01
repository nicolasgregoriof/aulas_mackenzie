import { Module } from '@nestjs/common';
import { ProfessorsController } from './professors.controller';
import { ProfessorsService } from './professors.service';
import { MongooseModule } from '@nestjs/mongoose';
import { ProfessorsSchema } from './professors.model';

@Module({
  imports: [MongooseModule.forFeature([{name: 'Professors', schema: ProfessorsSchema}])],
  controllers: [ProfessorsController],
  providers: [ProfessorsService]
})
export class ProfessorsModule {}
