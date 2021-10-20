package ran.am.mysqlitedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edname : EditText
    lateinit var edname2 : EditText
    lateinit var edname3 : EditText
    lateinit var edname4 : EditText
    lateinit var edloc : EditText
    lateinit var edloc2 : EditText
    lateinit var tv : TextView
    lateinit var btnsave : Button
    lateinit var btnretrive : Button
    lateinit var btnupdate : Button
    lateinit var btndel : Button
    
    lateinit var dbhr : DBHlpr
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edname=findViewById(R.id.editTextTextPersonName)
        edname2=findViewById(R.id.editTextTextPersonName4)
        edname3=findViewById(R.id.editTextTextPersonName5)
        edname4=findViewById(R.id.editTextTextPersonName7)
        edloc=findViewById(R.id.editTextTextPersonName2)
        edloc2=findViewById(R.id.editTextTextPersonName6)
        tv=findViewById(R.id.textView)
        btnsave=findViewById(R.id.button)
        btnretrive=findViewById(R.id.button2)
        btnupdate=findViewById(R.id.button3)
        btndel=findViewById(R.id.button4)

        dbhr = DBHlpr(applicationContext)

        btnsave.setOnClickListener {
            var s1=edname.text.toString()
            var s2=edloc.text.toString()
           var l = dbhr.savedat(s1,s2)
            Toast.makeText(applicationContext, "data saved successfully! "+l, Toast.LENGTH_SHORT).show();
        }

        btnretrive.setOnClickListener {
            var loc = dbhr.retrive(edname2.text.toString())

            tv.text= loc
            Toast.makeText(applicationContext, "retrive success"+loc, Toast.LENGTH_SHORT).show();
            
        }

        btnupdate.setOnClickListener {
           // var s1=
           // var s2=

           var u= dbhr.updateloc(edname3.text.toString(),edloc2.text.toString())
            Toast.makeText(applicationContext, "update success"+u, Toast.LENGTH_SHORT).show();

        }

        btndel.setOnClickListener {
            var s1=edname4.text.toString()
            dbhr.delname(s1)
            Toast.makeText(applicationContext, "delete success!", Toast.LENGTH_SHORT).show();

        }
    }
}