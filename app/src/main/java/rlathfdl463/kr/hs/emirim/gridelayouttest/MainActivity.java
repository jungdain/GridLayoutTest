package rlathfdl463.kr.hs.emirim.gridelayouttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button[] butNums = new Button[10];
    Button[] butOps = new Button[4];
    public static final  int SELECT_EDIT1=0;
    public static final  int SELECT_EDIT2=1;
    int selectEdit=SELECT_EDIT1;
    String numStr="";
    TextView textResult;

    //    int[] ids={R.id.but_num1,R.id.but_num2,R.id.but_num3,R.id.but_num4,R.id.but_num5,
    //              R.id.but_num6,R.id.but_num7 R.id.but_num8,R.id.but_num9,R.id.but_num10}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=(EditText)findViewById(R.id.ga1);
        edit2=(EditText)findViewById(R.id.ga2);
        edit1.setOnTouchListener(editHandler);
        edit2.setOnTouchListener(editHandler);
        textResult=(TextView)findViewById(R.id.text_result);

        for (int i = 0; i < butNums.length; i++) {
//            butNums[i]=(Button)findViewById(R.id.but_num1+i)
            butNums[i] = (Button) findViewById(R.id.but_num1 + i);
            butNums[i].setOnClickListener(butNumHandler);
        }

        for (int i = 0; i < butOps.length; i++){
            butOps[i] = (Button) findViewById(R.id.but_op1 + i);
            butOps[i].setOnClickListener(butOpHandler);
        }

}
    View.OnClickListener butNumHandler=new  View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button but=(Button) view;
            numStr += but.getText();
            switch (selectEdit) {
                case SELECT_EDIT1:
                    edit1.setText(numStr);
                    break;
            }
        }
    };
    View.OnClickListener butOpHandler=new  View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int num1 = Integer.parseInt(edit1.getText().toString());
            int num2 = Integer.parseInt(edit2.getText().toString());
            double result=0;

            switch(view.getId()) {
                case R.id.but_op1:
                    result=num1+num2;
                    break;
                case R.id.but_op2:
                    result=num1-num2;
                    break;
                case R.id.but_op3:
                    result=num1*num2;
                    break;
                case R.id.but_op4:
                    result=(double)num1/num2;
                    break;
                }//end switch
            textResult.setText("* 계산 결과 ="+result);
            }
        };


        View.OnTouchListener editHandler=new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                numStr="";
                switch (view.getId()) {
                    case R.id.ga1:
                        selectEdit=SELECT_EDIT1;
                        break;
                    case R.id.ga2:
                        selectEdit=SELECT_EDIT2;
                        break;
                }
                return true;
            }
        };
}
