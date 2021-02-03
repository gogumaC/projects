package yubinkim.android_note.randomkeyword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import javax.xml.parsers.DocumentBuilderFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val key="E6805A7CB002BD232452351FA634CABB"
        var url="https://opendict.korean.go.kr/api/search"+key
        val xml: Document =DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url)
        xml.documentElement.normalize()


        var spinnerData= listOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
        var spinnerAdapter=ArrayAdapter<Int>(this,android.R.layout.simple_list_item_1,spinnerData)
        val list: NodeList =xml.getElementsByTagName("item")

        for(i in 0..list.length-1){
            var n: Node =list.item(i)
            if(n.getNodeType()==Node.ELEMENT_NODE){
                val elem=n as Element
                val map=mutableMapOf<String,String>()

                for(j in 0..elem.attributes.length-1) map.putIfAbsent(elem.attributes.item(j).nodeName,elem.attributes.item(j).nodeValue)
            }
        }

        spinner.adapter=spinnerAdapter
        spinner.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var viewNum=spinnerData.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }


        }
    }
}