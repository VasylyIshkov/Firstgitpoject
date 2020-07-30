package com.example.myapplication;

import com.example.myapplication.base.BaseActivity;

public class AddPhone extends BaseActivity {

//    private AppCompatButton ok, cansel;
//    private AppCompatEditText namePhone, ram, modelCPU;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment_test);
//        initToolbar(getString(R.string.addPhone));
//        ok = findViewById(R.id.bnt_ok);
//        cansel = findViewById(R.id.bnt_cansel);
//        namePhone = findViewById(R.id.add_name_phone);
//        ram = findViewById(R.id.add_ram);
//        modelCPU = findViewById(R.id.add_model_cpu);
//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setResultMain();
//            }
//        });
//        cansel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Intent intent = new Intent();
//                setResult(RESULT_CANCELED);
//                finish();
//            }
//        });
//    }
//
//    public void setResultMain() {
//        String newNamePhone = namePhone.getText().toString();
//        String newRam = ram.getText().toString();
//        String newModelCPU = modelCPU.getText().toString();
//        if (!newModelCPU.equals("") && !newNamePhone.equals(" ") && !newRam.equals(" ")) {
//            Intent intent = new Intent();
//            intent.putExtra(Constants.NAME_PHONE, newNamePhone);
//            intent.putExtra(Constants.RAM, newRam);
//            intent.putExtra(Constants.MODEL_CPU, newModelCPU);
//            setResult(RESULT_OK, intent);
//            finish();
//        } else {
//            Toast.makeText(this, "Не все поля заполненны!!!", Toast.LENGTH_LONG).show();
//        }
//    }
}
