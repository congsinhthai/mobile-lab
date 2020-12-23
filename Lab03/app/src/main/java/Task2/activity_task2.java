package Task2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.lab03.R;

import java.util.List;

public class activity_task2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        TextView tvStudents = (TextView) findViewById(R.id.tv_student);

        // Init database
        StudentDBHelper db = new StudentDBHelper(this);

        // Add students
        addStudents(db);

        // Update Students
        updateStudents(db);

        // Show students
        showStudents(db, tvStudents);
    }

    private void addStudents(StudentDBHelper db) {
        db.insertStudent(new Student(1, "An", "MMTT2011"));
        db.insertStudent(new Student(2, "Bình", "MMTT2012"));
        db.insertStudent(new Student(3, "Châu", "MMTT2013"));
        db.insertStudent(new Student(4, "Dương", "MMTT2014"));
        db.insertStudent(new Student(5, "Hiển", "MMTT2015"));
        db.insertStudent(new Student(6, "Khánh", "MMTT2016"));
        db.insertStudent(new Student(7, "Lộc", "MMTT2017"));
        db.insertStudent(new Student(8, "Minh", "MMTT2018"));
    }

    private void updateStudents(StudentDBHelper db) {
        db.updateStudent(new Student(3, "Ý", "ATTT2014"));
        db.updateStudent(new Student(4, "Việt", "ATTT2015"));
        db.updateStudent(new Student(5, "Tân", "ATTT2016"));
        db.updateStudent(new Student(6, "Sang", "ATTT2017"));
    }

    private void showStudents(StudentDBHelper db, TextView tv) {
        List<Student> students = db.getAllStudents();
        String all = "Students: \n";

        for (Student student : students) {

            all += student.getId() + " - " + student.getName() + " - " + student.getClassName() + "\n";
        }

        tv.setText(all);
    }
}
