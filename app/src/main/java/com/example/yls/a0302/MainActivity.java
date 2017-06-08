package com.example.yls.a0302;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button make_call= (Button) findViewById(R.id.make_call);
        make_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!=
        PackageManager.PERMISSION_GRANTED){
    ActivityCompat.requestPermissions(MainActivity.this,new String[]{
    Manifest.permission.CALL_PHONE},1);
}else{
    call();
}
        }
});
            }
    public void call(){
        try{
            Intent intent = (new Intent(Intent.ACTION_CALL));
            intent.setData(Uri.parse("tel:18385253690"));
            startActivity(intent);
        }catch(SecurityException e){
            e.printStackTrace();
        }
    }
        public void OnRequestPermissionResult(int requestCode,String[] permission,int[] grantResults){
            switch (requestCode){
                case 1:
                    if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                        call();
                    }else{
                        Toast.makeText(this,"you denied the permission",Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
            }
        }}