import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { StudentsModule } from './students/students.module';
import { MongooseModule } from '@nestjs/mongoose';
import { ProfessorsModule } from './professors/professors.module';

@Module({
  imports: [StudentsModule, MongooseModule.forRoot('mongodb+srv://nicolasgregoriof:314949As@webmobile.bbki97r.mongodb.net/professors_db?retryWrites=true&w=majority'), ProfessorsModule ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
