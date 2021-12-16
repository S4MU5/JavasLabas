в MainActivity:  
```Java
@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mDialButton = (Button) findViewById(R.id.callButton);
        final EditText mPhoneNoEt = (EditText) findViewById(R.id.editTextPhone);
        final EditText smsEdit = (EditText) findViewById(R.id.smsText);

        mDialButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String phoneNo = mPhoneNoEt.getText().toString();
                if(!TextUtils.isEmpty(phoneNo))
                {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
                else {
                    Toast.makeText(MainActivity.this, "Введите номер телефона", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void onSms(View view)
    {
        EditText edit_Number=(EditText)findViewById(R.id.editTextPhone);
        String phoneNo = edit_Number.getText().toString();
        EditText sms_edit=(EditText)findViewById(R.id.smsText);
        String toSms="smsto:"+edit_Number.getText().toString();
        String messageText= sms_edit.getText().toString();
        Intent sms=new Intent(Intent.ACTION_SENDTO, Uri.parse(toSms));

        sms.putExtra("sms_body", messageText);
        startActivity(sms);
        SmsManager.getDefault().sendTextMessage(phoneNo, null, messageText.toString(), null, null);
    }
```  
Проверим работу приложения на устройстве:  
![image info](/images/mob_lab11_1.jpg)  
