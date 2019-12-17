public  void addRecord(View view){
        DbManager db=new DbManager(this);
        String res=db.addRecord(tempTxt.getText().toString(),temp_minTxt.getText().toString(),temp_maxTxt.getText().toString(),statusTxt.getText().toString(),updated_atTxt.getText().toString(),city.getText().toString());
        Toast.makeText(this,res,Toast.LENGTH_LONG).show();

    }
