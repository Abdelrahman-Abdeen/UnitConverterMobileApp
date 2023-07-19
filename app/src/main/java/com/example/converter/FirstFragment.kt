package com.example.converter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val spinner1: Spinner = view.findViewById(R.id.spinner1)
        val spinner2: Spinner = view.findViewById(R.id.spinner2)
        val options1 = arrayOf("Kilometer", "Mile")
        val options2= arrayOf("Mile","Kilometer")

        val resView:TextView = view.findViewById(R.id.ResultView)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, options1)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val adapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, options2)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = adapter
        spinner2.adapter = adapter2

        val resBtn: Button = view.findViewById(R.id.ResBtn)
        val myval: EditText = view.findViewById(R.id.Value)

        var selectedItem1:String?=null
        var selectedItem2:String?=null

        resBtn.setOnClickListener {
            val selectedValue1 = spinner1.selectedItem.toString()
            val selectedValue2 = spinner2.selectedItem.toString()

            val myVal = myval.text.toString().toDouble()
            val value = myval.text.toString()

            if(selectedValue1=="Kilometer" && selectedValue2=="Mile"){
                var newVal :Double = myVal/1.6;
                resView.text =newVal.toString()
            }
            if(selectedValue1=="Kilometer" && selectedValue2=="Kilometer"){
                resView.text =value.toString()
            }
            if(selectedValue1=="Mile" && selectedValue2=="Mile"){
                resView.text =value.toString()
            }
            if(selectedValue1=="Mile" && selectedValue2=="Kilometer"){
                var newVal :Double = myVal*1.6;
                resView.text =newVal.toString()
            }

            if(selectedValue2=="Kilometer"){
                resView.text = resView.text.toString()+" km"
            }
            if(selectedValue2=="Mile"){
                resView.text = resView.text.toString()+" mi"
            }


            // Perform necessary actions based on the selected values and input value
        }

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                 selectedItem1 = options1[position]
                // Perform actions based on the selected item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
                TODO("Not yet implemented")
            }
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedItem2 = options1[position]
                // Perform actions based on the selected item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
                TODO("Not yet implemented")
            }
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
