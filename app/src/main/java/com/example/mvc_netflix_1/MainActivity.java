package com.example.mvc_netflix_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvc_netflix_1.controller.StudentController;
import com.example.mvc_netflix_1.controller.UserController;
import com.example.mvc_netflix_1.model.StudentWS;
import com.example.mvc_netflix_1.model.UserWS;
import com.example.mvc_netflix_1.model.pojo.Student;
import com.example.mvc_netflix_1.model.pojo.User;

public class MainActivity extends AppCompatActivity {
    private UserController controller;
    private MainActivity view;
    private UserWS model;
    private Button btnUpdate;
    private EditText email;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Cargar View
        view = this;
        //MODEL + VIEW
        controller = new UserController(model, view);
        //Caso de uso -> Obtener estudiante con mvc
        controller.newUser();
        //Cargo los componentes
        email = (EditText) findViewById(R.id.edtEmail);
        pass = (EditText) findViewById(R.id.edtPass);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        //Función del btn
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                //Obtengo valores nuevos
                String newEmail = String.valueOf(email.getText());
                String newPass = String.valueOf(pass.getText());
                //Actualizo el POJO
                controller.getUser().setEmail(newEmail);
                controller.getUser().setPassword(newPass);
                //Muestro los nuevos datos
                printUser(controller.getUser());
            }
        });
    }

    public void printStudentDetails(Student student){
        Log.d("MainActivity - NAME", student.getName());
        Log.d("MainActivity - SURNAME", student.getSurname());
    }

    public void printUser(User user) {
        email.setText(user.getEmail());
        pass.setText(user.getPassword());
    }
}