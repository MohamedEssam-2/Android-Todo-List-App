package com.example.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputTask;
    private LinearLayout taskContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputTask = findViewById(R.id.inputTask);
        taskContainer = findViewById(R.id.taskContainer);
    }

    public void onAddButtonClick(View view) {
        String task = inputTask.getText().toString();
        if (!task.isEmpty()) {
            addTaskToList(task);
            inputTask.setText(""); 
        }
    }


    private void addTaskToList(String task) {

        View taskView = getLayoutInflater().inflate(R.layout.task_item, taskContainer, false);


        TextView taskTextView = taskView.findViewById(R.id.taskTextView);
        CheckBox taskCheckBox = taskView.findViewById(R.id.taskCheckBox);


        taskTextView.setText(task);

        taskContainer.addView(taskView);
    }
   public void onTaskCheckedChanged(View view) {

        View taskView = (View) view.getParent();


        TextView taskTextView = taskView.findViewById(R.id.taskTextView);


        CheckBox taskCheckBox = taskView.findViewById(R.id.taskCheckBox);
        boolean isChecked = taskCheckBox.isChecked();

        if (isChecked) {
            taskTextView.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            taskTextView.setText(taskTextView.getText() + " (Completed)");
        }
        else {
            taskTextView.setTextColor(getResources().getColor(android.R.color.white));
            taskTextView.setText(taskTextView.getText().toString().replace(" (Completed)", ""));
        }

   }


    public void onRemoveButtonClick(View view) {

        View taskView = (View) view.getParent();
        taskContainer.removeView(taskView);
    }
}



