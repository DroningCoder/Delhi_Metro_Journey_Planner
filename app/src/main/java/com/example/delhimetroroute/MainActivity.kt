package com.example.delhimetroroute

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sourceAutoTextView = findViewById<AutoCompleteTextView>(R.id.source)
        val destinationAutoTextView = findViewById<AutoCompleteTextView>(R.id.destination)

        val stations = resources.getStringArray(R.array.Stations)

        val Sourceadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, stations)
        sourceAutoTextView.setAdapter(Sourceadapter)

        val Destinationadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, stations)
        destinationAutoTextView.setAdapter(Destinationadapter)

        var src = ""
        var dest = ""

        sourceAutoTextView.setOnItemClickListener { adapterView, view, i, l ->
            src = adapterView.getItemAtPosition(i).toString()
            sourceAutoTextView.isSelected = true
        }

        destinationAutoTextView.setOnItemClickListener { adapterView, view, i, l ->
            dest = adapterView.getItemAtPosition(i).toString()
            destinationAutoTextView.isSelected = true
        }

        val showButton = findViewById<Button>(R.id.showbutton)

        showButton.setOnClickListener{

            //proceed to route activity only if items from both auto text views are selected

            if(sourceAutoTextView.isSelected && destinationAutoTextView.isSelected) {

                sourceAutoTextView.isSelected = false
                destinationAutoTextView.isSelected = false

                val intent = Intent(this, RouteAndFair::class.java)
                intent.putExtra("src_key", src)
                intent.putExtra("dest_key", dest)
                startActivity(intent)
            }

            //else raise a dialogue

            else{
                val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
                alertDialog.setMessage("Please Select a Station from Drop Down Menu Again.")
                alertDialog.setPositiveButton(
                    "OK"
                ) { _, _ ->
                }
                val alert: AlertDialog = alertDialog.create()
                alert.setCanceledOnTouchOutside(false)
                alert.show()
            }
        }

        //exit

        val exitButton = findViewById<Button>(R.id.exit)
        exitButton.setOnClickListener{
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
            alertDialog.setMessage("Do You Really Want To Exit?")
            alertDialog.setPositiveButton(
                "Yes"
            ) { _, _ ->
                finish()
            }
            alertDialog.setNegativeButton(
                "No"
            ) { _, _ -> }
            val alert: AlertDialog = alertDialog.create()
            alert.setCanceledOnTouchOutside(false)
            alert.show()

        }
    }
}