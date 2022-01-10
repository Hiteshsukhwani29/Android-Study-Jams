package com.hitesh.genie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnFailureListener

import com.google.android.gms.tasks.OnSuccessListener

import androidx.recyclerview.widget.LinearLayoutManager
import com.hitesh.genie.adapter.quotesAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*


class Quotes : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var quotesArrayList: ArrayList<quotesModel>
    lateinit var quotesAdapter: quotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v:View = inflater.inflate(R.layout.fragment_quotes, container, false)

        recyclerView = v.findViewById<RecyclerView>(R.id.rv_quotes)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(
            LinearLayoutManager(context)
        )

        quotesArrayList = arrayListOf()

        quotesAdapter = quotesAdapter(quotesArrayList)
        recyclerView.adapter = quotesAdapter


        val db = FirebaseFirestore.getInstance()

        db.collection("Quotes").addSnapshotListener(object:EventListener<QuerySnapshot>{
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if(error!=null){
                    Toast.makeText(activity, "Try again", Toast.LENGTH_SHORT).show()
                    return
                }

                for(d:DocumentChange in value?.documentChanges!!){
                    if(d.type==DocumentChange.Type.ADDED)
                    {
                        quotesArrayList.add(d.document.toObject(quotesModel::class.java))
                    }
                    quotesAdapter.notifyDataSetChanged()
                }

            }

        })

        return v;
    }
}