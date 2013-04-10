package com.example.simplephoto;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View;


public class MainActivity extends Activity {

    private String imageFile = "sdcard/Pictures/sakura2.JPG";
    public final static String EXTRA_MESSAGE = "com.example.simplephoto.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        ImageView myImageView = (ImageView) findViewById(R.id.imageView1);
        //Load Image file from the resource.
        //myImageView.setImageResource(R.drawable.bt_9208);

        //Load Image file from target path.
        //Bitmap bitmap = BitmapFactory.decodeFile(imageFile);
        //myImageView.setImageBitmap(bitmap);

        Bitmap bitmap;
        float imagew = 400;
        float imageh = 300;

        BitmapFactory.Options bitmapFactoryOptions = new BitmapFactory.Options();
        bitmapFactoryOptions.inJustDecodeBounds = true;
        bitmap = BitmapFactory.decodeFile(imageFile, bitmapFactoryOptions);

        int yRatio = (int) Math.ceil(bitmapFactoryOptions.outHeight/imageh);
        int xRatio = (int) Math.ceil(bitmapFactoryOptions.outWidth/imagew);

        if (yRatio > 1 || xRatio > 1) {
            if (yRatio > xRatio) {
                bitmapFactoryOptions.inSampleSize = yRatio;
                Toast.makeText(this, "yRatio = " + String.valueOf(yRatio), Toast.LENGTH_LONG).show();
            }
            else {
                bitmapFactoryOptions.inSampleSize = xRatio;
                Toast.makeText(this, "xRatio = " + String.valueOf(xRatio), Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, "inSampleSize = 1" + String.valueOf(xRatio), Toast.LENGTH_LONG).show();
        }

        bitmapFactoryOptions.inJustDecodeBounds = false;
        bitmap = BitmapFactory.decodeFile(imageFile, bitmapFactoryOptions);
        myImageView.setImageBitmap(bitmap);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

    public void sendMessage(View view) {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
	    EditText editText = (EditText) findViewById(R.id.editText1);
	    String message = editText.getText().toString();
	    intent.putExtra(EXTRA_MESSAGE, message);
	    startActivity(intent);
    }

    public void ShowGrid(View view) {
    	Intent intent = new Intent(this, PhotoGridActivity.class);
	    startActivity(intent);
    }
}
