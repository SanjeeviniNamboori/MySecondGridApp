package com.example.mysecondgridapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import  android.widget.AdapterView.OnItemClickListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView = findViewById<GridView>(R.id.gridView) as GridView

        val arrayListImage = ArrayList<Int>()
        arrayListImage.add(R.drawable.cupcake)
        arrayListImage.add(R.drawable.lollipop)
        arrayListImage.add(R.drawable.donut)
        arrayListImage.add(R.drawable.froyo)
        arrayListImage.add(R.drawable.gingerbread)
        arrayListImage.add(R.drawable.kitkat)
        arrayListImage.add(R.drawable.jellybean)



        val name = arrayOf("CUPCAKE", "LOLLIPOP", "DONUT", "FROYO", "GINGERBREAD" , "KITKAT" , "JELLY BEAN")
        val description =  arrayOf("Android Cupcake (version 1.5) is the third version of Android developed by Google , a major platform release deployable to Android-powered handsets starting in April 2009, that is no longer supported. The release included new features for users and developers, as well as changes in the Android framework API.",
            "Android Lollipop is the fifth major version of the Android mobile operating system developed by Google and the 12th version of Android, spanning versions between 5.0 and 5.1.1. Unveiled on June 25, 2014 at the Google I/O 2014 conference, it became available through official over-the-air (OTA) updates on November 12, 2014, for select devices that run distributions of Android serviced by Google (such as Nexus and Google Play edition devices). Its source code was made available on November 3, 2014. It is the fifth major update and the twelfth version of Android.",
            "Android Donut is the fourth version of the open source Android mobile operating system developed by Google that is no longer supported. Among the more prominent features introduced with this update were added support for CDMA smartphones, additional screen sizes, a battery usage indicator, and a text-to-speech engine.",
            "Android Froyo is the sixth version of Android and is a codename of the Android mobile operating system developed by Google, spanning versions between 2.2 and 2.2. 3. Those versions are no longer supported. It was unveiled on May 20, 2010, during the Google I/O 2010 conference.",
            "Android 2.3 Gingerbread is the seventh version of Android, a codename of the Android mobile operating system developed by Google and released in December 2010, for versions that are no longer supported. The Gingerbread release introduced support for near field communication (NFC)—used in mobile payment solutions—and Session Initiation Protocol (SIP)—used in VoIP internet telephones.",
            " Android KitKat is the codename for the eleventh version of the Android mobile operating system, representing release version 4.4. Unveiled on September 3, 2013, KitKat focused primarily on optimizing the operating system for improved performance on entry-level devices with limited resources.",
            "Android Jelly Bean is the codename given to the tenth version of the Android mobile operating system developed by Google, spanning three major point releases (versions 4.1 through 4.3. 1). Among the devices that run Android 4.3 are the Asus Nexus 7 (2013)")
        val referenceUrls = arrayOf("https://en.wikipedia.org/wiki/Android_Cupcake",
           "https://en.wikipedia.org/wiki/Android_Lollipop",
            "https://en.wikipedia.org/wiki/Android_Donut",
            "https://en.wikipedia.org/wiki/Android_Froyo",
            "https://en.wikipedia.org/wiki/Android_Gingerbread",
            "https://en.wikipedia.org/wiki/Android_kitkat",
            "https://en.wikipedia.org/wiki/Android_Jelly_Bean"
        )
        val customAdapter =  CustomAdapter(this@MainActivity, arrayListImage, name)
        gridView.adapter = customAdapter

        /*gridView.setOnItemClickListener(  OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>, parent, View view, int position, long id){
                Intent intent = new Intent(MainActivity.this, ItemDetails.class);
                        intent.putExtra("image",arrayListImage[position])
                startActivity(intent)
            }
        }) */

        //On Click for GridView Item

        gridView.setOnItemClickListener { adapterView, parent, position, l ->
           // Toast.makeText(this@MainActivity, "Click on : " + name[position], Toast.LENGTH_LONG).show()
        val intent = Intent(this@MainActivity, ItemDetails::class.java)
            intent.putExtra(
            "name" ,name[position].capitalize())
            intent.putExtra("description", description[position])
            intent.putExtra("image", arrayListImage[position])
            intent.putExtra("wikiUrl", referenceUrls[position])
        startActivity(intent)
        }
    }
}

