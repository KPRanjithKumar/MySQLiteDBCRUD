package ran.am.mysqlitedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edname : EditText
    lateinit var edloc : EditText
    lateinit var tv : TextView
    lateinit var btnsave : Button
    lateinit var btnretrive : Button
    lateinit var btnupdate : Button
    lateinit var btndel : Button
    var s1 = ""
    var s2 = ""
    lateinit var dbhr : DBHlpr
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edname=findViewById(R.id.editTextTextPersonName)
        edloc=findViewById(R.id.editTextTextPersonName2)
        tv=findViewById(R.id.textView)
        btnsave=findViewById(R.id.button)
        btnretrive=findViewById(R.id.button2)
        btnupdate=findViewById(R.id.button3)
        btndel=findViewById(R.id.button4)

        dbhr = DBHlpr(applicationContext)

        btnsave.setOnClickListener {
            s1=edname.text.toString()
            s2=edloc.text.toString()
           var l = dbhr.savedat(s1,s2)
            Toast.makeText(applicationContext, "data saved successfully! "+l, Toast.LENGTH_SHORT).show();
        }

        btnretrive.setOnClickListener {
            s1=edname.text.toString()
            var loc = dbhr.retrive(s1)
            tv.text= loc
        }

        btnupdate.setOnClickListener {
            s1=edname.text.toString()
            s2=edloc.text.toString()

           var u= dbhr.updateloc(s1,s2)
            Toast.makeText(applicationContext, ""+u, Toast.LENGTH_SHORT).show();

        }

        btndel.setOnClickListener {
            s1=edname.text.toString()
            dbhr.delname(s1)


        }
    }
}