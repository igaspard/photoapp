package com.example.simplephoto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class MainActivity extends Activity {

    //private String imageFile = "sdcard/Pictures/sakura2.JPG";
    //public final static String EXTRA_MESSAGE = "com.example.simplephoto.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));
        
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            	Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
        	    startActivity(intent);
            }
        });
        //ImageView myImageView = (ImageView) findViewById(R.id.imageView1);
        //Load Image file from the resource.
        //myImageView.setImageResource(R.drawable.bt_9208);

        //Load Image file from target path.
        //Bitmap bitmap = BitmapFactory.decodeFile(imageFile);
        //myImageView.setImageBitmap(bitmap);

        /*Bitmap bitmap;
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
        myImageView.setImageBitmap(bitmap);*/
	}

	public class ImageAdapter extends BaseAdapter {
	    private Context mContext;

	    public ImageAdapter(Context c) {
	        mContext = c;
	    }

	    public int getCount() {
	        return mThumbIds.length;
	    }

	    public Object getItem(int position) {
	        return null;
	    }

	    public long getItemId(int position) {
	        return 0;
	    }

	    // create a new ImageView for each item referenced by the Adapter
	    public View getView(int position, View convertView, ViewGroup parent) {
	        ImageView imageView;
	        if (convertView == null) {  // if it's not recycled, initialize some attributes
	            imageView = new ImageView(mContext);
	            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
	            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            imageView.setPadding(8, 8, 8, 8);
	        } else {
	            imageView = (ImageView) convertView;
	        }

	        imageView.setImageResource(mThumbIds[position]);
	        return imageView;
	    }

	    // references to our images
	    private Integer[] mThumbIds = {
	            R.drawable.sample_2, R.drawable.sample_3,
	            R.drawable.sample_4, R.drawable.sample_5,
	            R.drawable.sample_6, R.drawable.sample_7,
	            R.drawable.sample_0, R.drawable.sample_1,
	            R.drawable.sample_2, R.drawable.sample_3,
	            R.drawable.sample_4, R.drawable.sample_5,
	            R.drawable.sample_6, R.drawable.sample_7,
	            R.drawable.sample_0, R.drawable.sample_1,
	            R.drawable.sample_2, R.drawable.sample_3,
	            R.drawable.sample_4, R.drawable.sample_5,
	            R.drawable.sample_6, R.drawable.sample_7
	    };
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}    
}
